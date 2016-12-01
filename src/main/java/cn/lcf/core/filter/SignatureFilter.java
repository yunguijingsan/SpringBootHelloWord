package cn.lcf.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import cn.lcf.core.commons.ServletObjectContext;

@WebFilter(filterName="signatureFilter",urlPatterns="/*")
public class SignatureFilter implements Filter {
    public SignatureFilter() {
        super();
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    	System.out.println("signatureFilter init ……");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        ServletRequest requestWrapper = null;
        String contentType = request.getContentType();
        if(null == contentType || "".equals(contentType) || contentType.toLowerCase().contains("multipart/form-data")){
            
        } else if (request instanceof HttpServletRequest) {
            requestWrapper = new SignatureRequestWrapper((HttpServletRequest) request,ServletObjectContext.getToken());
        }
        if (requestWrapper == null) {
            chain.doFilter(request, response);
        } else {
            chain.doFilter(requestWrapper, response);
        }

    }

    @Override
    public void destroy() {
        // TODO Implement this method
    }
}

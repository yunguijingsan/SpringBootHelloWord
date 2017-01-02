package cn.lcf.core.filter;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import cn.lcf.core.commons.DesEncrypt;



public class SignatureRequestWrapper extends HttpServletRequestWrapper {


    private final String requestBody;
    

    public SignatureRequestWrapper(HttpServletRequest request,String token) throws IOException {
        super(request);
//        System.out.println("desKey秘钥:"+token);
        ServletInputStream stream = this.getRequest().getInputStream();
        String body  = IOUtils.toString(stream, "UTF-8");
//        System.out.println("未解密请求体:"+body);
        try {
            if(!StringUtils.isBlank(body) && ! body.trim().startsWith("{")){
               body = DesEncrypt.decrypt(body, token);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        requestBody = body;
//        System.out.println("解密后请求体:"+requestBody);
    }

    @Override
    public ServletInputStream getInputStream() {
        final ByteArrayInputStream bais;
        ServletInputStream newStream = null;
        try {
            bais = new ByteArrayInputStream(requestBody.getBytes("UTF-8"));
            newStream = new ServletInputStream() {
                @Override
                public int read() throws IOException {
                    return bais.read();
                }

				@Override
				public boolean isFinished() {
					return false;
				}

				@Override
				public boolean isReady() {
					return false;
				}

				@Override
				public void setReadListener(ReadListener arg0) {
					
				}
            };
         
        } catch (Exception e) {
          e.printStackTrace();
        }
        return newStream;
    }


    public String getRequestBody() {
        return requestBody;
    }
}

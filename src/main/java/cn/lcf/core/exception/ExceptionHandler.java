package cn.lcf.core.exception;

import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import cn.lcf.core.spring.CustomFastJsonHttpMessageConverter;

/**
 * 统一的异常处理
 */
@Component
@SuppressWarnings({"rawtypes" })
public class ExceptionHandler implements HandlerExceptionResolver {


    
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        ResponseResult responseResult = null;
        ModelAndView modelAndView = null;
        try {
        	ex.printStackTrace();
            if (ex instanceof NotLoginException) {
                responseResult = ResponseResult.createNotLogin();
            } else if (ex instanceof NotAuthorizedException) {
                responseResult = ResponseResult.createNotAuthorized();
            } else if (ex instanceof RequestTimeoutException) {
                responseResult = ResponseResult.createRequestTimeout();
            } else if(ex instanceof SignatureException){
                responseResult = ResponseResult.createSignError();
            } else if (ex instanceof ServiceException) {
                ServiceException serviceException = (ServiceException) ex;
                responseResult = ResponseResult.createFail(serviceException.getResultCode(),serviceException.getAdditionalMessage());
            }else if (ex instanceof ControllerException) {
                ControllerException controllerException = (ControllerException) ex;
                this.setMessage(controllerException);
                String url = controllerException.getUrl();
                modelAndView = new ModelAndView((null==url || "".equals(url)) ? "start/500" : url);
                modelAndView.addObject("message", controllerException.getMessage());
                return modelAndView;
            } else {
                responseResult = ResponseResult.createError();
            }
            responseResult.setMessage(ex.getMessage());
            setMessage(responseResult);
            if(request.getRequestURI().contains(".html") ||request.getRequestURI().endsWith(".js") ){
                    response.setStatus(401); 
            }
            
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/plain");
            CustomFastJsonHttpMessageConverter.writeResponseResult(response.getOutputStream(), responseResult,
                                                                   Charset.forName("UTF-8"));
            return new ModelAndView();
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return new ModelAndView("notAuthResource");
    }

	private void setMessage(ControllerException controllerException) {
		// TODO Auto-generated method stub
	}

	private void setMessage(ResponseResult responseResult) {
		// TODO Auto-generated method stub
	}

}

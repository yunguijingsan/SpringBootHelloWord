package cn.lcf.core.exception;


/**
 *
 * 用于跳转错误页 并携带信息 message
 *
 */
public class ControllerException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String url;
    private String resultCode;
    private String message;
    
    private ControllerException(ServiceException serviceException){
        this.resultCode = serviceException.getResultCode();
    }
    
    private ControllerException(Exception exception){
        this.message = exception.getMessage();
    }
    
    private ControllerException(String url) {
        this.url = url;
    }

    private ControllerException(String url, String resultCode, String message) {
        this.url = url;
        this.message = message;
        this.resultCode = resultCode;
    }

    private ControllerException(String url, String message) {
        this.url = url;
        this.message = message;
    }

    public static ControllerException create(Exception exception){
        if(exception instanceof ServiceException){
            ServiceException serviceException = (ServiceException)exception;
            return new ControllerException(serviceException);
        }
        return new ControllerException(exception);
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultCode() {
        return resultCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }
}

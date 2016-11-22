package cn.lcf.core.exception;

public class RequestTimeoutException extends ServiceException {
    private static final long serialVersionUID = 1L;

    public static RequestTimeoutException create(){
      return  new RequestTimeoutException();
    }
}

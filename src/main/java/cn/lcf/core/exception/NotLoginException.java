package cn.lcf.core.exception;

public class NotLoginException extends ServiceException{
    private static final long serialVersionUID = -5812347871340744593L;
    
    public static NotLoginException create(){
      return  new NotLoginException();
    }
}

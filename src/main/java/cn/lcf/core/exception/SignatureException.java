package cn.lcf.core.exception;


public class SignatureException extends ServiceException {
    private static final long serialVersionUID = 1L;

    public static SignatureException create(){
      return  new SignatureException();
    }
}

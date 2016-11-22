package cn.lcf.core.exception;

public class NotAuthorizedException extends ServiceException{
    private static final long serialVersionUID = 4065879046927993115L;
    public static NotAuthorizedException create(){
      return  new NotAuthorizedException();
    }
}

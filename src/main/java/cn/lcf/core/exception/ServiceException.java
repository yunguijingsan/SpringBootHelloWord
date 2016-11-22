package cn.lcf.core.exception;

public class ServiceException  extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String resultCode;
    private String message;
    private Object [] additionalMessage;
    
    protected ServiceException() {
        super();
    }
    private ServiceException(String resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    private ServiceException(String resultCode, String message,Object[] additionalMessage) {
        this.resultCode = resultCode;
        this.message = message;
        this.additionalMessage = additionalMessage;
    }
    /**
     * 根据定义的结果码创建异常   
     * 会自动使用在资源文件中定义的结果码的消息
     * 记得在资源文件中定义结果码
     * @param resultCode 结果码
     * @return
     */
    public static ServiceException create(String resultCode){
        
      return  new ServiceException(resultCode,"");
    }

    public static ServiceException create(String resultCode,Object[] additionalMessage){
      return  new ServiceException(resultCode,"",additionalMessage);
    }
    public String getResultCode() {
        return resultCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public void setAdditionalMessage(Object[] additionalMessage) {
        this.additionalMessage = additionalMessage;
    }

    public Object[] getAdditionalMessage() {
        return additionalMessage;
    }
}

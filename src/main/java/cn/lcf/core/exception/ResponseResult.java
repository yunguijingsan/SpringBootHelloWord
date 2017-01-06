package cn.lcf.core.exception;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.hibernate.type.TrueFalseType;
import org.springframework.mock.staticmock.MockStaticEntityMethods;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 *
 * 统一的返回结果
 */
@ApiModel(description="统一的返回结果")
public class ResponseResult<T> implements Serializable{
    private static final long serialVersionUID = -6317348280525129379L;

    /**
     * 状态码
     * 1：业务成功
     * 2：业务失败
     * 3：系统异常  未处理的异常
     * 4：未登录
     * 5：无权限
     * 6：请求失效,可能是因为超时或者重复提交
     * 7：签名错误
     */
    @ApiModelProperty(value="状态码",example="1",readOnly=true,required=true)
    private int status;
    /*
	 * 业务失败结果码 只有状态码为 2 时才生效，状态码不为 2时业务结果为 0
	 */
    @ApiModelProperty(value="业务失败结果码",readOnly=true,required=true)
    private String resultCode;
    // 消息
    @ApiModelProperty(value="业务失败返回消息",readOnly=true,required=true)
    private String message;
    //附加信息
    @JsonIgnore  
    private Object[] additionalMessage;
    // 返回的数据
    @ApiModelProperty(value="返回数据",example="{}",readOnly=true,required=true)
    private T data;
    // 是否不加密，true是不对返回结果进行加密,为false时对返回结果进行加密
    @JsonIgnore  
    private boolean doNotEncrypt;
    
    private ResponseResult(){
        
    }
    public static ResponseResult<?> createSignError() {
        return ResponseResult.createFail(7, "PUBLIC.SIGN.ERROR");
    }
    public static ResponseResult<?>  createRequestTimeout() {
        return ResponseResult.createFail(6, "PUBLIC.REQUEST.TIMEOUT");
    }
    public static ResponseResult<?>  createNotAuthorized() {
        return ResponseResult.createFail(5, "PUBLIC.SYSTEM.NOT.AUTHORIZED");
    }

    public static ResponseResult<?>  createNotLogin() {
        return ResponseResult.createFail(4, "PUBLIC.SYSTEM.NOT.LOGIN");
    }

    public static ResponseResult<?>  createError() {
        return ResponseResult.createFail(3, "PUBLIC.SYSTEM.ERROR");
    }

    /**
     *创建业务失败的返回结果对象
     * @param resultCode 传入结果码
     * @return 业务失败的返回结果对象
     */
    public static ResponseResult<?>  createFail(String resultCode) {
        return ResponseResult.createFail(2, resultCode);
    }
    public static ResponseResult<?>  createFail(String resultCode,Object[] additionalMessage) {
        return ResponseResult.createFail(2, resultCode,additionalMessage);
    }
    private static ResponseResult<?>  createFail(int status, String resultCode) {
        return ResponseResult.createResponseResult(status, resultCode, null, null);
    }
    private static ResponseResult<?>  createFail(int status, String resultCode,Object[] additionalMessage) {
        return ResponseResult.createResponseResult(status, resultCode, null, null,false,additionalMessage);
    }
    /**
     *创建业务成功的返回结果，无返回数据和无返回消息时使用
     * @return 业务成功的返回结果对象
     */
    public static <T> ResponseResult<T> createSuccess() {
        return ResponseResult.createSuccessWithMessage("成功", null);
    }

    /**
     * 创建业务成功的返回结果  有返回数据时使用
     * @param data
     * @return
     */
    public static <T> ResponseResult<T>    createSuccess(T data) {
        return ResponseResult.createResponseResult(1, "0", "", data);
    }
    /**
     * 创建业务成功的返回结果  有返回数据时使用
     * @param data
     * @return
     */
    public static <T> ResponseResult<T>  createNotEncryptSuccess(T data) {
        return ResponseResult.createResponseResult(1, "0", "", data,true,null);
    }
    /**
     * 创建业务成功的返回结果 有返回消息时使用
     * @param data
     * @return
     */
    public static <T> ResponseResult<T>   createSuccessWithMessage(String message) {
        return ResponseResult.createSuccessWithMessage(message, null);
    }

    /**
     * 创建业务成功的返回结果 有返回消息和返回数据时使用
     * @param data
     * @return
     */
    public static <T> ResponseResult<T>  createSuccessWithMessage(String message, T data) {
        return ResponseResult.createResponseResult(1, "0", message, data);
    }

    private static <T> ResponseResult<T> createResponseResult(int status, String resultCode, String message, T data) {
        return new ResponseResult<T>(status, resultCode, message, data,false,null);
    }

    private static <T> ResponseResult<T> createResponseResult(int status, String resultCode, String message, T data,boolean doNotEncrypt,Object[] additionalMessage) {
        return new ResponseResult<T>(status, resultCode, message, data,doNotEncrypt,additionalMessage);
    }
    private ResponseResult(int status, String resultCode, String message, T data,boolean doNotEncrypt,Object[] additionalMessage) {
        this.status = status;
        this.resultCode = resultCode;
        this.message = message;
        this.data = data;
        this.doNotEncrypt = doNotEncrypt;
        this.additionalMessage = additionalMessage;
        this.includeNative(ResponseResult.class, "status","data","message","resultCode");  
//        this.excludeLocal(ResponseResult.class, "includeMap", "excludeMap","doNotEncrypt","additionalMessage");
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setDoNotEncrypt(boolean doNotEncrypt) {
        this.doNotEncrypt = doNotEncrypt;
    }

    public boolean isDoNotEncrypt() {
        return doNotEncrypt;
    }

    public void setAdditionalMessage(Object[] additionalMessage) {
        this.additionalMessage = additionalMessage;
    }

    public Object[] getAdditionalMessage() {
        return additionalMessage;
    }


    /**
     * 指定某个类在序列化时包含的属性，如果指定了，则这个类在序列化时，只会序列化指定的属性
     * 如果重复指定,则后指定的回覆盖之前的
     * 使用方法，例如返回的Documents对象只返回,documentId,creationDate,url 三个字段
     *  ResponseResult.createSuccess(document).include(Documents.class, "documentId","creationDate","url")
     *
     * @param clazz  要指定的类型
     * @param properties  指定的属性名
     * @return
     */
    public ResponseResult<T> include(Class<?> clazz, String... properties) {
        if (clazz.equals(ResponseResult.class)) {
            throw ServiceException.create("PUBLIC.PROPERTY.FILTER.ILLIGAL");
        }
        includeMap.put(clazz, this.getSetFromProperties(properties));
        return this;
    }
    /**
     * 指定某个类在序列化时不包含的属性，如果指定了不包含的属性，则这个类在序列化时，不会序列化指定的属性
     * 如果一个类包含了指定了序列化时包含的属性(includeMap)，则指定不包含的属性不会生效，
     * 
     * 使用方法，例如返回的Documents对象不需要返回creationDate
     *      ResponseResult.createSuccess(document).exclude(Documents.class, "creationDate")
     *  
     * @param clazz  要指定的类型
     * @param properties  指定不包含的属性名
     * @return
     */
    public ResponseResult<T> exclude(Class<?> clazz, String... properties) {
        if (clazz.equals(ResponseResult.class)) {
            throw ServiceException.create("PUBLIC.PROPERTY.FILTER.ILLIGAL");
        }
        excludeMap.put(clazz, this.getSetFromProperties(properties));
        return this;
    }

    private void includeNative(Class<?> clazz, String... properties) {
        includeMap.put(clazz, this.getSetFromProperties(properties));
    }
    
    private Set<String> getSetFromProperties(String... properties) {
        Set<String> set = new HashSet<String>();
        for (String property : properties) {
            if(null != property || !"".equals(property)){
                set.add(property.toUpperCase());
            }
        }
        return set;
    }
    public Map<Class<?>, Set<String>> getIncludeMap() {
        return this.includeMap;
    }
    public Map<Class<?>, Set<String>> getExcludeMap() {
        return this.excludeMap;
    }
    
	@JsonIgnore  
    private final Map<Class<?>, Set<String>> includeMap = new HashMap<Class<?>, Set<String>>();
    @JsonIgnore  
    private final Map<Class<?>, Set<String>> excludeMap = new HashMap<Class<?>, Set<String>>();

}

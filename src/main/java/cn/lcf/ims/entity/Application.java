package cn.lcf.ims.entity;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

public class Application {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column application.id
     *
     * @mbg.generated Mon Jan 02 19:26:45 GMT+08:00 2017
     */
	@ApiModelProperty(value="应用ID",position=-1,readOnly=true)
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column application.name
     *
     * @mbg.generated Mon Jan 02 19:26:45 GMT+08:00 2017
     */
	@ApiModelProperty(value="应用名称",required=true,position=-3)
	@ApiParam
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column application.code
     *
     * @mbg.generated Mon Jan 02 19:26:45 GMT+08:00 2017
     */
	@ApiModelProperty(value="应用简称",required=true,allowableValues="public,private",position=-3)
	@ApiParam
    private String code;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column application.description
     *
     * @mbg.generated Mon Jan 02 19:26:45 GMT+08:00 2017
     */
	@ApiModelProperty(value="应用描述",position=-1)
	@ApiParam
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column application.base_path
     *
     * @mbg.generated Mon Jan 02 19:26:45 GMT+08:00 2017
     */
	@ApiModelProperty(value="应用路径")
    private String basePath;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column application.id
     *
     * @return the value of application.id
     *
     * @mbg.generated Mon Jan 02 19:26:45 GMT+08:00 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column application.id
     *
     * @param id the value for application.id
     *
     * @mbg.generated Mon Jan 02 19:26:45 GMT+08:00 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column application.name
     *
     * @return the value of application.name
     *
     * @mbg.generated Mon Jan 02 19:26:45 GMT+08:00 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column application.name
     *
     * @param name the value for application.name
     *
     * @mbg.generated Mon Jan 02 19:26:45 GMT+08:00 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column application.code
     *
     * @return the value of application.code
     *
     * @mbg.generated Mon Jan 02 19:26:45 GMT+08:00 2017
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column application.code
     *
     * @param code the value for application.code
     *
     * @mbg.generated Mon Jan 02 19:26:45 GMT+08:00 2017
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column application.description
     *
     * @return the value of application.description
     *
     * @mbg.generated Mon Jan 02 19:26:45 GMT+08:00 2017
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column application.description
     *
     * @param description the value for application.description
     *
     * @mbg.generated Mon Jan 02 19:26:45 GMT+08:00 2017
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column application.base_path
     *
     * @return the value of application.base_path
     *
     * @mbg.generated Mon Jan 02 19:26:45 GMT+08:00 2017
     */
    public String getBasePath() {
        return basePath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column application.base_path
     *
     * @param basePath the value for application.base_path
     *
     * @mbg.generated Mon Jan 02 19:26:45 GMT+08:00 2017
     */
    public void setBasePath(String basePath) {
        this.basePath = basePath == null ? null : basePath.trim();
    }
}
package cn.lcf.ims.condition;

import io.swagger.annotations.ApiParam;
import cn.lcf.core.entity.Page;
import cn.lcf.ims.entity.Application;

public class ApplicationCondition extends Page<Application> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiParam(value = "应用名称")
	private String name;
	@ApiParam(value = "应用简称")
	private String code;
	@ApiParam(value = "应用路径")
	private String basePath;
	@ApiParam(value = "应用描述")
	private String description;
	@ApiParam(value = "包含应用名称")
	private String likeName;
	@ApiParam(value = "包含应用简称")
	private String likeCode;
	@ApiParam(value = "包含应用路径")
	private String likeBasePath;
	@ApiParam(value = "包含应用描述")
	private String likeDescription;

	public String getLikeName() {
		return likeName;
	}

	public void setLikeName(String likeName) {
		this.likeName = likeName;
	}

	public String getLikeCode() {
		return likeCode;
	}

	public void setLikeCode(String likeCode) {
		this.likeCode = likeCode;
	}

	public String getLikeBasePath() {
		return likeBasePath;
	}

	public void setLikeBasePath(String likeBasePath) {
		this.likeBasePath = likeBasePath;
	}

	public String getLikeDescription() {
		return likeDescription;
	}

	public void setLikeDescription(String likeDescription) {
		this.likeDescription = likeDescription;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

package cn.lcf.ims.condition;

import java.util.Map;

import cn.lcf.core.Page;
import cn.lcf.ims.entity.Application;


public class ApplicationCondition extends Page<Application> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   
	private String name;
	private String code;
	private String basePath;
	private String description;
	private String likeName;
	private String likeCode;
	private String likeBasePath;
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

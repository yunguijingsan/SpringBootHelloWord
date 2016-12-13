package cn.lcf.ims.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the url database table.
 * 
 */
@Entity
@Table(name = "url")
public class Url implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String contentType;
	private String description;
	private String method;
	private String name;
	private String path;
	private List<Caze> cazes;
	private List<GroupUrl> groupUrls;
	private List<ParamDefinetion> paramDefinetions;
	private Application application;

	public Url() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getContentType() {
		return this.contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}


	//bi-directional many-to-one association to Caze
	@OneToMany(mappedBy="url")
	public List<Caze> getCazes() {
		return this.cazes;
	}

	public void setCazes(List<Caze> cazes) {
		this.cazes = cazes;
	}

	public Caze addCaze(Caze caze) {
		getCazes().add(caze);
		caze.setUrl(this);

		return caze;
	}

	public Caze removeCaze(Caze caze) {
		getCazes().remove(caze);
		caze.setUrl(null);

		return caze;
	}


	//bi-directional many-to-one association to GroupUrl
	@OneToMany(mappedBy="url")
	public List<GroupUrl> getGroupUrls() {
		return this.groupUrls;
	}

	public void setGroupUrls(List<GroupUrl> groupUrls) {
		this.groupUrls = groupUrls;
	}

	public GroupUrl addGroupUrl(GroupUrl groupUrl) {
		getGroupUrls().add(groupUrl);
		groupUrl.setUrl(this);

		return groupUrl;
	}

	public GroupUrl removeGroupUrl(GroupUrl groupUrl) {
		getGroupUrls().remove(groupUrl);
		groupUrl.setUrl(null);

		return groupUrl;
	}


	//bi-directional many-to-one association to ParamDefinetion
	@OneToMany(mappedBy="url")
	public List<ParamDefinetion> getParamDefinetions() {
		return this.paramDefinetions;
	}

	public void setParamDefinetions(List<ParamDefinetion> paramDefinetions) {
		this.paramDefinetions = paramDefinetions;
	}

	public ParamDefinetion addParamDefinetion(ParamDefinetion paramDefinetion) {
		getParamDefinetions().add(paramDefinetion);
		paramDefinetion.setUrl(this);

		return paramDefinetion;
	}

	public ParamDefinetion removeParamDefinetion(ParamDefinetion paramDefinetion) {
		getParamDefinetions().remove(paramDefinetion);
		paramDefinetion.setUrl(null);

		return paramDefinetion;
	}


	//bi-directional many-to-one association to Application
	@ManyToOne
	@JoinColumn(name="applicationId")
	public Application getApplication() {
		return this.application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

}
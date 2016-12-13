package cn.lcf.ims.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the result database table.
 * 
 */
@Entity
@NamedQuery(name="Result.findAll", query="SELECT r FROM Result r")
public class Result implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int applicationId;
	private String applicationName;
	private String cazeName;
	private String expectation;
	private int groupId;
	private String groupName;
	private String ip;
	private String name;
	private String params;
	private int port;
	private String result;
	private int serverId;
	private String status;
	private String url;
	private int urlId;
	private String urlName;
	private Caze caze;

	public Result() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}


	public String getApplicationName() {
		return this.applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}


	public String getCazeName() {
		return this.cazeName;
	}

	public void setCazeName(String cazeName) {
		this.cazeName = cazeName;
	}


	public String getExpectation() {
		return this.expectation;
	}

	public void setExpectation(String expectation) {
		this.expectation = expectation;
	}


	public int getGroupId() {
		return this.groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}


	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Lob
	public String getParams() {
		return this.params;
	}

	public void setParams(String params) {
		this.params = params;
	}


	public int getPort() {
		return this.port;
	}

	public void setPort(int port) {
		this.port = port;
	}


	@Lob
	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}


	public int getServerId() {
		return this.serverId;
	}

	public void setServerId(int serverId) {
		this.serverId = serverId;
	}


	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	public int getUrlId() {
		return this.urlId;
	}

	public void setUrlId(int urlId) {
		this.urlId = urlId;
	}


	public String getUrlName() {
		return this.urlName;
	}

	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}


	//bi-directional many-to-one association to Caze
	@ManyToOne
	@JoinColumn(name="cazeId")
	public Caze getCaze() {
		return this.caze;
	}

	public void setCaze(Caze caze) {
		this.caze = caze;
	}

}
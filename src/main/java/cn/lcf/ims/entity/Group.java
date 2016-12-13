package cn.lcf.ims.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the group database table.
 * 
 */
@Entity
@NamedQuery(name="Group.findAll", query="SELECT g FROM Group g")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String description;
	private String name;
	private List<GroupUrl> groupUrls;

	public Group() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//bi-directional many-to-one association to GroupUrl
	@OneToMany(mappedBy="group")
	public List<GroupUrl> getGroupUrls() {
		return this.groupUrls;
	}

	public void setGroupUrls(List<GroupUrl> groupUrls) {
		this.groupUrls = groupUrls;
	}

	public GroupUrl addGroupUrl(GroupUrl groupUrl) {
		getGroupUrls().add(groupUrl);
		groupUrl.setGroup(this);

		return groupUrl;
	}

	public GroupUrl removeGroupUrl(GroupUrl groupUrl) {
		getGroupUrls().remove(groupUrl);
		groupUrl.setGroup(null);

		return groupUrl;
	}

}
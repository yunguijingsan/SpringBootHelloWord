package cn.lcf.ims.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the group_url database table.
 * 
 */
@Entity
@Table(name="group_url")
@NamedQuery(name="GroupUrl.findAll", query="SELECT g FROM GroupUrl g")
public class GroupUrl implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Group group;
	private Url url;

	public GroupUrl() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	//bi-directional many-to-one association to Group
	@ManyToOne
	@JoinColumn(name="groupId")
	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}


	//bi-directional many-to-one association to Url
	@ManyToOne
	@JoinColumn(name="urlId")
	public Url getUrl() {
		return this.url;
	}

	public void setUrl(Url url) {
		this.url = url;
	}

}
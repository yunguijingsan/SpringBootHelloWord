package cn.lcf.ims.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the server database table.
 * 
 */
@Entity
@NamedQuery(name="Server.findAll", query="SELECT s FROM Server s")
public class Server implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String ip;
	private int port;

	public Server() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	public int getPort() {
		return this.port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
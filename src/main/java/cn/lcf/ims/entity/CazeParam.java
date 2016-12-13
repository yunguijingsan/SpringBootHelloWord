package cn.lcf.ims.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the caze_param database table.
 * 
 */
@Entity
@Table(name="caze_param")
@NamedQuery(name="CazeParam.findAll", query="SELECT c FROM CazeParam c")
public class CazeParam implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String value;
	private Caze caze;
	private ParamDefinetion paramDefinetion;

	public CazeParam() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
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


	//bi-directional many-to-one association to ParamDefinetion
	@ManyToOne
	@JoinColumn(name="paramDefId")
	public ParamDefinetion getParamDefinetion() {
		return this.paramDefinetion;
	}

	public void setParamDefinetion(ParamDefinetion paramDefinetion) {
		this.paramDefinetion = paramDefinetion;
	}

}
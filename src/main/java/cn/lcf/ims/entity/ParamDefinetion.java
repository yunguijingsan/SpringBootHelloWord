package cn.lcf.ims.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the param_definetion database table.
 * 
 */
@Entity
@Table(name="param_definetion")
@NamedQuery(name="ParamDefinetion.findAll", query="SELECT p FROM ParamDefinetion p")
public class ParamDefinetion implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String description;
	private String name;
	private String type;
	private List<CazeParam> cazeParams;
	private Url url;

	public ParamDefinetion() {
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


	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}


	//bi-directional many-to-one association to CazeParam
	@OneToMany(mappedBy="paramDefinetion")
	public List<CazeParam> getCazeParams() {
		return this.cazeParams;
	}

	public void setCazeParams(List<CazeParam> cazeParams) {
		this.cazeParams = cazeParams;
	}

	public CazeParam addCazeParam(CazeParam cazeParam) {
		getCazeParams().add(cazeParam);
		cazeParam.setParamDefinetion(this);

		return cazeParam;
	}

	public CazeParam removeCazeParam(CazeParam cazeParam) {
		getCazeParams().remove(cazeParam);
		cazeParam.setParamDefinetion(null);

		return cazeParam;
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
package cn.lcf.ims.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the function database table.
 * 
 */
@Entity
@NamedQuery(name="Function.findAll", query="SELECT f FROM Function f")
public class Function implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String content;
	private String name;
	private String type;
	private List<CazeFunction> cazeFunctions;

	public Function() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Lob
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
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


	//bi-directional many-to-one association to CazeFunction
	@OneToMany(mappedBy="function")
	public List<CazeFunction> getCazeFunctions() {
		return this.cazeFunctions;
	}

	public void setCazeFunctions(List<CazeFunction> cazeFunctions) {
		this.cazeFunctions = cazeFunctions;
	}

	public CazeFunction addCazeFunction(CazeFunction cazeFunction) {
		getCazeFunctions().add(cazeFunction);
		cazeFunction.setFunction(this);

		return cazeFunction;
	}

	public CazeFunction removeCazeFunction(CazeFunction cazeFunction) {
		getCazeFunctions().remove(cazeFunction);
		cazeFunction.setFunction(null);

		return cazeFunction;
	}

}
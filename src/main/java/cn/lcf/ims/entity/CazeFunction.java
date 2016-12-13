package cn.lcf.ims.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the caze_function database table.
 * 
 */
@Entity
@Table(name="caze_function")
@NamedQuery(name="CazeFunction.findAll", query="SELECT c FROM CazeFunction c")
public class CazeFunction implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Caze caze;
	private Function function;

	public CazeFunction() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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


	//bi-directional many-to-one association to Function
	@ManyToOne
	@JoinColumn(name="functionId")
	public Function getFunction() {
		return this.function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

}
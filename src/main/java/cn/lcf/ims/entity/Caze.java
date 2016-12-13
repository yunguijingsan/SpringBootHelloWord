package cn.lcf.ims.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the caze database table.
 * 
 */
@Entity
@NamedQuery(name="Caze.findAll", query="SELECT c FROM Caze c")
public class Caze implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String description;
	private String expectation;
	private String name;
	private String params;
	private String result;
	private Url url;
	private List<CazeFunction> cazeFunctions;
	private List<CazeParam> cazeParams;
	private List<Result> results;

	public Caze() {
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


	public String getExpectation() {
		return this.expectation;
	}

	public void setExpectation(String expectation) {
		this.expectation = expectation;
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


	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
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


	//bi-directional many-to-one association to CazeFunction
	@OneToMany(mappedBy="caze")
	public List<CazeFunction> getCazeFunctions() {
		return this.cazeFunctions;
	}

	public void setCazeFunctions(List<CazeFunction> cazeFunctions) {
		this.cazeFunctions = cazeFunctions;
	}

	public CazeFunction addCazeFunction(CazeFunction cazeFunction) {
		getCazeFunctions().add(cazeFunction);
		cazeFunction.setCaze(this);

		return cazeFunction;
	}

	public CazeFunction removeCazeFunction(CazeFunction cazeFunction) {
		getCazeFunctions().remove(cazeFunction);
		cazeFunction.setCaze(null);

		return cazeFunction;
	}


	//bi-directional many-to-one association to CazeParam
	@OneToMany(mappedBy="caze")
	public List<CazeParam> getCazeParams() {
		return this.cazeParams;
	}

	public void setCazeParams(List<CazeParam> cazeParams) {
		this.cazeParams = cazeParams;
	}

	public CazeParam addCazeParam(CazeParam cazeParam) {
		getCazeParams().add(cazeParam);
		cazeParam.setCaze(this);

		return cazeParam;
	}

	public CazeParam removeCazeParam(CazeParam cazeParam) {
		getCazeParams().remove(cazeParam);
		cazeParam.setCaze(null);

		return cazeParam;
	}


	//bi-directional many-to-one association to Result
	@OneToMany(mappedBy="caze")
	public List<Result> getResults() {
		return this.results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public Result addResult(Result result) {
		getResults().add(result);
		result.setCaze(this);

		return result;
	}

	public Result removeResult(Result result) {
		getResults().remove(result);
		result.setCaze(null);

		return result;
	}

}
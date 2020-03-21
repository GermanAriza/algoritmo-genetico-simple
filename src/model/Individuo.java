package model;

/*clase encargada de representar los individuos de una población */

public class Individuo implements Comparable<Individuo> {

	private Integer id;

	private Integer generacion;

	private Variable variable1;

	private Variable variable2;

	private Double desempenio;

	private Boolean mutacion;

	public Individuo(Integer id, Integer generacion, Variable variable1, Variable variable2, Double desempenio) {
		super();
		this.id = id;
		this.generacion = generacion;
		this.variable1 = variable1;
		this.variable2 = variable2;
		this.desempenio = desempenio;
		this.mutacion = Boolean.FALSE;
	}

	public Individuo(Variable variable1, Variable variable2) {
		super();
		this.variable1 = variable1;
		this.variable2 = variable2;
		this.mutacion = Boolean.FALSE;
	}

	public Individuo(Integer id, Double valorVariable1, Double valorVariable2, Integer generacion) {
		super();
		this.id = id;

		Fenoma fenomaVariable1 = new Fenoma(valorVariable1);
		Fenoma fenomaVariable2 = new Fenoma(valorVariable2);

		this.variable1 = new Variable(fenomaVariable1, new Genoma(fenomaVariable1));
		this.variable2 = new Variable(fenomaVariable2, new Genoma(fenomaVariable2));
		this.generacion = generacion;
		this.mutacion = Boolean.FALSE;
	}

	public Individuo(Double desempenio) {
		super();
		this.desempenio = desempenio;
		this.mutacion = Boolean.FALSE;
	}

	public Integer getGeneracion() {
		return generacion;
	}

	public void setGeneracion(Integer generacion) {
		this.generacion = generacion;
	}

	public Variable getVariable1() {
		return variable1;
	}

	public void setVariable1(Variable variable1) {
		this.variable1 = variable1;
	}

	public Variable getVariable2() {
		return variable2;
	}

	public void setVariable2(Variable variable2) {
		this.variable2 = variable2;
	}

	public Double getDesempenio() {
		return desempenio;
	}

	public void setDesempenio(Double desempenio) {
		this.desempenio = desempenio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getMutacion() {
		return mutacion;
	}

	public void setMutacion(Boolean mutacion) {
		this.mutacion = mutacion;
	}

	@Override
	public String toString() {
		return "Individuo [id=" + id + ", generacion=" + generacion + ", variable1=" + variable1 + ", variable2="
				+ variable2 + ", desempenio=" + desempenio + ", mutacion=" + mutacion + "]";
	}

	public String imprimirDesempenio() {
		return "Individuo= " + id + " ,generacion= " + generacion + " ,variable1 "
				+ variable1.getFenoma().getValorReal() + " , variable2= " + variable2.getFenoma().getValorReal()
				+ " ,desempenio=" + desempenio;
	}

	@Override
	public int compareTo(Individuo i) {

		return (int) (this.desempenio - i.desempenio);
	}

}

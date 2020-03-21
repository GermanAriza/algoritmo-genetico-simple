package model;

/**
 * @author
 *
 * 		FENOMA: Representación real de una variable
 */
public class Fenoma {

	private Double valorReal;
	private String valorEntero;
	private String valorDecimal;

	public Fenoma(Double valorReal) {
		super();
		this.valorReal = valorReal;

		String[] numero = valorReal.toString().split("\\.");

		this.valorEntero = numero[0];
		this.valorDecimal = numero[1];

	}

	public Double getValorReal() {
		return valorReal;
	}

	public void setValorReal(Double valorReal) {
		this.valorReal = valorReal;
	}

	public String getValorEntero() {
		return valorEntero;
	}

	public void setValorEntero(String valorEntero) {
		this.valorEntero = valorEntero;
	}

	public String getValorDecimal() {
		return valorDecimal;
	}

	public void setValorDecimal(String valorDecimal) {
		this.valorDecimal = valorDecimal;
	}

	@Override
	public String toString() {
		return "Fenoma [valorReal=" + valorReal + ", valorEntero=" + valorEntero + ", valorDecimal=" + valorDecimal
				+ "]";
	}

}

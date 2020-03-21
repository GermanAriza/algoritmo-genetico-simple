package model;

import utilities.Utils;

/**
 * @author
 *
 * 		GENOMA : Representación binaria de una variable
 */
public class Genoma {

	private String valorEntero;
	private String valorDecimal;

	public Genoma(Fenoma fenoma) {
		super();

		this.valorEntero = Utils.enteroABinario(Integer.parseInt(fenoma.getValorEntero()));
		this.valorDecimal = Utils.enteroABinario(Integer.parseInt(fenoma.getValorDecimal()));

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
		return "Genoma [valorEntero=" + valorEntero + ", valorDecimal=" + valorDecimal + "]";
	}

}

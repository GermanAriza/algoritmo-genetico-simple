package model;

public class Variable {

	private Fenoma fenoma;

	private Genoma genoma;

	public Variable(Fenoma fenoma, Genoma genoma) {
		super();
		this.fenoma = fenoma;
		this.genoma = genoma;
	}

	public Fenoma getFenoma() {
		return fenoma;
	}

	public void setFenoma(Fenoma fenoma) {
		this.fenoma = fenoma;
	}

	public Genoma getGenoma() {
		return genoma;
	}

	public void setGenoma(Genoma genoma) {
		this.genoma = genoma;
	}

	@Override
	public String toString() {
		return "Variable [fenoma=" + fenoma + ", genoma=" + genoma + "]";
	}

}

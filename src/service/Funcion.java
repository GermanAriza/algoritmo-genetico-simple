package service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import model.Individuo;
import utilities.Constants;
import utilities.Utils;

/**
 * @author aarizac
 *
 */
public class Funcion {

	private String objetivo;

	/**
	 * @param individuo1
	 * @param individuo2
	 * @return
	 */
	public Individuo aplicarFuncionObjetivo(Individuo individuo1, Individuo individuo2) {

		return individuo1.getDesempenio() > individuo2.getDesempenio() ? individuo1 : individuo2;

	}

	/**
	 * Método encargado de ejecutar función objetivo con variables determinadas
	 * 
	 * 
	 * @param formula
	 * @param valorVariable1
	 * @param valorVariable2
	 * @return
	 */
	public Double evaluarDesempeñoFitness(String formula, 
			Double valorVariable1, Double valorVariable2) {

		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine interprete = manager.getEngineByName("js");
		Double desempenio = 0d;

		try {

			interprete.put("X", valorVariable1);
			interprete.put("Y", valorVariable2);

			desempenio = Utils.redondearDecimales((Double) interprete.eval(formula),
					Constants.MAXIMO_DECIMALES_VARIABLE);
			return desempenio;

		} catch (ScriptException se) {

			se.printStackTrace();
			System.out.println("Error ejecutando Función Objetivo!!");
			System.exit(0);
			return null;

		}

	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

}

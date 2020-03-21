package service;

import java.util.ArrayList;
import java.util.List;

import model.Individuo;
import utilities.Constants;
import utilities.Utils;

public class Poblacion {

	private static Poblacion instancia = null;
	public Integer tamanioPoblacion = 0;
	public Integer generacion = 1;

	public static Poblacion getInstance() {

		if (instancia == null) {
			instancia = new Poblacion();
		}
		return instancia;
	}

	private Poblacion() {

	}

	/**
	 * Mètodo encargado de generar la poblacion inicial
	 * 
	 * @param tamanioPoblacion
	 * @param generacion
	 * @return
	 */
	public List<Individuo> generarPoblacionInicial(Integer tamanioPoblacion, Integer generacion) {

		List<Individuo> listaIndividuos = new ArrayList<Individuo>();
		Double valorVariable1;
		Double valorVariable2;

		for (int i = 1; i <= tamanioPoblacion; i++) {

			valorVariable1 = Utils.generarEnteroDecimalAleatorio(Constants.MINIMO_FENOMA, Constants.MAXIMO_FENOMA,
					Constants.MAXIMO_DECIMALES_VARIABLE);
			valorVariable2 = Utils.generarEnteroDecimalAleatorio(Constants.MINIMO_FENOMA, Constants.MAXIMO_FENOMA,
					Constants.MAXIMO_DECIMALES_VARIABLE);

			Individuo individuo = new Individuo(i, valorVariable1, valorVariable2, generacion);

			listaIndividuos.add(individuo);

		}

		Poblacion.getInstance().tamanioPoblacion = tamanioPoblacion;

		return listaIndividuos;

	}

}

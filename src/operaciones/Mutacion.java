package operaciones;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import model.Individuo;
import utilities.Constants;
import utilities.Utils;

public class Mutacion {

	/**
	 * @param individuo
	 * @return
	 */
	public Individuo mutarIndividuo(Individuo individuo) {

		List<String> listaGenomaVariable1 = new ArrayList<>();
		String genomaVariable1;
		String genomaVariable1Mutado = "";

		List<String> listaGenomaVariable2 = new ArrayList<>();
		String genomaVariable2;
		String genomaVariable2Mutado = "";

		// Anáñlisis mutacion variable 2
		genomaVariable1 = individuo.getVariable1().getGenoma().getValorEntero();
		listaGenomaVariable1 = Utils.stringToList(genomaVariable1);

		for (String bit : listaGenomaVariable1) {
			if (Utils.generarDoubleAleatorio(0, 1) < Constants.PROBABILIDAD_MUTACION) {
				if (bit.equals("0")) {
					bit = "1";
				} else {
					bit = "0";
				}
				genomaVariable1Mutado = genomaVariable1Mutado + bit;
				individuo.setMutacion(Boolean.TRUE);
			}
		}
		

		if (!StringUtils.isBlank(genomaVariable1Mutado)) {
			
			individuo.getVariable1().getFenoma()
					.setValorEntero(Integer.toString(Utils.binarioAEntero(genomaVariable1Mutado.toString())));
			individuo.getVariable1().getGenoma().setValorEntero(genomaVariable1Mutado.toString());

		}

		// Análisis mutación variable 2
		genomaVariable2 = individuo.getVariable2().getGenoma().getValorEntero();
		listaGenomaVariable2 = Utils.stringToList(genomaVariable2);

		for (String bit : listaGenomaVariable2) {
			if (Utils.generarDoubleAleatorio(0, 1) < Constants.PROBABILIDAD_MUTACION) {
				if (bit.equals("0")) {
					bit = "1";
				} else {
					bit = "0";
				}
				genomaVariable2Mutado = genomaVariable2Mutado + bit;
				individuo.setMutacion(Boolean.TRUE);
			}
		}

		if (!StringUtils.isBlank(genomaVariable2Mutado)) {

			individuo.getVariable2().getFenoma()
					.setValorEntero(Integer.toString(Utils.binarioAEntero(genomaVariable2Mutado.toString())));
			individuo.getVariable2().getGenoma().setValorEntero(genomaVariable2Mutado.toString());
		}

		return individuo;

	}

	/**
	 * @param listaIndividuos
	 * @return
	 */
	public List<Individuo> mutarListaIndividuos(List<Individuo> listaIndividuos) {

		List<Individuo> listaIndividuosMutados = new ArrayList<>();

		for (Individuo individuo : listaIndividuos) {
			listaIndividuosMutados.add(mutarIndividuo(individuo));
		}

		return listaIndividuosMutados;
	}

}

package operaciones;

import java.util.ArrayList;
import java.util.List;

import model.Individuo;
import service.Poblacion;
import utilities.Utils;

public class Cruce {

	/**
	 * @param parejasIndividuos
	 * @return
	 */
	public List<Individuo> realizarCruce(Individuo[][] parejasIndividuos) {

		List<Individuo> nuevalistaDeIndividuos = new ArrayList<Individuo>();

		Individuo papa = null;
		Individuo mama = null;
		Individuo hijo1 = null;
		Individuo hijo2 = null;

		Poblacion.getInstance().generacion++;

		for (int i = 0; i < parejasIndividuos[0].length; i++) {
			papa = parejasIndividuos[0][i];
			mama = parejasIndividuos[0][i];

			List<String> nuevosGenomaVariable1 = combinarGenes(papa.getVariable1().getGenoma().getValorEntero(),
					mama.getVariable1().getGenoma().getValorEntero());

			List<String> nuevosGenomaVariable2 = combinarGenes(papa.getVariable2().getGenoma().getValorEntero(),
					mama.getVariable2().getGenoma().getValorEntero());

			
			// construyendo hijo 1
			Double valorVariable1Hijo1 = Double.parseDouble(Utils.binarioAEntero(nuevosGenomaVariable1.get(0)) + "."
					+ papa.getVariable1().getFenoma().getValorDecimal());
			Double valorVariable2Hijo1 = Double.parseDouble(Utils.binarioAEntero(nuevosGenomaVariable2.get(0)) + "."
					+ mama.getVariable2().getFenoma().getValorDecimal());

			Poblacion.getInstance().tamanioPoblacion++;
			hijo1 = new Individuo(Poblacion.getInstance().tamanioPoblacion, valorVariable1Hijo1, valorVariable2Hijo1,
					Poblacion.getInstance().generacion);

			// construyendo hijo 2
			Double valorVariable1Hijo2 = Double.parseDouble(Utils.binarioAEntero(nuevosGenomaVariable1.get(1)) + "."
					+ papa.getVariable1().getFenoma().getValorDecimal());
			Double valorVariable2Hijo2 = Double.parseDouble(Utils.binarioAEntero(nuevosGenomaVariable2.get(1)) + "."
					+ mama.getVariable2().getFenoma().getValorDecimal());

			Poblacion.getInstance().tamanioPoblacion++;
			hijo2 = new Individuo(Poblacion.getInstance().tamanioPoblacion, valorVariable1Hijo2, valorVariable2Hijo2,
					Poblacion.getInstance().generacion);

			nuevalistaDeIndividuos.add(hijo1);
			nuevalistaDeIndividuos.add(hijo2);

		}

		return nuevalistaDeIndividuos;

	}

	/**
	 * Se mexclan genes entre padres
	 * 
	 * @param genPapa
	 * @param genMama
	 * @return
	 */
	public List<String> combinarGenes(String genPapa, String genMama) {

		List<String> hijos = new ArrayList<String>();

		if(genPapa.length()<8){
			genPapa = Utils.completarNumeroIzquierda(genPapa);
		}
		
		if(genMama.length()<8){
			genMama = Utils.completarNumeroIzquierda(genMama);

		}
		
		String hijo1 = genPapa.substring(0, 4) + genMama.substring(4, 8);
		String hijo2 = genMama.substring(0, 4) + genPapa.substring(4, 8);

		hijos.add(hijo1);
		hijos.add(hijo2);

		return hijos;
	}
}

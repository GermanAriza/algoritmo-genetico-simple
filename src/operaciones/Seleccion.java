package operaciones;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import model.Individuo;
import service.Funcion;
import utilities.Constants;
import utilities.Utils;

/**
 * @author aarizac
 *
 */
public class Seleccion {

	Funcion funcion = new Funcion();

	public void ruleta() {

	}

	/**
	 * @param parejasIndividuos
	 * @return
	 */
	public List<Individuo> torneo(Individuo[][] parejasIndividuos) {

		List<Individuo> individuosGanadores = new ArrayList<Individuo>();

		for (int i = 0; i < (parejasIndividuos[0].length / 2) - 1; i++) {

			individuosGanadores.add(funcion.aplicarFuncionObjetivo(parejasIndividuos[0][i], parejasIndividuos[1][i]));

		}

		return individuosGanadores;

	}

	/**
	 * @param listaIndividuos
	 */
	public Individuo[][] establecerParejas(List<Individuo> listaIndividuos) {

		Individuo[] individuosArray = new Individuo[listaIndividuos.size()];
		Individuo parejasIndividuos[][] = new Individuo[2][listaIndividuos.size()];
		Individuo parejasMatriz[][] = new Individuo[2][listaIndividuos.size() / 2];

		// Se envia la lista de individuos a un arreglo
		individuosArray = listaIndividuos.toArray(individuosArray);

		// Se recorre arreglo para conformar parejas en la matriz
		for (int i = 0; i < individuosArray.length; i++) {
			parejasIndividuos[0][i] = individuosArray[i];
			parejasIndividuos[1][i] = individuosArray[individuosArray.length - i - 1];
		}

		// Se crea matriz con las parejas
		for (int i = 0; i < individuosArray.length / 2; i++) {
			parejasMatriz[0][i] = parejasIndividuos[0][i];
			parejasMatriz[1][i] = parejasIndividuos[1][i];
		}

		return parejasMatriz;

	}

	/**
	 * Mètodo encargado de seleccionar aleatoriamente los individuos iniciales.
	 * 
	 * @param poblacionIndividuos
	 * @return
	 */
	public List<Individuo> individuosIniciales(List<Individuo> poblacionIndividuos) {

		List<Individuo> listaindividuosInicial = new ArrayList<Individuo>();

		for (int i = 0; i < Constants.INDIVIDUOS_APTOS; i++) {

			listaindividuosInicial.add(poblacionIndividuos
					.get(Utils.generarEnteroAleatorio(Constants.MINIMO_FENOMA - 1, Constants.TAMANIO_POBLACION - 1)));

		}

		return listaindividuosInicial;

	}

	/**
	 * Evaluación de la funci+ón objetivo de acuerdo a las variables que tiene
	 * el individuo.
	 * 
	 * @param listaIndividuos
	 * @return
	 */
	public List<Individuo> calcularDesempenio(List<Individuo> listaIndividuos, String funcionObjetivo) {

		Funcion funcion = new Funcion();
		Double desempenio = 0d;

		// Cálculo del valor total dados los individuos de la población
		for (Individuo individuo : listaIndividuos) {

			desempenio = funcion.evaluarDesempeñoFitness(funcionObjetivo,
					individuo.getVariable1().getFenoma().getValorReal(),
					individuo.getVariable2().getFenoma().getValorReal());
			
			if(String.valueOf(desempenio).length()<8){
				String d = Utils.completarNumeroDerecha(String.valueOf(desempenio));
				desempenio = Double.valueOf(desempenio);
			} else {
				desempenio= Double.valueOf(String.valueOf(desempenio).substring(0, 8));
			}
			

			desempenio = Utils.redondearDecimales(desempenio,
					Constants.MAXIMO_DECIMALES_VARIABLE);

			individuo.setDesempenio(desempenio);
		}

		return listaIndividuos;

	}

	/**
	 * Método encargadp de ordenar una lista de individuos
	 * 
	 * @param individuosPoblacion
	 * @param cantidadIndividuosOptimos
	 * @return
	 */
	public List<Individuo> obtenerIndividuosMasAptos(List<Individuo> individuosPoblacion,
			Integer cantidadIndividuosOptimos, String FuncionOptimizacion) {

		if (FuncionOptimizacion.equals(Constants.FUNCION_OPTIMIZACION_MAX)) {
			individuosPoblacion.sort(Comparator.comparing(Individuo::getDesempenio).reversed());
		} else if (FuncionOptimizacion.equals(Constants.FUNCION_OPTIMIZACION_MIN)) {
			individuosPoblacion.sort(Comparator.comparing(Individuo::getDesempenio));
		} else {
			individuosPoblacion.sort(Comparator.comparing(Individuo::getDesempenio).reversed());
		}

		return individuosPoblacion.stream().limit(cantidadIndividuosOptimos).collect(Collectors.toList());

	}

	/**
	 * @param poblacion
	 * @param listaIndividuos
	 * @param accion
	 * @return
	 */
	public List<Individuo> agregarNuevosIndividuosALaPoblacion(List<Individuo> poblacion,
			List<Individuo> listaIndividuos, String accion) {

		if (accion.equals(Constants.ADD)) {
			for (Individuo individuo : listaIndividuos) {
				poblacion.add(individuo);
			}
		} else if (accion.equals(Constants.REPLACE)) {
			poblacion.clear();
			poblacion = listaIndividuos;
		}

		return poblacion;

	}

}

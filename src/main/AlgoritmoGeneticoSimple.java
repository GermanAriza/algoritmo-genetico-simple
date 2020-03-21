package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Individuo;
import operaciones.Cruce;
import operaciones.Mutacion;
import operaciones.Seleccion;
import service.Poblacion;
import utilities.Constants;


/**
 * @author aarizac
 * 
 *         Programa principal encargado de ejecutar el algoritmo genético simple
 *         (AGS) 1. Seleccionar aleatoriamente un número N de individuos
 *         pertenecientes al espacio de búsqueda, conformar una población con
 *         estos individuos y evaluar los N individuos de la población. 2. De
 *         acuerdo con su capacidad de desempeño, seleccionar los individuos de
 *         la población que van a ser padres. 3. Generar N hijos mediante cruce
 *         de los padres. 4. De acuerdo con la probabilidad de mutación, mutar
 *         algunos de los N hijos. 5. Reemplazar la población anterior por los N
 *         hijos. 6. Si se alcanza la condición necesaria para detener el
 *         algoritmo, terminar el algoritmo, en otro caso volver al paso 2.
 *
 */
public class AlgoritmoGeneticoSimple {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// EJECUTAR FUNCIÓN 2
		String funcionOptimizacion = Constants.FUNCION_OPTIMIZACION_MAX;
		String funcionObjetivo = Constants.FUNCION_OBJETIVO2;
		Double valorOptimo = 1d;


		Poblacion.getInstance();
		Seleccion seleccion = new Seleccion();
		Cruce cruce = new Cruce();
		Mutacion mutacion = new Mutacion();
		
		List<Individuo> individuosMasAptos = new ArrayList<Individuo>();

		int generacion = 1;
		int repeticiones = 0;
		boolean ejecucion = true;

		// 1. Generar Población
		Long inicioEjecucion = System.currentTimeMillis();
		
		List<Individuo> poblacionIndividuos = Poblacion.getInstance()
				.generarPoblacionInicial(Constants.TAMANIO_POBLACION, generacion);
		
		
		imprimirPoblacionGenerada(poblacionIndividuos, generacion);

		// 2. Evaluar función fitness (desempenio) de los individuos>
		// seleccionados
		poblacionIndividuos = seleccion.calcularDesempenio(poblacionIndividuos, funcionObjetivo);
		imprimirDesempenioSeleccionIndividuos(poblacionIndividuos, generacion);

	  //while (repeticiones < cantidadGeneraciones) {
		while (ejecucion) {

			if (repeticiones == 0) {
				imprimirPoblacionGenerada(poblacionIndividuos, generacion);
				
			}
			
			// 3. Seleccion de individuos mas aptos
			individuosMasAptos = seleccion.obtenerIndividuosMasAptos(poblacionIndividuos,
					Constants.INDIVIDUOS_APTOS, funcionOptimizacion);
			//imprimirIndividuosMasAptos(individuosMasAptos, generacion);

			// PROCESO DE SELECCION DE INDIVIDUOS

			// 4. Emparejamiento de Individuos
			Individuo[][] parejasIndividuos = seleccion.establecerParejas(individuosMasAptos);
			//imprimirParejasIndividuos(parejasIndividuos, generacion);
			//
			// 5. Cruce de individuos
			List<Individuo> individuosNuevaGeneracion = cruce.realizarCruce(parejasIndividuos);
			//imprimirIndividuosNuevaGeneracion(individuosNuevaGeneracion, generacion);

			// 6. Mutación
			List<Individuo> listaIndividuosMutados = mutacion.mutarListaIndividuos(individuosNuevaGeneracion);

			// 7. Agregar nuevos hijos a la población
			poblacionIndividuos = seleccion.agregarNuevosIndividuosALaPoblacion(poblacionIndividuos,
					listaIndividuosMutados, Constants.REPLACE);

			// 8. Evaluar función fitness (desempenio) de la población final
			poblacionIndividuos = seleccion.calcularDesempenio(poblacionIndividuos, funcionObjetivo);
			imprimirDesempenioSeleccionIndividuos(poblacionIndividuos, generacion);

			// 9. Seleccion de individuo solución
			List<Individuo> individuosSolucion = seleccion.obtenerIndividuosMasAptos(poblacionIndividuos,
					Constants.INDIVIDUO_SOLUCION, Constants.FUNCION_OPTIMIZACION_MIN);

			System.out.println("*************************El minimo es: "+ individuosSolucion.get(0).getDesempenio());
			if (individuosSolucion.get(0).getDesempenio().intValue() == valorOptimo.intValue()) {
				System.out.println("\n\n**EL INDIVIDUO MAS APTO EN LA EVOLUCIÓN ES: " + individuosSolucion.get(0));
				ejecucion = false;
			}

			repeticiones++;

		} // End While

		System.out.println("Cantidad de generaciones= " + (Poblacion.getInstance().generacion - 1));

		Long finEjecucion = (System.currentTimeMillis() - inicioEjecucion) / 1000;
		System.out.println("Tiempo utilizado en la ejecución= " + finEjecucion + " segundos");

	}

	public static void imprimirPoblacionGenerada(List<Individuo> poblacionIndividuos, int generacion) {

		System.out.println("*************************************");
		System.out.println("POBLACIÓN GENERADA - " + "GENERACIÓN: " + Poblacion.getInstance().generacion);
		System.out.println("*************************************");


		for (Individuo individuo : poblacionIndividuos) {
			System.out.println(individuo.toString());
		}
	}

	public static void imprimirSeleccionInicialIndividuos(List<Individuo> individuosPoblacion, int generacion) {

		System.out.println("\n");
		System.out.println("INDIVIDUOS SELECCIONADOS \n");
		
		Collections.sort(individuosPoblacion);

		for (Individuo individuo : individuosPoblacion) {
			System.out.println(individuo.toString());
		}
	}

	public static void imprimirDesempenioSeleccionIndividuos(List<Individuo> individuosPoblacion, int generacion) {

		System.out.println("\n");

		System.out.println("DESEMPEÑO INDIVIDUOS SELECCIONADOS \n");

		Collections.sort(individuosPoblacion);
		
		for (Individuo individuo : individuosPoblacion) {
			System.out.println(individuo.imprimirDesempenio());
		}
	}

	public static void imprimirIndividuosMasAptos(List<Individuo> poblacionIndividuos, int generacion) {

		System.out.println("\n");
		System.out.println("INDIVIDUOS MÁS APTOS \n");

		for (Individuo individuo : poblacionIndividuos) {
			System.out.println(individuo.toString());
		}
	}

	public static void imprimirParejasIndividuos(Individuo[][] parejasIndividuos, int generacion) {

		System.out.println("\n");
		System.out.println("PAREJAS INDIVIDUOS SELECCIONADOS \n");
		System.out.println("  ------------------------------------------------------");
		System.out.println(" | " + "Individuo" + "| " + "Desempeño" + " | " + "Individuo" + "| " + "Desempeño" + " | ");
		System.out.println("  ------------------------------------------------------");

		for (int i = 0; i < parejasIndividuos[0].length; i++) {
			System.out.println(" | " + parejasIndividuos[0][i].getId() + "        | "
					+ parejasIndividuos[0][i].getDesempenio() + "  | " + parejasIndividuos[1][i].getId() + "      | "
					+ parejasIndividuos[1][i].getDesempenio() + "      | ");

		}

	}

	public static void imprimirIndividuosNuevaGeneracion(List<Individuo> poblacionIndividuos, int generacion) {

		System.out.println("\n");
		System.out.println("*************************************");
		System.out.println("HIJOS GENERADOS - NUEVA GENERACIÓN \n");
		System.out.println("*************************************");
		for (Individuo individuo : poblacionIndividuos) {
			System.out.println(individuo.toString());
		}
	}

}

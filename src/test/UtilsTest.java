package test;

import java.util.Arrays;
import java.util.List;

import model.Fenoma;
import model.Genoma;
import model.Individuo;
import operaciones.Cruce;
import operaciones.Mutacion;
import operaciones.Seleccion;
import service.Funcion;
import service.Poblacion;
import utilities.Constants;
import utilities.Utils;

public class UtilsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Funcion funcion = new Funcion();
		Seleccion seleccion = new Seleccion();
		Mutacion mutacion = new Mutacion();
		Cruce cruce = new Cruce();

		System.out.println("\nTest Entero a Binario");
		System.out.println(Utils.enteroABinario(1));
		System.out.println(Utils.enteroABinario(3));
		// System.out.println(Utils.enteroABinario(Integer.parseInt("693999999999999")));

		System.out.println("\nTest Binario a Entero");
		System.out.println(Utils.binarioAEntero("01"));
		System.out.println(Utils.binarioAEntero("0001"));
		System.out.println(Utils.binarioAEntero("0111"));

		System.out.println("\nTest generar número entero Aleatorio");
		System.out.println(Utils.generarEnteroAleatorio(0, 7));
		System.out.println(Utils.generarEnteroAleatorio(5, 10));
		System.out.println(Utils.generarEnteroAleatorio(30, 50));

		System.out.println("\nTest generar número real Aleatorio");
		System.out.println(Utils.generarEnteroDecimalAleatorio(0, 7, 3));
		System.out.println(Utils.generarEnteroDecimalAleatorio(5, 10, 3));
		System.out.println(Utils.generarEnteroDecimalAleatorio(30, 50, 3));

		System.out.println("\nTest recibir fenoma  y fraccionarlo");
		System.out.println(new Fenoma(24.154));
		System.out.println(new Fenoma(455.000));
		System.out.println(new Fenoma(6.001));
		System.out.println(new Fenoma(14656.154));

		System.out.println("\nTest recibir genoma  y fraccionarlo");
		System.out.println(new Genoma(new Fenoma(24.154)));
		System.out.println(new Genoma(new Fenoma(455.000)));
		System.out.println(new Genoma(new Fenoma(6.001)));
		System.out.println(new Genoma(new Fenoma(14656.154)));

		System.out.println("\nTest engine Funcion Objetivo");
		System.out.println(funcion.evaluarDesempeñoFitness("X*Y/100", 3.0, 4.0));
		System.out.println(funcion.evaluarDesempeñoFitness("X+Y", 10.5, 15.3));
		System.out.println(funcion.evaluarDesempeñoFitness("(X-Y)/10", 3.0, 4.0));

		System.out.println("\nTest obtener Individuos Mejor Desempeño");
		List<Individuo> listaIndividuos = Arrays.asList(new Individuo(20.3), new Individuo(1.3), new Individuo(4.793),
				new Individuo(321.9), new Individuo(0.1));
		System.out.println("Individuos sin ordenar: ");
		listaIndividuos.stream().forEach(ind -> System.out.println(ind.getDesempenio()));
		listaIndividuos = seleccion.obtenerIndividuosMasAptos(listaIndividuos, 3, Constants.FUNCION_OPTIMIZACION_MAX);
		System.out.println("Individuos ordenados mayor: ");
		listaIndividuos.stream().forEach(ind -> System.out.println(ind.getDesempenio()));

		listaIndividuos = Arrays.asList(new Individuo(20.3), new Individuo(1.3), new Individuo(4.793),
				new Individuo(321.9), new Individuo(0.1));
		listaIndividuos = seleccion.obtenerIndividuosMasAptos(listaIndividuos, 3, Constants.FUNCION_OPTIMIZACION_MIN);
		System.out.println("Individuos ordenados menor: ");
		listaIndividuos.stream().forEach(ind -> System.out.println(ind.getDesempenio()));

		System.out.println("\nTest cruzar padres");
		System.out.println(cruce.combinarGenes("11110000", "00001111"));
		System.out.println(cruce.combinarGenes("10100000", "10101101"));

		System.out.println("\nTest conteo poblacion");
		Poblacion.getInstance().tamanioPoblacion++;
		Poblacion.getInstance().tamanioPoblacion++;
		System.out.println(Poblacion.getInstance().tamanioPoblacion);

		System.out.println("\nTest Convertir concat String en numero");
		System.out.println(Double.parseDouble("367" + "." + "214") + 1);

		System.out.println("\nTest Generar un double aleatorio");
		for (int i = 0; i < 20; i++) {
			System.out.println(Utils.generarDoubleAleatorio(0, 1));
		}

		System.out.println("\nTest String a Lista");
		System.out.println(Utils.stringToList("UNIVERSIDAD"));
		
		System.out.println("\nTest Mutacion Individuo");
		List<Individuo> listaIndividuosAMutar = Arrays.asList(new Individuo(1,20.3,45.65,1), new Individuo(2,1.3,8.345,1), new Individuo(3,32.34,4.793,1),
				new Individuo(4,321.9,16.76,1), new Individuo(5,0.1,0.87,1));
		
		List<Individuo> listaIndividuosMutados =mutacion.mutarListaIndividuos(listaIndividuosAMutar);
		for (Individuo individuo : listaIndividuosMutados) {
			System.out.println(individuo.toString());
		}
		
		System.out.println("\nTest Completar Individuo");
		System.out.println(Utils.completarNumeroIzquierda("2"));
		System.out.println(Utils.completarNumeroIzquierda("215"));
		System.out.println(Utils.completarNumeroIzquierda("0082"));
		
		System.out.println("\ntTest Evaluar desemeño");
		System.out.println(funcion.evaluarDesempeñoFitness(Constants.FUNCION_OBJETIVOTEST,-2.0d,4.0d));
		System.out.println(funcion.evaluarDesempeñoFitness(Constants.FUNCION_OBJETIVO1,2d,1d));
	}

}

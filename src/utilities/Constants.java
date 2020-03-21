package utilities;

/**
 * Clase manejadora de constntes de la Aplicación
 * 
 * @author aarizac
 *
 */
public class Constants {

	public final static Integer CANTIDAD_GENES = 8;
	public final static Integer MINIMO_FENOMA = 1;
	public final static Integer MAXIMO_FENOMA = 999;
	public final static Integer MAXIMO_DECIMALES_VARIABLE = 3;
	public final static Integer TAMANIO_POBLACION = 100;
	public final static Integer INDIVIDUOS_APTOS = 100;
	public final static Integer INDIVIDUO_SOLUCION = 1;
	public final static Integer NUMERO_GENERACIONES = 10;
	public static final Double PROBABILIDAD_MUTACION = 0.01; //% de la población
	public static final String FUNCION_OPTIMIZACION_MAX= "MAX"; 
	public static final String FUNCION_OPTIMIZACION_MIN= "MIN"; 
	public static final String ADD= "ADD"; 
	public static final String REPLACE= "REPLACE"; 
	public static final String FUNCION_OBJETIVO = "X*Y/100";
	public static final String FUNCION_OBJETIVOTEST = "Math.pow(X,2) + Math.pow(Y,2);";
	public static final String FUNCION_OBJETIVO1 = "Math.pow(1-X,2)+100*Math.pow(Y-Math.pow(X,2),2);";
	public static final String FUNCION_OBJETIVO2 = "(2186-Math.pow(Math.pow(X,2)+Y-11,2)-Math.pow(X+Math.pow(Y,2)-7,2))/2186;";
	public static final String FUNCION_OBJETIVO3 = "Math.pow(X,2)+2*Math.pow(Y,2)-0.3*Math.cos(3*Math.PI*X)-0.4*Math.cos(4*Math.PI*Y)+0.7;";
	
	/*
	 * PARÁMETROS DE ENTRADA
	 * Función objetivo - Parámetro a Optimizar			PTE
	 * restricciones variables -función objetivo		PTE
	 * Número de generaciones a evaluar					OK
	 * Número de Individuos por generación				OK
	 * Probabilidad De Mutación 						OK
	 * Funcion optimización (Máximo o Mínimo)			OK
	 * */

}

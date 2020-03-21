package utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;

import model.Individuo;
import service.CompararIndividuos;

public class Utils {

	/**
	 * M�todo encargado de convertir un n�mero entero a Binario
	 * 
	 * @param numero
	 * @return
	 */
	public static String enteroABinario(int numero) {

		return StringUtils.leftPad(Integer.toBinaryString(numero), Constants.CANTIDAD_GENES, "0");
	}

	/**
	 * M�todo encargado de convertir un n�mero binario a Entero
	 * 
	 * @param numero
	 * @return
	 */
	public static Integer binarioAEntero(String binario) {
		return Integer.parseInt(binario, 2);
	}

	/**
	 * M�todo encargado de generar un n�mero entero aleatorio
	 * 
	 * @param minimo
	 * @param maximo
	 * @return
	 */
	public static Integer generarEnteroAleatorio(Integer minimo, Integer maximo) {

		return (int) (Math.random() * maximo + minimo);
	}

	public static Double generarDoubleAleatorio(Integer minimo, Integer maximo) {

		return redondearDecimales((Double) (Math.random() * maximo + minimo), Constants.MAXIMO_DECIMALES_VARIABLE);
	}

	/**
	 * M�todo encargado de generar un n�mero decimal aleatorio
	 * 
	 * @param minimo
	 * @param maximo
	 * @return
	 */
	public static Double generarEnteroDecimalAleatorio(Integer minimo, Integer maximo, Integer maximoDecimales) {
		Random random = new Random();
		return redondearDecimales((minimo + (maximo - minimo) * random.nextDouble()), maximoDecimales.intValue());
	}

	/**
	 * M�todo encargado de redondear decimales a una cifra
	 * 
	 * @param valorInicial
	 * @param numeroDecimales
	 * @return
	 */
	public static double redondearDecimales(double valorInicial, int numeroDecimales) {

		try {
		    double parteEntera, resultado;
	        resultado = valorInicial;
	        parteEntera = Math.floor(resultado);
	        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
	        resultado=Math.round(resultado);
	        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
	        return resultado;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error ejecutando redondearDecimales!!");
			System.exit(0);
			return 0d;
		}

	}

	public static List<String> stringToList(String string) {

		List<String> listaString = new ArrayList<>();

		for (Character character : string.toCharArray()) {
			listaString.add(character.toString());

		}
		return listaString;

	}

	public static String completarNumeroIzquierda(String numero) {

		return StringUtils.leftPad(numero, Constants.CANTIDAD_GENES, "0");
	}
	
	public static String completarNumeroDerecha(String numero) {

		return StringUtils.rightPad(numero, Constants.CANTIDAD_GENES, "0");
	}

	public static List<Individuo> ordernarLista(List<Individuo> individuosPoblacion) {
		Collections.sort(individuosPoblacion, new CompararIndividuos());
		return individuosPoblacion;
	}
}

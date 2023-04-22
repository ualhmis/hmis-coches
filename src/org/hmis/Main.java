package org.hmis;

/**
 * Main
 * @author jimlu
 *
 */
public class Main {

	private static String ruta = "data/coches.json";
	private static Coche[] coches = JsonReader.leerCochesJSON(ruta);

	/**
	 * getRuta
	 * @return
	 */
	public static String getRuta() {
		return ruta;
	}

	/**
	 * getCoches
	 * @return
	 */
	public static Coche[] getCoches() {
		return coches;
	};

	/**
	 * toString
	 */
	public String toString() {
		String cadena = "";

		for (Coche coche : coches) {
			cadena += coche + "\n";
		}

		return cadena;
	}

}

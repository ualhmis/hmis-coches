package org.hmis;

public class Main {

	private static String ruta = "data/coches.json";
	private static Coche[] coches = JsonReader.leerCochesJSON(ruta);

	public static String getRuta() {
		return ruta;
	}

	public static Coche[] getCoches() {
		return coches;
	};

	public String toString() {
		String cadena = "";

		for (Coche coche : coches) {
			cadena += coche + "\n";
		}

		return cadena;
	}

}

package org.hmis;

public class Main {
    public static void main(String[] args) {
    	String ruta = "data/coches.json";
    	
    	Coche[] coches = JsonReader.leerCochesJSON(ruta);
    	
    	//Muestra los objetos del array
        for (Coche coche : coches) {
            System.out.println(coche);
        }
    }
}


package ual.hmis.sesion05.ejercicio3;

public class Ejercicio3 {

	public String devolverCadenaOculta(String cadena) {
		if(cadena.length()>0&&cadena.length()<5) {
			return "password demasiado corto";
		}
		else if(cadena.length()>5&&cadena.length()<8) {
			return "********";
		}
		else if(cadena.length()>12&&cadena.length()<40) {
			return "************";
		}
		else if(cadena.length()>40) {
			return "password demasiado largo";
		}
		else return "";
	}
}

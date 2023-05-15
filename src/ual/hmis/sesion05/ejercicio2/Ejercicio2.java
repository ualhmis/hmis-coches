package ual.hmis.sesion05.ejercicio2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio2 {
	public boolean login(String username, String password) {
		
		// comprobar que sean distintos de vacio
		// comprobar que la longitud sea < 30
		// llamar al método de la bbdd
		
		if(!username.equals("") && !password.equals("") && 
		   username.toString().length()<30&&password.toString().length()<30 &&
		   tieneMinusculaMayusculaYNumero(password)==true) {
			
			return compruebaLoginEnBD(username, password);
		}
		
		return false;
	}

	public boolean compruebaLoginEnBD(String username, String password) {
// método mock (simulado)
		if (username.equals("user") && password.equals("Pass1"))
			return true;
		else
			return false;
	}
	
	public static boolean tieneMinusculaMayusculaYNumero(String cadena) {
        // Crea una expresión regular que busca una letra minúscula y un número en cualquier parte de la cadena
        Pattern patron = Pattern.compile("^(?=.*[a-z])(?=.*\\d)(?=.*[A-Z]).+$");
        Matcher matcher = patron.matcher(cadena);
        return matcher.matches();
    }
}
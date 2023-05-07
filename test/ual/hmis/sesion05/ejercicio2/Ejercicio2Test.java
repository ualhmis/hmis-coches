package ual.hmis.sesion05.ejercicio2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Ejercicio2Test {

	@Test
	void testObjectNotNull() {

		Ejercicio2 ejercicio2 = new Ejercicio2();
		
		assertNotEquals(ejercicio2, null);
	}
	
	@Test
	void testUserVacio() {

		Ejercicio2 ejercicio2 = new Ejercicio2();

		assertFalse(ejercicio2.login("", "Pass1"));
	}
	
	@Test
	void testPasswordVacio() {

		Ejercicio2 ejercicio2 = new Ejercicio2();

		assertFalse(ejercicio2.login("user", ""));
	}
	
	@ParameterizedTest
	@CsvSource({"'', Pass1",
				"user,''",
				"'', ''"})
	void testParametrosVacios(String username, String password) {

		Ejercicio2 ejercicio2 = new Ejercicio2();

		assertFalse(ejercicio2.login(username, password));
	}
	
	@ParameterizedTest
	@CsvSource({"1672837288213774273462747234746, Pass1",
				"2834872834827348723647823467377, Pass1",
				"user, 2834872834827348723647823467377123",
				"user, 2834872834827348723647823467377324",
				"167283728821377427346274723474, 1672837288213774273462747234746",
				"123456789012345678901234567890, 1672837288213774273462747234746",
				"1672837288213774273462747234741, 1672837288213774273462747234746",
				"1234567890123456789012345678901, 1167283728821377427346274723474"})
	void testLongitudMayorOIgual30(String username, String password) {

		Ejercicio2 ejercicio2 = new Ejercicio2();

		assertFalse(ejercicio2.login(username, password));
	}
	
	@ParameterizedTest
	@CsvSource({"user, pass1",
				"user, PASS1",
				"user, Pass"})
	void testPasswordNoValida(String username, String password) {

		Ejercicio2 ejercicio2 = new Ejercicio2();
		
		assertFalse(ejercicio2.login(username, password));
	}
	
	@Test
	void testEstaEnBD() {

		Ejercicio2 ejercicio2 = new Ejercicio2();

		assertTrue(ejercicio2.login("user", "Pass1"));
		assertFalse(ejercicio2.login("Bser", "Pas1"));
	}
	
	@ParameterizedTest
	@CsvSource({"user, Pass1234",
				"User1234, Pass1",
				"User1231, Pass1123"})
	void testNoEstaEnBD(String username, String password) {

		Ejercicio2 ejercicio2 = new Ejercicio2();

		assertFalse(ejercicio2.login(username, password));
	}
}


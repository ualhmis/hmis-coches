package ual.hmis.sesion05.ejercicio3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class Ejercicio3Test {

	@Test
	void testObjectNotNull() {

		Ejercicio3 ejercicio3 = new Ejercicio3();

		assertNotEquals(ejercicio3, null);
	}
	
	@ParameterizedTest
	@CsvFileSource(files = "test/ual/hmis/sesion05/ejercicio3/cortas.csv.txt")
	void testLongitudPasswordCorta(String password) {

		Ejercicio3 ejercicio3 = new Ejercicio3();

		assertEquals("password demasiado corto", ejercicio3.devolverCadenaOculta(password));
	}

	@ParameterizedTest
	@CsvFileSource(files = "test/ual/hmis/sesion05/ejercicio3/beetween5_8.csv.txt")
	void testLongitudPassword5_8(String password) {

		Ejercicio3 ejercicio3 = new Ejercicio3();

		assertEquals("********", ejercicio3.devolverCadenaOculta(password));
	}
	
	@ParameterizedTest 
	@CsvFileSource(files = "test/ual/hmis/sesion05/ejercicio3/beetween12_40.csv.txt")
	void testLongitudPassword12_40(String password) {

		Ejercicio3 ejercicio3 = new Ejercicio3();

		assertEquals("************", ejercicio3.devolverCadenaOculta(password));
	}
	
	@ParameterizedTest
	@CsvFileSource(files = "test/ual/hmis/sesion05/ejercicio3/largas.csv.txt")
	void testLongitudPasswordLarga(String password) {

		Ejercicio3 ejercicio3 = new Ejercicio3();

		assertEquals("password demasiado largo", ejercicio3.devolverCadenaOculta(password));
	}
	
	@ParameterizedTest
	@CsvFileSource(files = "test/ual/hmis/sesion05/ejercicio3/vacio.csv")
	void testDevolverVacio(String password) {

		Ejercicio3 ejercicio3 = new Ejercicio3();

		assertEquals("", ejercicio3.devolverCadenaOculta(password));
	}

}

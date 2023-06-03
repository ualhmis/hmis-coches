package org.hmis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class CocheTestCSVFileSource {

	// Test Parametrizado para el método equals
	// Hay varios casos que no se pueden parametrizar con CsvSource
	
	@ParameterizedTest(name = "{index} => ¿iguales ({0}, {1}, {2}, {3}) y ({4}, {5}, {6}, {7})? {8})")
	@CsvFileSource(files = "test/org/hmis/dosCoches.csv", numLinesToSkip = 1)

	void testEquals(String marca1, String modelo1, int año1, int precio1, 
					String marca2, String modelo2, int año2, int precio2, 
					boolean expected) {
		Coche primero = new Coche(marca1, modelo1, año1, precio1);
		Coche segundo = new Coche(marca2, modelo2, año2, precio2);
		assertEquals(expected, primero.equals(segundo), "Los dos coches no son iguales");
	}

	// Caso que no se pueden parametrizar en el test anterior
	// segundo = null
	// Consultar: https://www.baeldung.com/parameterized-tests-junit-5#2-null-and-empty-values
	@Test
	void testEquals2() {
		Coche primero = new Coche("Renault", "Clio", 2001, 12000);
		Coche segundo = null;
		assertEquals(false, primero.equals(segundo), "Los dos coches no son iguales");
	}

	// Caso que no se pueden parametrizar en el test anterior
	// mismo objeto 

	@Test
	void testEquals3() {
		Coche primero = new Coche("Renault", "Clio", 2001, 12000);
		// Coche segundo = null;
		assertEquals(true, primero.equals(primero));
	}

	// Caso que no se pueden parametrizar en el test anterior
	// segundo objeto de diferente clase (String en vez de Coche)

	@Test
	void testEquals4() {
		Coche primero = new Coche("Renault", "Clio", 2001, 12000);
		String segundo = "";
		assertEquals(false, primero.equals(segundo), "Los dos coches no son iguales");
	}
	
	
	// Test toString
	// en el csv file, las cadenas que incluyen comas van entre comillas dobles
	@ParameterizedTest(name = "{index} => ({0}, {1}, {2}, {3})")
	@CsvFileSource(files = "test/org/hmis/cochesToString.csv", numLinesToSkip = 1)
    
    void testToString(String marca, String modelo, int año, int precio, 
    				  String expected) {
        Coche primero = new Coche (marca, modelo, año, precio);
        assertEquals(expected, primero.toString(), "Falla el test");

    }

	
}

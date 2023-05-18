package org.hmis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JsonReaderTest {

	@CsvSource({ 
	    "4, data/coches.json",
	    "0, manolo33/antonio.es"
	})
	@ParameterizedTest
	void testLeerCochesJSON(Integer arrayTam, String ruta) {
		JsonReader json = new JsonReader();
	    Coche[] coches = JsonReader.leerCochesJSON(ruta);
	    if (coches != null) {
	        assertEquals(arrayTam, coches.length);
	    } else {
	        assertNull(coches);
	    }
	}

	@CsvSource({ "data/coches.json, Toyota, Corolla, 2022, 22000" })
	@ParameterizedTest
	void testLeerCochesJSONprimero(String ruta, String marca, String modelo, int año, int precio) {
		Coche primero = new Coche(marca, modelo, año, precio);
		Coche[] coches = JsonReader.leerCochesJSON(ruta);
		assertEquals(primero, coches[0]);
		assertTrue(primero.equals(coches[0]));
		assertTrue(coches[0].equals(primero));
	}
}

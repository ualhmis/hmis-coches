package org.hmis;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JsonReaderTest {

	@Test
	void testLeerCochesJSON() {
		String filepath = "data/coches.json";
		Coche [] coches = JsonReader.leerCochesJSON(filepath);
		assertEquals (4, coches.length);
	}

	@Test
	void testLeerCochesJSONprimero() {
		String filepath = "data/coches.json";
		Coche primero = new Coche ("Chevrolet", "Camaro", 2023, 52000);
		Coche [] coches = JsonReader.leerCochesJSON(filepath);
		assertEquals(primero, coches[2]);
		assertTrue (primero.equals(coches[2]));
		assertTrue (coches[2].equals(primero));
	}

	@Test
	void testError() {
		String filepath = "data/coches.json";
		Coche primero = new Coche ("Chevrolet", "Camaro", 2023, 52000);
		Coche [] coches = JsonReader.leerCochesJSON(filepath);

	}

	@Test
	void testExcepcionLeerArchivo() {
		String filepath = "data/excepcion.json";
		assertDoesNotThrow(() -> JsonReader.leerCochesJSON(filepath));
	}

	@Test
	void testObjectoNoNull() {
		JsonReader jsonReader = new JsonReader();
		assertNotEquals(jsonReader, null);
	}
}

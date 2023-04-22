package org.hmis;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import com.google.gson.JsonSyntaxException;

class JsonReaderTest {

    @Test
    public void testConstructorVacio() {
        JsonReader objeto = new JsonReader();
        assertNotNull(objeto);
    }
	
	@Test
	void testLeerCochesJSONprimero() {
		String ruta = "data/coches.json";
		Coche primero = new Coche("Toyota", "Corolla", 2022, 22000);
		Coche[] coches = JsonReader.leerCochesJSON(ruta);
		assertEquals(primero, coches[0]);
		assertTrue(primero.equals(coches[0]));
		assertTrue(coches[0].equals(primero));
	}

	@Test
	public void leerCochesJSON_catchTest() {
		// Intentamos leer un archivo que no existe
		String archivo = "archivoInexistente.json";
		Coche[] coches = JsonReader.leerCochesJSON(archivo);
		assertNull(coches); // El resultado debería ser null debido a la excepción lanzada en el catch
	}

}

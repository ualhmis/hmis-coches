package org.hmis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class JsonReaderTest {

    @Test
    public void testConstructorVacio() {
        JsonReader objeto = new JsonReader();
        assertNotNull(objeto);
    }

    @ParameterizedTest
    @CsvSource({"Toyota, Corolla, 2022, 22000, 0"})
    void testLeerCochesJSONprimero(String marca, String modelo, int anio, int precio, int index) {
        String ruta = "data/coches.json";
        Coche primero = new Coche(marca, modelo, anio, precio);
        Coche[] coches = JsonReader.leerCochesJSON(ruta);
        assertEquals(primero, coches[index]);
        assertTrue(primero.equals(coches[index]));
        assertTrue(coches[index].equals(primero));
    }

    @ParameterizedTest
    @ValueSource(strings = {"archivoInexistente.json", "data/coches_invalido.json"})
    @DisplayName("Test para leer archivos JSON inválidos")
    public void leerCochesJSON_catchTest(String archivo) {
        // Intentamos leer un archivo que no existe
        Coche[] coches = JsonReader.leerCochesJSON(archivo);
        assertNull(coches); // El resultado debería ser null debido a la excepción lanzada en el catch
    }
}

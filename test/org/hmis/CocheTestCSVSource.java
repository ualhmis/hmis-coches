package org.hmis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CocheTestCSVSource {

	// Test Parametrizado para el método equals
	// Hay varios casos que no se pueden parametrizar con CsvSource
	
	@ParameterizedTest(name = "{index} => ¿iguales ({0}, {1}, {2}, {3}) y ({4}, {5}, {6}, {7})? {8})")
	@CsvSource({ "Renault, Clio, 2001, 12000, Renault, Clio, 2001, 12000, true",
			"Renault, Clio, 2001, 12000, Seat, Clio, 2001, 12000, false",
			"Renault, Clio, 2001, 12000, Renault, Twingo, 2001, 12000, false",
			"Renault, Clio, 2001, 12000, Renault, Clio, 2003, 12000, false",
			"Renault, Clio, 2001, 12000, Renault, Clio, 2001, 22000, false" })

	void testEquals(String marca1, String modelo1, int año1, int precio1, String marca2, String modelo2, int año2,
			int precio2, boolean expected) {
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
	
	
    // Test getters
	// {arguments} -> complete, comma-separated list of arguments
	// https://www.baeldung.com/parameterized-tests-junit-5#display-name
	
	@ParameterizedTest(name = "{index} => ({arguments})")
	@CsvSource({"Renault, Clio, 2001, 12000",
				"Seat, Ibiza, 2004, 17000"
	})
    
	void testGetters(String marca, String modelo, int año, int precio) {
        Coche primero = new Coche (marca, modelo, año, precio);
        assertEquals(marca, primero.getMarca());
        assertEquals(modelo, primero.getModelo());
        assertEquals(año, primero.getAño());
        assertEquals(precio, primero.getPrecio());
    }


    // test setters
	// Parametrized
	@ParameterizedTest(name = "{index} => ({0}, {1}, {2}, {3})")
	@CsvSource({"Renault, Clio, 2001, 12000, Ford",
				"Seat, Ibiza, 2004, 17000, Citroen"
	})
	void testSetterMarca(String marca, String modelo, int año, int precio, 
						 String marca2) {
        Coche primero = new Coche (marca, modelo, año, precio);
        primero.setMarca(marca2);
        assertNotEquals(marca, primero.getMarca());
        assertEquals(marca2, primero.getMarca());
	}
        
	@ParameterizedTest(name = "{index} => ({0}, {1}, {2}, {3})")
	@CsvSource({"Renault, Clio, 2001, 12000, Ford",
				"Seat, Ibiza, 2004, 17000, Citroen"
	})
	void testSetterModelo(String marca, String modelo, int año, int precio, 
						  String modelo2) {
        Coche primero = new Coche (marca, modelo, año, precio);
        primero.setModelo(modelo2);
        assertNotEquals(modelo, primero.getModelo());
        assertEquals(modelo2, primero.getModelo());
	}

	@ParameterizedTest(name = "{index} => ({0}, {1}, {2}, {3})")
	@CsvSource({"Renault, Clio, 2001, 12000, 2004",
				"Seat, Ibiza, 2004, 17000, 2021"
	})
	void testSetterAño(String marca, String modelo, int año, int precio, 
					   int año2) {
        Coche primero = new Coche (marca, modelo, año, precio);
        primero.setAño(año2);
        assertNotEquals(año, primero.getAño());
        assertEquals(año2, primero.getAño());
	}

	@ParameterizedTest(name = "{index} => ({0}, {1}, {2}, {3})")
	@CsvSource({"Renault, Clio, 2001, 12000, 30000",
				"Seat, Ibiza, 2004, 17000, 15900"
	})
	void testSetterPrecio(String marca, String modelo, int año, int precio, 
						  int precio2) {
        Coche primero = new Coche (marca, modelo, año, precio);
        primero.setPrecio(precio2);
        assertNotEquals(precio, primero.getPrecio());
        assertEquals(precio2, primero.getPrecio());
	}

	// Test toString
	// Parametrized
	// Usamos 'comillas simples' cuando un parámetro es una cadena que contenga comas
	
	@ParameterizedTest(name = "{index} => ({0}, {1}, {2}, {3})")
	@CsvSource({"Renault, Clio, 2001, 12000, 'Coche [marca=Renault, modelo=Clio, año=2001, precio=12000]'",
				"Seat, Ibiza, 2004, 17000, 'Coche [marca=Seat, modelo=Ibiza, año=2004, precio=17000]'"
	})
    
    void testToString(String marca, String modelo, int año, int precio, 
    				  String expected) {
        Coche primero = new Coche (marca, modelo, año, precio);
        assertEquals(expected, primero.toString(), "Falla el test");

    }

	// Test del constructor sin parámetros de la clase Coche
	// No parametrizable
	// Ejemplo: Probamos los valores predeteminados de los atributos
	@Test
	void testNewCoche() {
		Coche c = new Coche();
		assertEquals(null, c.getMarca());
		assertEquals(null, c.getModelo());
		assertEquals(0, c.getAño());
		assertEquals(0, c.getPrecio());
	}
        
}

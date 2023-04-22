package org.hmis;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CocheTest {

	@Test
	void testEquals() {
		Coche primero = new Coche("Renault", "Clio", 2001, 12000);
		Coche segundo = new Coche("Renault", "Clio", 2001, 12000);
		assertEquals(primero, segundo, "Los dos coches no son iguales");
	}

	@Test
	void testToString() {
		Coche primero = new Coche("Renault", "Clio", 2001, 12000);
		assertEquals("Coche [marca=Renault, modelo=Clio, año=2001, precio=12000]", primero.toString());

	}

	// Test del metodo equals de la clase Coche
	@ParameterizedTest
	@CsvSource({ "Renault,Clio,2001,12000", "Seat,Ibiza,2010,15000", "Ford,Fiesta,2018,20000" })
	void testEquals2(String marca, String modelo, int año, int precio) {
		Coche primero = new Coche(marca, modelo, año, precio);
		Coche segundo = null;
		assertNotEquals(primero, segundo, "Los dos coches no son iguales");
	}

	// Test del metodo equals de la clase Coche
	@ParameterizedTest
	@CsvSource({ "Renault,Clio,2001,12000", "Seat,Ibiza,2010,15000", "Ford,Fiesta,2018,20000" })
	void testEquals3(String marca, String modelo, int año, int precio) {
		Coche primero = new Coche(marca, modelo, año, precio);
		assertEquals(primero, primero, "Los dos coches no son iguales");
	}

	@ParameterizedTest
	@CsvSource({ "Renault,Clio,2001,12000,", "Seat,Ibiza,2010,15000,", "Ford,Fiesta,2018,20000," })
	void testEquals_att1(String marca, String modelo, int año, int precio, String expectedMarca) {
		Coche primero = new Coche(marca, modelo, año, precio);
		Coche segundo = new Coche(marca, modelo, año, precio);
		segundo.setAño(2003);
		assertNotEquals(primero, segundo, "Los dos coches no son iguales");
	}

	@ParameterizedTest
	@CsvSource({ "Renault, Seat", "Ford, Seat" })
	void testEquals_att2(String marca1, String marca2) {
		Coche primero = new Coche("Renault", "Clio", 2001, 12000);
		Coche segundo = new Coche("Renault", "Clio", 2001, 12000);

		segundo.setMarca(marca2);
		assertNotEquals(primero, segundo, "Los dos coches no son iguales");
	}

	@ParameterizedTest
	@CsvSource({ "Clio, Twingo", "Fiesta, Focus" })
	void testEquals_att3(String modelo1, String modelo2) {
		Coche primero = new Coche("Renault", "Clio", 2001, 12000);
		Coche segundo = new Coche("Renault", "Clio", 2001, 12000);
		segundo.setModelo(modelo2);
		assertNotEquals(primero, segundo, "Los dos coches no son iguales");
	}

	@ParameterizedTest
	@CsvSource({ "12000, 16000", "15000, 20000" })
	void testEquals_att4(int precio1, int precio2) {
		Coche primero = new Coche("Renault", "Clio", 2001, precio1);
		Coche segundo = new Coche("Renault", "Clio", 2001, precio1);
		segundo.setPrecio(precio2);
		assertNotEquals(primero, segundo, "Los dos coches no son iguales");
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testEquals_differentClass() {
		Coche coche = new Coche("Renault", "Clio", 2001, 12000);
		String cadena = "Este objeto no es un coche";
		assertFalse(coche.equals(cadena), "El objeto no debe ser igual a una cadena");
	}

	@ParameterizedTest
	@CsvSource({ "Renault, Clio, 2001, 12000", "Ford, Fiesta, 2005, 15000" })
	void testGetters(String marca, String modelo, int año, int precio) {
		Coche primero = new Coche(marca, modelo, año, precio);
		assertEquals(marca, primero.getMarca());
		assertEquals(modelo, primero.getModelo());
		assertEquals(año, primero.getAño());
		assertEquals(precio, primero.getPrecio());
	}

}

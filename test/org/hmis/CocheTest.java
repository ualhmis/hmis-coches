package org.hmis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CocheTest {

	@Test
	void testEquals() {
		Coche primero = new Coche("Renault", "Clio", 2001, 12000);
		Coche segundo = new Coche("Renault", "Clio", 2001, 12000);
		Assertions.assertEquals(primero, segundo, "Los dos coches no son iguales");
	}

	@Test
	void testToString() {
		Coche primero = new Coche("Renault", "Clio", 2001, 12000);
		Assertions.assertEquals("Coche [marca=Renault, modelo=Clio, ano=2001, precio=12000]", primero.toString());

	}

	// Test del metodo equals de la clase Coche
	@ParameterizedTest
	@CsvSource({ "Renault,Clio,2001,12000", "Seat,Ibiza,2010,15000", "Ford,Fiesta,2018,20000" })
	void testEquals2(String marca, String modelo, int ano, int precio) {
		Coche primero = new Coche(marca, modelo, ano, precio);
		Coche segundo = null;
		Assertions.assertNotEquals(primero, segundo, "Los dos coches no son iguales");
	}

	// Test del metodo equals de la clase Coche
	@ParameterizedTest
	@CsvSource({ "Renault,Clio,2001,12000", "Seat,Ibiza,2010,15000", "Ford,Fiesta,2018,20000" })
	void testEquals3(String marca, String modelo, int ano, int precio) {
		Coche primero = new Coche(marca, modelo, ano, precio);
		Assertions.assertEquals(primero, primero, "Los dos coches no son iguales");
	}

	@ParameterizedTest
	@CsvSource({ "Renault,Clio,2001,12000,", "Seat,Ibiza,2010,15000,", "Ford,Fiesta,2018,20000," })
	void testEquals_att1(String marca, String modelo, int ano, int precio, String expectedMarca) {
		Coche primero = new Coche(marca, modelo, ano, precio);
		Coche segundo = new Coche(marca, modelo, ano, precio);
		segundo.setAno(2003);
		Assertions.assertNotEquals(primero, segundo, "Los dos coches no son iguales");
	}

	@ParameterizedTest
	@CsvSource({ "Renault, Seat", "Ford, Seat" })
	void testEquals_att2(String marca1, String marca2) {
		Coche primero = new Coche("Renault", "Clio", 2001, 12000);
		Coche segundo = new Coche("Renault", "Clio", 2001, 12000);

		segundo.setMarca(marca2);
		Assertions.assertNotEquals(primero, segundo, "Los dos coches no son iguales");
	}

	@ParameterizedTest
	@CsvSource({ "Clio, Twingo", "Fiesta, Focus" })
	void testEquals_att3(String modelo1, String modelo2) {
		Coche primero = new Coche("Renault", "Clio", 2001, 12000);
		Coche segundo = new Coche("Renault", "Clio", 2001, 12000);
		segundo.setModelo(modelo2);
		Assertions.assertNotEquals(primero, segundo, "Los dos coches no son iguales");
	}

	@ParameterizedTest
	@CsvSource({ "12000, 16000", "15000, 20000" })
	void testEquals_att4(int precio1, int precio2) {
		Coche primero = new Coche("Renault", "Clio", 2001, precio1);
		Coche segundo = new Coche("Renault", "Clio", 2001, precio1);
		segundo.setPrecio(precio2);
		Assertions.assertNotEquals(primero, segundo, "Los dos coches no son iguales");
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testEquals_differentClass() {
		Coche coche = new Coche("Renault", "Clio", 2001, 12000);
		String cadena = "Este objeto no es un coche";
		Assertions.assertFalse(coche.equals(cadena), "El objeto no debe ser igual a una cadena");
	}

	@ParameterizedTest
	@CsvSource({ "Renault, Clio, 2001, 12000", "Ford, Fiesta, 2005, 15000" })
	void testGetters(String marca, String modelo, int ano, int precio) {
		Coche primero = new Coche(marca, modelo, ano, precio);
		Assertions.assertEquals(marca, primero.getMarca());
		Assertions.assertEquals(modelo, primero.getModelo());
		Assertions.assertEquals(ano, primero.getAno());
		Assertions.assertEquals(precio, primero.getPrecio());
	}

}

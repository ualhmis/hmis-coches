package org.hmis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class CocheTestMethodSource {

	// Test Parametrizado para el método equals
	// Hay varios casos que no se pueden parametrizar con CsvSource
	// Pero con MethodSource???  --> 100% en un solo test parametrizado!!!
	
	@ParameterizedTest(name = "{index} => ¿iguales {0} y {1}? {2})")
	@MethodSource("chochesProvider")
	void testEquals(Coche primero, Object segundo, boolean expected) {
		assertEquals(expected, primero.equals(segundo), "Los dos coches no son iguales");
	}

	
	static Stream<Arguments> chochesProvider(){
		Coche c = new Coche ("Renault", "Clio", 2001, 12000);
		return Stream.of(
				Arguments.of(
						c, 
						c,  // mismo objeto
						true),
				Arguments.of(
						c, 
						new Coche ("Renault", "Clio", 2001, 12000), // nuevo objeto con mismos valores
						true),
				Arguments.of(
						c,
						null,  // objeto null
						false),
				Arguments.of(
						c,
						"Cadena", // objeto de distinta clase
						false),
				Arguments.of(
						c,
						new Coche ("Seat", "Clio", 2001, 12000),  // distinta marca
						false),
				Arguments.of(
						c,
						new Coche ("Renault", "Twingo", 2001, 12000), // distinto modelo 
						false),
				Arguments.of(
						c,
						new Coche ("Renault", "Clio", 2006, 12000), // distinto año
						false),
				Arguments.of(
						c,
						new Coche ("Renault", "Clio", 2001, 25000),  // distinto precio
						false)
				);
	}       
}

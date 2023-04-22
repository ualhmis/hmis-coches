package org.hmis;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class MainTest {

	private static Stream<String> rutaProvider() {
		return Stream.of("data/coches.json", "data/coches_invalido.json");
	}

	@Test
	public void testMain() {
		// Arrange
		String ruta = "data/coches.json";

		// Act
		Coche[] coches = JsonReader.leerCochesJSON(ruta);

		// Assert
		Assertions.assertNotNull(coches);
		Assertions.assertEquals(4, coches.length);

		Coche coche1 = coches[0];
		Assertions.assertEquals("Toyota", coche1.getMarca());
		Assertions.assertEquals("Corolla", coche1.getModelo());
		Assertions.assertEquals(2022, coche1.getAño());
		Assertions.assertEquals(22000, coche1.getPrecio());

		Coche coche2 = coches[1];
		Assertions.assertEquals("Ford", coche2.getMarca());
		Assertions.assertEquals("Mustang", coche2.getModelo());
		Assertions.assertEquals(2021, coche2.getAño());
		Assertions.assertEquals(45000, coche2.getPrecio());

		Coche coche3 = coches[2];
		Assertions.assertEquals("Chevrolet", coche3.getMarca());
		Assertions.assertEquals("Camaro", coche3.getModelo());
		Assertions.assertEquals(2023, coche3.getAño());
		Assertions.assertEquals(52000, coche3.getPrecio());

		Coche coche4 = coches[3];
		Assertions.assertEquals("Honda", coche4.getMarca());
		Assertions.assertEquals("Civic", coche4.getModelo());
		Assertions.assertEquals(2022, coche4.getAño());
		Assertions.assertEquals(25000, coche4.getPrecio());

		Assertions.assertEquals(ruta, "data/coches.json");
	}

	@DisplayName("Prueba para leer archivo JSON inválido")
	@ParameterizedTest(name = "Archivo: {0}")
	@ValueSource(strings = { "data/coches_invalido.json", "data/coches_vacio.json" })
	void testLeerCochesJSONInvalido(String ruta) {
		Coche[] coches = JsonReader.leerCochesJSON(ruta);
		assertNull(coches);
	}

	 @ParameterizedTest
	    @MethodSource("rutaProvider")
	    public void testRuta(String ruta) {
	        assertEquals("data/coches.json", Main.getRuta());
	        assertNotNull(Main.getRuta());
	        assertNotEquals("test", Main.getRuta());
	    }

	    private static Stream<Coche[]> cochesProvider() {
	        Coche[] cochesValidos = { new Coche("Toyota", "Corolla", 2022, 22000), new Coche("Ford", "Mustang", 2021, 45000),
	                new Coche("Chevrolet", "Camaro", 2023, 52000), new Coche("Honda", "Civic", 2022, 25000) };
	        Coche[] cochesInvalidos = null;

	        return Stream.of(cochesValidos, cochesInvalidos);
	    }

	    @ParameterizedTest
	    @MethodSource("cochesProvider")
	    public void testCoches(Coche[] coches) {
	        assertNotNull(Main.getCoches());
	        assertEquals(4, Main.getCoches().length);
	        assertNotEquals(5, Main.getCoches().length);
	    }

	    @ParameterizedTest
	    @MethodSource("cochesProvider")
	    public void testToString(Coche[] coches) {
	        Main main = new Main();
	        String cochesString = main.toString();
	        String expected = "Coche [marca=Toyota, modelo=Corolla, año=2022, precio=22000]\n"
	                + "Coche [marca=Ford, modelo=Mustang, año=2021, precio=45000]\n"
	                + "Coche [marca=Chevrolet, modelo=Camaro, año=2023, precio=52000]\n"
	                + "Coche [marca=Honda, modelo=Civic, año=2022, precio=25000]\n";
	        assertTrue(cochesString.contains(expected));
	        assertEquals(cochesString, expected);
	        assertNotEquals("test", cochesString);
	        assertEquals(main.toString(), cochesString);
	    }

	    @Test
	    public void testMainInside() {
	        Main main = new Main();
	        assertNotNull(main);
	    }


}

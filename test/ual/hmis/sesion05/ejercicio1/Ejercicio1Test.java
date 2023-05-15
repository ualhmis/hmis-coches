package ual.hmis.sesion05.ejercicio1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class Ejercicio1Test {
    
	@Test
	void testObjectNotNull() {

		Ejercicio1 ejercicio1 = new Ejercicio1();
		
		assertNotEquals(ejercicio1, null);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 7, 11, 13})
	void testPrimos(int numero) {

		Ejercicio1 ejercicio1 = new Ejercicio1();
		
		assertEquals(numero, ejercicio1.transformar(numero));
	}
	
	@ParameterizedTest
	@CsvSource({"-2, -1","-8, -1","2, 1","8, 1"})
	void testMultiplo2(int numero, int resultado) {

		Ejercicio1 ejercicio1 = new Ejercicio1();
		int numeroTransformado = ejercicio1.transformar(numero);
		
		assertEquals(resultado, numeroTransformado);
	}
	
	@ParameterizedTest
	@CsvSource({"-3, -1","-6, -1","3, 1","6, 1"})
	void testMultiplo3 (int numero, int resultado) {

		Ejercicio1 ejercicio1 = new Ejercicio1();
		int numeroTransformado = ejercicio1.transformar(numero);
		
		assertEquals(resultado, numeroTransformado);
	}
	
	@ParameterizedTest
	@CsvSource({"-5, -1","-10, -1","5, 1","10, 1"})
	void testMultiplo5(int numero, int resultado) {

		Ejercicio1 ejercicio1 = new Ejercicio1();
		int numeroTransformado = ejercicio1.transformar(numero);
		
		assertEquals(resultado, numeroTransformado);
	}
}

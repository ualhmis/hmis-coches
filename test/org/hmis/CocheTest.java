package org.hmis;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class CocheTest {
	@Test
	void testEqualsObject() {
		Coche coche1 = new Coche ();   // Arrange
		assertTrue(coche1.equals(coche1));  // Action // Assert
	}
	
	@Test
	void testEqualsObjectNull() {
		Coche coche1 = new Coche ();   // Arrange
		Coche coche2 = null;
		assertFalse(coche1.equals(coche2));  // Action // Assert
	}
	
	@Test
	void testEqualsObjectString() {
		Coche coche1 = new Coche ();   // Arrange
		String coche2 = "";
		assertFalse(coche1.equals(coche2));  // Action // Assert
	}
	
	@Test
	void testEqualsObjectMultiple1() {
		Coche primero = new Coche ("Chevrolet", "Camaro", 2023, 52000);
		Coche segundo = new Coche ("Chevrolet", "Camaro", 2023, 52000);
		assertEquals(true, primero.equals(segundo));  // Action // Assert
	}
	@Test
	void testEqualsObjectMultiple2() {
		Coche primero = new Coche ("Chevrolet", "Camaro", 2023, 52000);
		Coche segundo = new Coche ("Chevrolet", "Camaro", 2021, 52000);
		assertEquals(false, primero.equals(segundo));  // Action // Assert
	}
	@Test
	void testEqualsObjectMultiple3() {
		Coche primero = new Coche ("Chevrolet", "Camaro", 2023, 52000);
		Coche segundo = new Coche ("Ford", "Camaro", 2023, 52000);
		assertEquals(false, primero.equals(segundo));  // Action // Assert
	}
	@Test
	void testEqualsObjectMultiple4() {
		Coche primero = new Coche ("Chevrolet", "Camaro", 2023, 52000);
		Coche segundo = new Coche ("Chevrolet", "Mustang", 2023, 52000);
		assertEquals(false, primero.equals(segundo));  // Action // Assert
	}
	@Test
	void testEqualsObjectMultiple5() {
		Coche primero = new Coche ("Chevrolet", "Camaro", 2023, 52000);
		Coche segundo = new Coche ("Chevrolet", "Camaro", 2023, 45000);
		assertEquals(false, primero.equals(segundo));  // Action // Assert
	}

	@Test
	void testEqualsGetMarca() {
		Coche coche1 = new Coche ("Chevrolet", "Camaro", 2023, 52000);
		String resultado = "Chevrolet";
		assertEquals(resultado,coche1.getMarca());  // Action // Assert
	}

	@Test
	void testEqualsSetMarca() {
		Coche coche1 = new Coche ("Chevrolet", "Camaro", 2023, 52000);
		String resultado = "Honda";
		coche1.setMarca("Honda");
		assertEquals(resultado, coche1.getMarca());  // Action // Assert
	}

	@Test
	void testEqualsGetModelo() {
		Coche coche1 = new Coche ("Chevrolet", "Camaro", 2023, 52000);
		String resultado = "Camaro";
		assertEquals(resultado, coche1.getModelo());  // Action // Assert
	}

	@Test
	void testEqualsSetModelo() {
		Coche coche1 = new Coche ("Chevrolet", "Camaro", 2023, 52000);
		String resultado = "Civic";
		coche1.setModelo("Civic");
		assertEquals(resultado, coche1.getModelo());  // Action // Assert
	}

	@Test
	void testEqualsGetAño() {
		Coche coche1 = new Coche ("Chevrolet", "Camaro", 2023, 52000);
		int resultado = 2023;
		assertEquals(resultado, coche1.getAño());  // Action // Assert
	}

	@Test
	void testEqualsSetAño() {
		Coche coche1 = new Coche ("Chevrolet", "Camaro", 2023, 52000);
		int resultado = 2023;
		coche1.setAño(2023);
		assertEquals(resultado, coche1.getAño());  // Action // Assert
	}

	@Test
	void testEqualsGetPrecio() {
		Coche coche1 = new Coche ("Chevrolet", "Camaro", 2023, 52000);
		int resultado = 52000;
		assertEquals(resultado, coche1.getPrecio());  // Action // Assert
	}

	@Test
	void testEqualsSetPrecio() {
		Coche coche1 = new Coche ("Chevrolet", "Camaro", 2023, 52000);
		int resultado = 40000;
		coche1.setPrecio(40000);
		assertEquals(resultado, coche1.getPrecio());  // Action // Assert
	}

	@Test
	void testEqualsString() {
		Coche coche1 = new Coche ("Chevrolet", "Camaro", 2023, 52000);
		String resultado = "Coche [marca = Chevrolet, modelo = Camaro, año = 2023, precio = 52000]";
		assertEquals(resultado, coche1.toString());  // Action // Assert
	}

}
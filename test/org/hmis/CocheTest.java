package org.hmis;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CocheTest {

	@Test
	void testEqualsObject() {
		Coche c = new Coche ();   // Arrange
		assertTrue(c.equals(c));  // Action // Assert
	}
	
	@Test
	void testEqualsObjectNull() {
		Coche c = new Coche ();   // Arrange
		Coche c2 = null;
		assertFalse(c.equals(c2));  // Action // Assert
	}
	

	@Test
	void testEqualsObjectString() {
		Coche c = new Coche ();   // Arrange
		String c2 = "";
		assertFalse(c.equals(c2));  // Action // Assert
	}

	
	@Test
	void testEqualsObjectMultiple1() {
		Coche primero = new Coche ("Toyota", "Corolla", 2022, 22000);
		Coche segundo = new Coche ("Toyota", "Corolla", 2022, 22000);
		assertEquals(true, primero.equals(segundo));  // Action // Assert
	}

	@Test
	void testEqualsObjectMultiple2() {
		Coche primero = new Coche ("Toyota", "Corolla", 2022, 22000);
		Coche segundo = new Coche ("Toyota", "Corolla", 2023, 22000);
		assertEquals(false, primero.equals(segundo));  // Action // Assert
	}

	@Test
	void testEqualsObjectMultiple3() {
		Coche primero = new Coche ("Toyota", "Corolla", 2022, 22000);
		Coche segundo = new Coche ("Nissan", "Corolla", 2022, 22000);
		assertEquals(false, primero.equals(segundo));  // Action // Assert
	}

	@Test
	void testEqualsObjectMultiple4() {
		Coche primero = new Coche ("Toyota", "Corolla", 2022, 22000);
		Coche segundo = new Coche ("Toyota", "Auris", 2022, 22000);
		assertEquals(false, primero.equals(segundo));  // Action // Assert
	}

	@Test
	void testEqualsObjectMultiple5() {
		Coche primero = new Coche ("Toyota", "Corolla", 2022, 22000);
		Coche segundo = new Coche ("Toyota", "Corolla", 2022, 32000);
		assertEquals(false, primero.equals(segundo));  // Action // Assert
	}
	
	@Test
	void testGetterMarca() {
		Coche primero = new Coche ("Toyota", "Corolla", 2022, 22000);
		Coche segundo = new Coche ("Tesla", "Llaroco", 2022, 32000);
		String marcaPrimero = primero.getMarca();
		String marcaSegundo = segundo.getMarca();

		assertEquals(false, marcaPrimero.equals(marcaSegundo));  // Action // Assert
	}
	
	@Test
	void testSetterAño() {
		
		Coche primero = new Coche ("Toyota", "Corolla", 2022, 22000);
		Coche segundo = new Coche ("Tesla", "Llaroco", 2005, 32000);
		primero.setAño(2005);
		
	
		assertEquals( primero.getAño(),segundo.getAño());  // Action // Assert
	}
	
	@Test
	void testSetterMarca() {
		
		Coche primero = new Coche ("", "Corolla", 2022, 22000);
		Coche segundo = new Coche ("", "Llaroco", 2022, 32000);
		primero.setMarca("Ferrari");
		segundo.setMarca("Nike");
		String marcaPrimero = primero.getMarca();
		String marcaSegundo = segundo.getMarca();

		assertEquals(false, marcaPrimero.equals(marcaSegundo));  // Action // Assert
	}
	
	@Test
	void testGetterModelo() {
		Coche primero = new Coche ("Toyota", "Corolla", 2022, 22000);
		Coche segundo = new Coche ("Tesla", "Llaroco", 2022, 32000);
		String modeloPrimero = primero.getModelo();
		String modeloSegundo = segundo.getModelo();

		assertEquals(false, modeloPrimero.equals(modeloSegundo));  // Action // Assert
	}
	
	@Test
	void testSetterModelo() {
		Coche primero = new Coche ("Toyota", "", 2022, 22000);
		Coche segundo = new Coche ("Tesla", "", 2022, 32000);
		primero.setModelo("Osasuna");
		segundo.setModelo("Nuncaserinde");

		assertNotEquals(primero,segundo);  // Action // Assert
	}
	
	@Test
	void testGetterPrecio() {

		Coche primero = new Coche ("", "Corolla", 2022, 22000);
		Coche segundo = new Coche ("", "Llaroco", 2022, 32000);
		primero.setPrecio(12000);
		segundo.setPrecio(300000);
		int precioPrimero = primero.getPrecio();
		int precioSegundo = segundo.getPrecio();

		assertNotEquals( precioPrimero,precioSegundo);  // Action // Assert
	}
	
	@Test
	void testSetterPrecio() {
	
		Coche primero = new Coche ("", "Corolla", 2022, 22000);
		Coche segundo = new Coche ("", "Llaroco", 2022, 32000);
		primero.setMarca("Ferrari");
		segundo.setMarca("Nike");
		String precioPrimero = primero.getMarca();
		String precioSegundo = segundo.getMarca();

		assertEquals(false, precioPrimero.equals(precioSegundo));  // Action // Assert
	}
	
	@Test
	void testTostring() {
	
		Coche primero = new Coche ("Ferrari", "Corolla", 2022, 22000);
		Coche segundo = new Coche ("Nike", "Llaroco", 2022, 32000);
	

		assertEquals(false, primero.toString().equals(segundo.toString()));  // Action // Assert
	}

}

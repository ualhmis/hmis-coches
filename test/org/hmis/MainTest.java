package org.hmis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

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

	    // Prueba de lectura de archivo JSON inválido
	    @Test
	    public void testLeerCochesJSONInvalido() {
	        String ruta = "data/coches_invalido.json";
	        Coche[] coches = JsonReader.leerCochesJSON(ruta);
	        assertNull(coches);
	    }
	    
	    @Test
	    public void testRuta() {
	        String ruta = Main.getRuta();
	        assertEquals("data/coches.json", ruta);
	        Assertions.assertNotNull(ruta);
	        Assertions.assertNotEquals("test", ruta);
	        
	    }
	    
	    @Test
	    public void testCoches() {
	        Coche[] coches = Main.getCoches();
	        assertNotNull(coches);
	        assertEquals(4, coches.length);
	        assertNotEquals(5,coches.length);
	    }
	    
	    @Test
	    public void testToString() {
	    	 Main main = new Main();
	    	 Coche[] coches = Main.getCoches();
	    	 
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

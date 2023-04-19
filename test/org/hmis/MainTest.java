package org.hmis;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.*;

class MainTest {

	@Test
	void testObjectNotNull() {
		Main main = new Main();

		assertNotEquals(main, null);
	}

	@Test
	void testMain() {
    	String ruta = "data/coches.json";
    	Coche[] coches = JsonReader.leerCochesJSON(ruta);

    	String cadena = "";

    	for (Coche coche : coches) {
            cadena = cadena + coche + "\r\n";
        }

    	Main.main(null);		
	}
}
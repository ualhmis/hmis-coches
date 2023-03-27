package org.hmis;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JsonReaderTest {

	@Test
	void testLeerCochesJSON() {
		String ruta = "data/coches.json";
		Coche [] coches = JsonReader.leerCochesJSON(ruta);
		assertEquals (4, coches.length);
	}

}

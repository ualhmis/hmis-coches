package org.hmis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CocheTest {

   
    @Test
    void testEquals() {
        Coche primero = new Coche ("Renault", "Clio", 2001, 12000);
        Coche segundo = new Coche ("Renault", "Clio", 2001, 12000);
        assertEquals(primero, segundo, "Los dos coches no son iguales");
    }

    @Test
    void testToString() {
        Coche primero = new Coche ("Renault", "Clio", 2001, 12000);
        assertEquals("Coche [marca=Renault, modelo=Clio, año=2001, precio=12000]", primero.toString());

        
    }
}

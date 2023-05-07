package ual.hmis.sesion05.ejercicio5;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ejercicio5 {

	public <T extends Comparable<T>> Set<T> unirConjuntos(Set<T> conjunto1, Set<T> conjunto2) {

		if (conjunto1.isEmpty())
			if (conjunto2.isEmpty()) return new TreeSet<T>();
			else return conjunto2;
		else if (conjunto2.isEmpty())
			return conjunto1;

        Set<T> conjuntoFusionado = new TreeSet<>();

        Iterator<T> iterator1 = conjunto1.iterator();
        Iterator<T> iterator2 = conjunto2.iterator();
        T elemento1 = null, elemento2 = null;

        while ((iterator1.hasNext() || elemento1 != null) && (iterator2.hasNext() || elemento2 != null)) {
            if (elemento1 == null && iterator1.hasNext())
            	elemento1 = iterator1.next();

            if (elemento2 == null && iterator2.hasNext())
                elemento2 = iterator2.next();

            if (elemento1 != null && elemento2 != null) {
                if (elemento1.compareTo(elemento2) < 0) {
                    conjuntoFusionado.add(elemento1);
                    elemento1 = null;
                } else if (elemento1.compareTo(elemento2) > 0) {
                    conjuntoFusionado.add(elemento2);
                    elemento2 = null;
                } else {
                    conjuntoFusionado.add(elemento1);
                    elemento1 = null;
                    elemento2 = null;
                }
            }
        }

        while (iterator1.hasNext() || elemento1 != null) {
            if (elemento1 == null && iterator1.hasNext())
                elemento1 = iterator1.next();

            if (elemento1 != null) {
                conjuntoFusionado.add(elemento1);
                elemento1 = null;
            }
        }

        while (iterator2.hasNext() || elemento2 != null) {
            if (elemento2 == null && iterator2.hasNext())
                elemento2 = iterator2.next();

            if (elemento2 != null) {
                conjuntoFusionado.add(elemento2);
                elemento2 = null;
            }
        }

        return conjuntoFusionado;
	}
}
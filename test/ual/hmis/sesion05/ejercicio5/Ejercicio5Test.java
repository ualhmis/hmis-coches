package ual.hmis.sesion05.ejercicio5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class Ejercicio5Test {

	@Test
	void testObjectNotNull() {

		Ejercicio5 ejercicio5 = new Ejercicio5();

		assertNotEquals(ejercicio5, null);
	}

	@ParameterizedTest
	@CsvFileSource(files = "test/ual/hmis/sesion05/ejercicio5/conjVacio.csv.txt")
	void testPrimerConjuntoVacio(String conjuntoCSV) {

		Ejercicio5 ejercicio5 = new Ejercicio5();

        Set<String> conjunto1 = new TreeSet<>();
        Set<String> conjunto2 = new TreeSet<>();

        for (String s : conjuntoCSV.split(", ")) {
        	conjunto2.add(s);
        }

		assertArrayEquals(conjunto2.toArray(), ejercicio5.unirConjuntos(conjunto1, conjunto2).toArray());
	}
	
	@ParameterizedTest
	@CsvFileSource(files = "test/ual/hmis/sesion05/ejercicio5/conjVacio.csv.txt")
	void testSegundoConjuntoVacio(String conjuntoCSV) {

		Ejercicio5 ejercicio5 = new Ejercicio5();

        Set<String> conjunto1 = new TreeSet<>();
        Set<String> conjunto2 = new TreeSet<>();
        
        for (String s : conjuntoCSV.split(", ")) {
        	conjunto1.add(s);
        }

		assertArrayEquals(conjunto1.toArray(), ejercicio5.unirConjuntos(conjunto1, conjunto2).toArray());
	}
	
	@Test
	void testConjuntosVacios() {

		Ejercicio5 ejercicio5 = new Ejercicio5();

        Set<Integer> conjunto1 = new TreeSet<>();
        Set<Integer> conjunto2 = new TreeSet<>();
        Set<Integer> conjuntoFusionado = new TreeSet<>();

		assertArrayEquals(conjuntoFusionado.toArray(), ejercicio5.unirConjuntos(conjunto1, conjunto2).toArray());
	}
	
	Set<Integer> darFormatoConjuntoTipoInteger(String conjuntoCSV) {

        Set<Integer> conjunto = new TreeSet<>();

        for (String s : conjuntoCSV.split(", ")) {
        	conjunto.add(Integer.parseInt(s));
        }

		return conjunto;
	}

	@ParameterizedTest
	@CsvFileSource(files = "test/ual/hmis/sesion05/ejercicio5/conjInt.csv.txt")
	void testFusionarConjuntosTipoInteger(String conjuntosCSV) {

		Ejercicio5 ejercicio5 = new Ejercicio5();

        String[] arrayConjuntosCSV = conjuntosCSV.split("; ");

        Set<Integer> conjunto1 = darFormatoConjuntoTipoInteger(arrayConjuntosCSV[0]);
        Set<Integer> conjunto2 = darFormatoConjuntoTipoInteger(arrayConjuntosCSV[1]);
        Set<Integer> conjuntoFusionado = darFormatoConjuntoTipoInteger(arrayConjuntosCSV[2]);

		assertArrayEquals(conjuntoFusionado.toArray(), ejercicio5.unirConjuntos(conjunto1, conjunto2).toArray());
	}
	
	Set<Double> darFormatoConjuntoTipoDouble(String conjuntoCSV) {

        Set<Double> conjunto = new TreeSet<>();

        for (String s : conjuntoCSV.split(", ")) {
        	conjunto.add(Double.parseDouble(s));
        }

		return conjunto;
	}

	@ParameterizedTest
	@CsvFileSource(files = "test/ual/hmis/sesion05/ejercicio5/conjDouble.csv.txt")
	void testFusionarConjuntosTipoDouble(String conjuntosCSV) {

		Ejercicio5 ejercicio5 = new Ejercicio5();

        String[] arrayConjuntosCSV = conjuntosCSV.split("; ");

        Set<Double> conjunto1 = darFormatoConjuntoTipoDouble(arrayConjuntosCSV[0]);
        Set<Double> conjunto2 = darFormatoConjuntoTipoDouble(arrayConjuntosCSV[1]);
        Set<Double> conjuntoFusionado = darFormatoConjuntoTipoDouble(arrayConjuntosCSV[2]);

		assertArrayEquals(conjuntoFusionado.toArray(), ejercicio5.unirConjuntos(conjunto1, conjunto2).toArray());
	}
	
	

}
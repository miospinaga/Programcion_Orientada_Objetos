package Excepciones;

import java.util.ArrayList;
import java.util.List;

/** Ejercicio propuesto 2: conversión de un texto no numérico a entero. */
public class ExcepcionFormatoNumero {

    public static List<String> ejecutar() {
        List<String> salida = new ArrayList<>();
        try {
            int numero = Integer.parseInt("Número");
            salida.add(String.valueOf(numero));
        } catch (NumberFormatException e) {
            salida.add("Excepción de formato de número");
        } finally {
            salida.add("Ingresando al finally");
        }
        return salida;
    }

    public static void main(String args[]) {
        ejecutar().forEach(System.out::println);
    }
}

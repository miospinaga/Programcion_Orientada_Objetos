package Excepciones;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 6.4. Lanza diferentes excepciones en situaciones específicas.
 * Los mensajes ayudan a identificar la porción de código que se ejecutó.
 */
public class PruebaExcepciones {

    /** Ejecuta el programa del libro y devuelve lo que imprimiría en consola. */
    public static List<String> ejecutar() {
        List<String> salida = new ArrayList<>();

        // Primer bloque try
        try {
            salida.add("Ingresando al primer try");
            double cociente = 10000 / 0;           // Se lanza una excepción
            salida.add("Después de la división");  // Nunca se ejecuta
        } catch (ArithmeticException e) {          // Se captura la excepción
            salida.add("División por cero");
        } finally {                                // Siempre se ejecuta
            salida.add("Ingresando al primer finally");
        }

        // Segundo bloque try
        try {
            salida.add("Ingresando al segundo try");
            Object objeto = null;
            objeto.toString();                     // Se lanza NullPointerException
            salida.add("Imprimiendo objeto");      // Nunca se ejecuta
        } catch (ArithmeticException e) {          // No es de este tipo
            salida.add("División por cero");
        } catch (Exception e) {                    // Se captura aquí
            salida.add("Ocurrió una excepción");
        } finally {
            salida.add("Ingresando al segundo finally");
        }
        return salida;
    }

    public static void main(String args[]) {
        ejecutar().forEach(System.out::println);
    }
}

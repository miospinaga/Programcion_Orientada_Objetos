package Excepciones;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Ejercicio 6.6. Realiza cálculos numéricos gestionando excepciones.
 * Incluye los métodos del libro (logaritmo neperiano y raíz cuadrada)
 * y los ejercicios propuestos (recta, ecuación cuadrática y cambio de base).
 */
public class CalculosNumericos {

    /** Logaritmo neperiano. Si el valor no es positivo se genera una excepción aritmética. */
    public static String calcularLogaritmoNeperiano(double valor) {
        try {
            if (valor <= 0) {
                throw new ArithmeticException("El valor debe ser un número positivo");
            }
            double resultado = Math.log(valor);
            return "Resultado = " + resultado;
        } catch (ArithmeticException e) {
            return "El valor debe ser un número positivo para calcular el logaritmo";
        }
    }

    /** Raíz cuadrada. Si el valor es negativo se genera una excepción aritmética. */
    public static String calcularRaizCuadrada(double valor) {
        try {
            if (valor < 0) {
                throw new ArithmeticException("El valor debe ser un número positivo");
            }
            double resultado = Math.sqrt(valor);
            return "Resultado = " + resultado;
        } catch (ArithmeticException e) {
            return "El valor debe ser un número positivo para calcular la raíz cuadrada";
        }
    }

    /** Pendiente de la recta que pasa por (x1, y1) y (x2, y2). */
    public static String calcularPendiente(double x1, double y1, double x2, double y2) {
        try {
            if (x1 == x2) {
                throw new ArithmeticException("Los puntos tienen la misma coordenada x");
            }
            double pendiente = (y2 - y1) / (x2 - x1);
            return "Pendiente = " + pendiente;
        } catch (ArithmeticException e) {
            return "La recta es vertical: la pendiente no está definida (división por cero)";
        }
    }

    /** Punto medio del segmento entre (x1, y1) y (x2, y2). */
    public static String calcularPuntoMedio(double x1, double y1, double x2, double y2) {
        double x = (x1 + x2) / 2;
        double y = (y1 + y2) / 2;
        return "Punto medio = (" + x + ", " + y + ")";
    }

    /** Raíces reales de a·x² + b·x + c = 0. */
    public static String calcularRaicesCuadratica(double a, double b, double c) {
        try {
            if (a == 0) {
                throw new ArithmeticException("El coeficiente a no puede ser 0");
            }
            double discriminante = b * b - 4 * a * c;
            if (discriminante < 0) {
                throw new ArithmeticException("El discriminante es negativo (" + discriminante
                        + "): no hay raíces reales");
            }
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            return "x1 = " + x1 + "\nx2 = " + x2;
        } catch (ArithmeticException e) {
            return "No se pueden calcular las raíces: " + e.getMessage();
        }
    }

    /** Convierte un número en base 10 a base b (entre 2 y 36). */
    public static String convertirBase(int numero, int base) {
        try {
            if (base < 2 || base > 36) {
                throw new IllegalArgumentException("La base debe estar entre 2 y 36");
            }
            return numero + " en base " + base + " = " + Integer.toString(numero, base).toUpperCase();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    /**
     * Lee un número decimal desde un texto (equivale a leer por teclado con Scanner).
     * @throws InputMismatchException si el texto no es un número
     * @throws java.util.NoSuchElementException si el texto está vacío
     */
    public static double leerDouble(String texto) {
        double valor = new Scanner(texto).useLocale(Locale.US).nextDouble();
        if (Double.isNaN(valor) || Double.isInfinite(valor)) {
            throw new InputMismatchException("El valor debe ser finito");
        }
        return valor;
    }

    /** Lee un número entero desde un texto. */
    public static int leerEntero(String texto) {
        return new Scanner(texto).nextInt();
    }
}

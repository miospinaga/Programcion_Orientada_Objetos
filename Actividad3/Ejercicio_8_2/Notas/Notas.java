package Notas;

/**
 * Clase que almacena las notas y calcula las métricas estadísticas.
 */
public class Notas {

    private double[] listaNotas;

    public Notas(double[] listaNotas) {
        this.listaNotas = listaNotas;
    }

    public double calcularPromedio() {
        double suma = 0;
        for (double nota : listaNotas) {
            suma += nota;
        }
        return suma / listaNotas.length;
    }

    // Desviación estándar poblacional: raíz de (suma de (nota - promedio)^2 / n)
    public double calcularDesviacion() {
        double promedio = calcularPromedio();
        double suma = 0;
        for (double nota : listaNotas) {
            suma += Math.pow(nota - promedio, 2);
        }
        return Math.sqrt(suma / listaNotas.length);
    }

    public double calcularMayor() {
        double mayor = listaNotas[0];
        for (double nota : listaNotas) {
            if (nota > mayor) {
                mayor = nota;
            }
        }
        return mayor;
    }

    public double calcularMenor() {
        double menor = listaNotas[0];
        for (double nota : listaNotas) {
            if (nota < menor) {
                menor = nota;
            }
        }
        return menor;
    }
}

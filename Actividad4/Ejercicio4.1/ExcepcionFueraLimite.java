package Excepciones;

import java.util.ArrayList;
import java.util.List;

/** Ejercicio propuesto 1: acceso a un índice fuera del límite de un String. */
public class ExcepcionFueraLimite {

    public static List<String> ejecutar() {
        List<String> salida = new ArrayList<>();
        try {
            String texto = "Programación";
            char caracter = texto.charAt(14);
            salida.add(String.valueOf(caracter));
        } catch (StringIndexOutOfBoundsException e) {
            salida.add("Indice de string por fuera del limite");
        }
        return salida;
    }

    public static void main(String args[]) {
        ejecutar().forEach(System.out::println);
    }
}

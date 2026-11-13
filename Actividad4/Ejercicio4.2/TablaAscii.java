package Excepciones;

import java.util.HashMap;
import java.util.Map;

/** Ejercicio propuesto 2: tabla ASCII que asocia símbolos con números. */
public class TablaAscii {

    private final Map<String, Integer> tabla = new HashMap<>();

    /** Carga los caracteres imprimibles (códigos 32 a 126). */
    public TablaAscii() {
        for (int i = 32; i <= 126; i++) {
            tabla.put(String.valueOf((char) i), i);
        }
    }

    /**
     * Recupera el número asociado a un símbolo.
     * @throws IllegalArgumentException si el símbolo es nulo
     * @throws SimboloInexistenteException si el símbolo no existe en la tabla
     */
    public int get(String simbolo) throws SimboloInexistenteException {
        if (simbolo == null) {
            throw new IllegalArgumentException("El símbolo no puede ser nulo.");
        }
        Integer numero = tabla.get(simbolo);
        if (numero == null) {
            throw new SimboloInexistenteException("El símbolo \"" + simbolo + "\" no existe en la tabla.");
        }
        return numero;
    }

    /**
     * Asocia un número con un símbolo.
     * @throws IllegalArgumentException si el símbolo es nulo o vacío, o el número no está entre 0 y 127
     */
    public void set(String simbolo, int numero) {
        if (simbolo == null || simbolo.isEmpty()) {
            throw new IllegalArgumentException("El símbolo no puede ser nulo ni vacío.");
        }
        if (numero < 0 || numero > 127) {
            throw new IllegalArgumentException("El número debe estar entre 0 y 127.");
        }
        tabla.put(simbolo, numero);
    }
}

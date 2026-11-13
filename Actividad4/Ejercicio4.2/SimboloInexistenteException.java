package Excepciones;

/** Se lanza cuando se consulta un símbolo que no existe en la tabla ASCII. */
public class SimboloInexistenteException extends Exception {

    public SimboloInexistenteException(String mensaje) {
        super(mensaje);
    }
}

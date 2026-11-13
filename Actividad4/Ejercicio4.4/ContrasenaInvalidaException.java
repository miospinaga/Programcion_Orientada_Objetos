package Excepciones;

/** Se lanza cuando una contraseña no cumple los requisitos. */
public class ContrasenaInvalidaException extends Exception {

    public ContrasenaInvalidaException(String mensaje) {
        super(mensaje);
    }
}

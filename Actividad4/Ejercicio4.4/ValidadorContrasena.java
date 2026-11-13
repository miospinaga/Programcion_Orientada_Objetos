package Excepciones;

/** Ejercicio propuesto: validación de una contraseña con confirmación. */
public class ValidadorContrasena {

    /**
     * Valida la contraseña y su confirmación.
     * @throws ContrasenaInvalidaException si no se cumple algún requisito
     */
    public static void validar(String contrasena, String confirmacion) throws ContrasenaInvalidaException {
        if (contrasena == null || contrasena.length() < 8) {
            throw new ContrasenaInvalidaException("La contraseña debe tener mínimo 8 caracteres.");
        }
        boolean minuscula = false, mayuscula = false, numero = false, especial = false;
        for (int i = 0; i < contrasena.length(); i++) {
            char c = contrasena.charAt(i);
            if (Character.isWhitespace(c)) {
                throw new ContrasenaInvalidaException("La contraseña no debe tener espacios en blanco.");
            } else if (Character.isLowerCase(c)) {
                minuscula = true;
            } else if (Character.isUpperCase(c)) {
                mayuscula = true;
            } else if (Character.isDigit(c)) {
                numero = true;
            } else {
                especial = true;
            }
        }
        if (!minuscula) {
            throw new ContrasenaInvalidaException("La contraseña debe tener al menos una letra minúscula.");
        }
        if (!mayuscula) {
            throw new ContrasenaInvalidaException("La contraseña debe tener al menos una letra mayúscula.");
        }
        if (!numero) {
            throw new ContrasenaInvalidaException("La contraseña debe tener al menos un número.");
        }
        if (!especial) {
            throw new ContrasenaInvalidaException("La contraseña debe tener al menos un carácter especial.");
        }
        if (!contrasena.equals(confirmacion)) {
            throw new ContrasenaInvalidaException("Las contraseñas no coinciden.");
        }
    }
}

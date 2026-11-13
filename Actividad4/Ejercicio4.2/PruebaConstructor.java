package Excepciones;

/** Ejercicio propuesto 1: intenta crear un objeto y detecta la excepción del constructor. */
public class PruebaConstructor {

    public static String intentarCrear(String nombre, double precio) {
        try {
            Producto producto = new Producto(nombre, precio);
            return "Objeto creado correctamente: " + producto;
        } catch (IllegalArgumentException e) {
            return "Excepción detectada desde el constructor:\n" + e.getMessage();
        }
    }
}

package Excepciones;

/**
 * Ejercicio 6.5. Modela un vendedor con nombre, apellidos y edad.
 * La edad se valida lanzando IllegalArgumentException.
 */
public class Vendedor {

    private String nombre;     // Nombre del vendedor
    private String apellidos;  // Apellidos del vendedor
    private int edad;          // Edad del vendedor

    public Vendedor(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    /** Devuelve los datos del vendedor como texto. */
    public String obtenerDatos() {
        return "Nombre del vendedor = " + nombre + "\n"
             + "Apellidos del vendedor = " + apellidos + "\n"
             + "Edad del vendedor = " + edad;
    }

    /** Muestra en consola los datos del vendedor. */
    public void imprimir() {
        System.out.println(obtenerDatos());
    }

    /**
     * Verifica que la edad esté entre 0 y 120 y que el vendedor sea mayor de edad.
     * @throws IllegalArgumentException si la edad no cumple los requisitos
     */
    public void verificarEdad(int edad) {
        if (edad < 0 || edad > 120) {
            throw new IllegalArgumentException("La edad no puede ser negativa ni mayor a 120.");
        }
        if (edad < 18) {
            throw new IllegalArgumentException("El vendedor debe ser mayor de 18 años.");
        }
        this.edad = edad;
    }
}

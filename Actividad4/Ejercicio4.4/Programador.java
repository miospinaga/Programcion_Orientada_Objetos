package Excepciones;

/** Ejercicio 6.7. Modela un integrante de un equipo de maratón de programación. */
public class Programador {

    private String nombre;     // Nombre del programador
    private String apellidos;  // Apellidos del programador

    public Programador(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos;
    }
}

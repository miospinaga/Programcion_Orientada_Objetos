package Excepciones;

/**
 * Ejercicio 6.7. Modela un equipo de programadores que participará en una
 * maratón de programación (mínimo dos y máximo tres integrantes).
 */
public class EquipoMaratonProgramacion {

    private String nombreEquipo;
    private String universidad;
    private String lenguajeProgramacion;
    private Programador[] programadores;
    private int tamanoEquipo;

    public EquipoMaratonProgramacion(String nombreEquipo, String universidad, String lenguajeProgramacion) {
        this.nombreEquipo = nombreEquipo;
        this.universidad = universidad;
        this.lenguajeProgramacion = lenguajeProgramacion;
        this.tamanoEquipo = 0;                       // El tamaño inicial es cero
        this.programadores = new Programador[3];     // Array con tres programadores
    }

    /** Determina si el array de programadores está lleno. */
    public boolean estaLleno() {
        return tamanoEquipo == programadores.length;
    }

    /** Determina si el equipo ya tiene el mínimo de dos integrantes. */
    public boolean cumpleMinimo() {
        return tamanoEquipo >= 2;
    }

    /**
     * Añade un programador al equipo.
     * @throws Exception si el equipo está completo
     */
    public void anadir(Programador programador) throws Exception {
        if (estaLleno()) {
            throw new Exception("El equipo está completo. No se pudo agregar programador.");
        }
        programadores[tamanoEquipo] = programador;
        tamanoEquipo++;
    }

    /**
     * Valida un campo: no debe estar vacío, no debe tener dígitos
     * y su longitud no debe ser superior a 20 caracteres.
     * @throws Exception si el campo no cumple los criterios
     */
    public static void validarCampo(String campo) throws Exception {
        if (campo == null || campo.trim().isEmpty()) {
            throw new Exception("El campo no puede estar vacío.");
        }
        for (int j = 0; j < campo.length(); j++) {
            char c = campo.charAt(j);
            if (Character.isDigit(c)) {
                throw new Exception("El nombre no puede tener dígitos.");
            }
        }
        if (campo.length() > 20) {
            throw new Exception("La longitud no debe ser superior a 20 caracteres.");
        }
    }

    /** Devuelve los datos del equipo y de sus integrantes como texto. */
    public String obtenerDatos() {
        StringBuilder sb = new StringBuilder();
        sb.append("Equipo: ").append(nombreEquipo).append("\n");
        sb.append("Universidad: ").append(universidad).append("\n");
        sb.append("Lenguaje: ").append(lenguajeProgramacion).append("\n");
        sb.append("Integrantes (").append(tamanoEquipo).append("/").append(programadores.length).append("):\n");
        for (int i = 0; i < tamanoEquipo; i++) {
            sb.append("  ").append(i + 1).append(". ").append(programadores[i]).append("\n");
        }
        if (estaLleno()) {
            sb.append("El equipo está completo.");
        } else if (cumpleMinimo()) {
            sb.append("El equipo ya cumple el mínimo de 2 integrantes.");
        } else {
            sb.append("Faltan integrantes: el mínimo es 2.");
        }
        return sb.toString();
    }
}

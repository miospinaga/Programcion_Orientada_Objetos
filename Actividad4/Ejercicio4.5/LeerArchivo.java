package Archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * Ejercicio 6.8. Lee los datos presentes en un archivo de texto (.txt)
 * usando un flujo de bytes (FileInputStream), un conversor a caracteres
 * (InputStreamReader) y un buffer de lectura (BufferedReader).
 */
public class LeerArchivo {

    /**
     * Lee un archivo de texto línea a línea.
     * @param nombreArchivo ruta del archivo a leer
     * @return el contenido del archivo
     * @throws IOException si no se pudo leer el archivo
     */
    public static String leer(String nombreArchivo) throws IOException {
        StringBuilder contenido = new StringBuilder();
        // El bloque try-with-resources cierra los flujos automáticamente
        try (FileInputStream archivo = new FileInputStream(nombreArchivo);          // Flujo de bytes
             InputStreamReader conversor = new InputStreamReader(archivo, StandardCharsets.UTF_8); // Bytes a caracteres
             BufferedReader filtro = new BufferedReader(conversor)) {                // Buffer de lectura
            String linea = filtro.readLine();
            while (linea != null) {
                contenido.append(linea).append("\n");   // Agrega una línea del archivo
                linea = filtro.readLine();              // Lee la siguiente línea
            }
        }
        return contenido.toString();
    }

    /** Ejercicio propuesto 2: lee el archivo y convierte los caracteres a mayúsculas. */
    public static String leerEnMayusculas(String nombreArchivo) throws IOException {
        return leer(nombreArchivo).toUpperCase();
    }

    /** Crea un archivo de ejemplo con 10 líneas ("Linea 1" ... "Linea 10"). */
    public static void crearArchivoEjemplo(String nombreArchivo) throws IOException {
        try (BufferedWriter escritor = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(nombreArchivo), StandardCharsets.UTF_8))) {
            for (int i = 1; i <= 10; i++) {
                escritor.write("Linea " + i);
                escritor.newLine();
            }
        }
    }

    /** Lee "prueba.txt" y muestra su contenido en la consola (como en el libro). */
    public static void main(String[] args) {
        try {
            System.out.print(leer("prueba.txt"));
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo.");
        }
    }
}

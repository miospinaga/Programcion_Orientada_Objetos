package Archivos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/** Interfaz gráfica del Ejercicio 6.8 (Lectura de archivos). */
public class VentanaArchivos extends JFrame {

    private final JTextField txtArchivo = new JTextField("prueba.txt");
    private final JTextArea salida = new JTextArea();

    public VentanaArchivos() {
        super("Ejercicio 6.8 - Lectura de archivos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(620, 460);
        setLocationRelativeTo(null);

        JButton btnExaminar = new JButton("Examinar...");
        JButton btnLeer = new JButton("Leer archivo");
        JButton btnMayusculas = new JButton("Leer en mayúsculas");
        JButton btnEjemplo = new JButton("Crear archivo de ejemplo");

        btnExaminar.addActionListener(e -> examinar());
        btnLeer.addActionListener(e -> leer(false));
        btnMayusculas.addActionListener(e -> leer(true));
        btnEjemplo.addActionListener(e -> crearEjemplo());

        JPanel fila = new JPanel(new BorderLayout(8, 0));
        fila.add(new JLabel("Nombre del archivo:"), BorderLayout.WEST);
        fila.add(txtArchivo, BorderLayout.CENTER);
        fila.add(btnExaminar, BorderLayout.EAST);

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 4));
        botones.add(btnLeer);
        botones.add(btnMayusculas);
        botones.add(btnEjemplo);

        JPanel arriba = new JPanel(new BorderLayout(0, 6));
        arriba.add(fila, BorderLayout.NORTH);
        arriba.add(botones, BorderLayout.SOUTH);

        salida.setEditable(false);
        salida.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));

        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.setBorder(new EmptyBorder(12, 12, 12, 12));
        panel.add(arriba, BorderLayout.NORTH);
        panel.add(new JScrollPane(salida), BorderLayout.CENTER);
        add(panel);
    }

    private void examinar() {
        JFileChooser selector = new JFileChooser(new File("."));
        if (selector.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            txtArchivo.setText(selector.getSelectedFile().getAbsolutePath());
        }
    }

    private void leer(boolean mayusculas) {
        String nombre = txtArchivo.getText().trim();
        if (nombre.isEmpty()) {
            salida.setText("Debe ingresar el nombre del archivo.");
            return;
        }
        String ruta = new File(nombre).getAbsolutePath();
        try {
            String contenido = mayusculas ? LeerArchivo.leerEnMayusculas(nombre) : LeerArchivo.leer(nombre);
            salida.setText("--- " + ruta + " ---\n" + contenido);
        } catch (FileNotFoundException e) {
            salida.setText("No se pudo leer el archivo.\nNo se encontró: " + ruta);
        } catch (IOException e) {
            salida.setText("No se pudo leer el archivo.\n" + e.getMessage());
        }
    }

    private void crearEjemplo() {
        String nombre = txtArchivo.getText().trim();
        if (nombre.isEmpty()) {
            salida.setText("Debe ingresar el nombre del archivo.");
            return;
        }
        File archivo = new File(nombre);
        if (archivo.exists()) {
            int opcion = JOptionPane.showConfirmDialog(this,
                    "El archivo ya existe y se sobrescribirá. ¿Continuar?",
                    "Confirmar", JOptionPane.YES_NO_OPTION);
            if (opcion != JOptionPane.YES_OPTION) {
                return;
            }
        }
        try {
            LeerArchivo.crearArchivoEjemplo(nombre);
            salida.setText("Archivo de ejemplo creado en:\n" + archivo.getAbsolutePath());
        } catch (IOException e) {
            salida.setText("No se pudo crear el archivo.\n" + e.getMessage());
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new VentanaArchivos().setVisible(true));
    }
}

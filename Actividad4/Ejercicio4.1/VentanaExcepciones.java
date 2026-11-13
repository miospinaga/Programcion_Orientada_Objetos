package Excepciones;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/** Interfaz gráfica del Ejercicio 6.4 (Excepciones). */
public class VentanaExcepciones extends JFrame {

    private final JTextArea areaSalida = new JTextArea();

    public VentanaExcepciones() {
        super("Ejercicio 6.4 - Excepciones");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(560, 380);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8, 8));

        JLabel titulo = new JLabel("Elige un programa para ejecutar:", JLabel.CENTER);
        titulo.setBorder(new EmptyBorder(10, 0, 0, 0));
        add(titulo, BorderLayout.NORTH);

        areaSalida.setEditable(false);
        areaSalida.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(areaSalida);
        scroll.setBorder(new EmptyBorder(0, 10, 0, 10));
        add(scroll, BorderLayout.CENTER);

        JButton btnPrueba = new JButton("PruebaExcepciones");
        JButton btnLimite = new JButton("Fuera de límite");
        JButton btnFormato = new JButton("Formato de número");
        JButton btnLimpiar = new JButton("Limpiar");

        btnPrueba.addActionListener(e -> mostrar("PruebaExcepciones", PruebaExcepciones.ejecutar()));
        btnLimite.addActionListener(e -> mostrar("ExcepcionFueraLimite", ExcepcionFueraLimite.ejecutar()));
        btnFormato.addActionListener(e -> mostrar("ExcepcionFormatoNumero", ExcepcionFormatoNumero.ejecutar()));
        btnLimpiar.addActionListener(e -> areaSalida.setText(""));

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 8));
        botones.add(btnPrueba);
        botones.add(btnLimite);
        botones.add(btnFormato);
        botones.add(btnLimpiar);
        add(botones, BorderLayout.SOUTH);
    }

    private void mostrar(String programa, List<String> lineas) {
        StringBuilder sb = new StringBuilder("--- " + programa + " ---\n");
        for (String linea : lineas) {
            sb.append(linea).append('\n');
        }
        areaSalida.setText(sb.toString());
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new VentanaExcepciones().setVisible(true));
    }
}

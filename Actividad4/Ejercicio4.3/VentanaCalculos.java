package Excepciones;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/** Interfaz gráfica del Ejercicio 6.6 (Catchs múltiples). */
public class VentanaCalculos extends JFrame {

    /** Cálculo que recibe los textos de los campos y devuelve el resultado. */
    private interface Calculo {
        String ejecutar(String[] textos);
    }

    public VentanaCalculos() {
        super("Ejercicio 6.6 - Catchs múltiples");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(620, 440);
        setLocationRelativeTo(null);

        JTabbedPane pestanas = new JTabbedPane();

        pestanas.addTab("Logaritmo y raíz", crearPanel(
                new String[]{"Valor numérico:"},
                new String[]{"Calcular logaritmo y raíz"},
                new Calculo[]{t -> {
                    double valor = CalculosNumericos.leerDouble(t[0]);
                    return "Logaritmo neperiano:\n" + CalculosNumericos.calcularLogaritmoNeperiano(valor)
                            + "\n\nRaíz cuadrada:\n" + CalculosNumericos.calcularRaizCuadrada(valor);
                }}));

        pestanas.addTab("Recta", crearPanel(
                new String[]{"x1:", "y1:", "x2:", "y2:"},
                new String[]{"Pendiente", "Punto medio"},
                new Calculo[]{
                    t -> CalculosNumericos.calcularPendiente(d(t[0]), d(t[1]), d(t[2]), d(t[3])),
                    t -> CalculosNumericos.calcularPuntoMedio(d(t[0]), d(t[1]), d(t[2]), d(t[3]))}));

        pestanas.addTab("Ecuación cuadrática", crearPanel(
                new String[]{"a:", "b:", "c:"},
                new String[]{"Calcular raíces"},
                new Calculo[]{t -> CalculosNumericos.calcularRaicesCuadratica(d(t[0]), d(t[1]), d(t[2]))}));

        pestanas.addTab("Cambio de base", crearPanel(
                new String[]{"Número en base 10:", "Base b (2 a 36):"},
                new String[]{"Convertir"},
                new Calculo[]{t -> CalculosNumericos.convertirBase(
                        CalculosNumericos.leerEntero(t[0]), CalculosNumericos.leerEntero(t[1]))}));

        add(pestanas);
    }

    private static double d(String texto) {
        return CalculosNumericos.leerDouble(texto);
    }

    /** Construye una pestaña con campos, botones y un área de resultados. */
    private JPanel crearPanel(String[] etiquetas, String[] nombresBotones, Calculo[] calculos) {
        JTextField[] campos = new JTextField[etiquetas.length];
        JPanel formulario = new JPanel(new GridLayout(etiquetas.length, 2, 8, 8));
        for (int i = 0; i < etiquetas.length; i++) {
            campos[i] = new JTextField();
            formulario.add(new JLabel(etiquetas[i]));
            formulario.add(campos[i]);
        }

        JTextArea salida = new JTextArea();
        salida.setEditable(false);
        salida.setLineWrap(true);
        salida.setWrapStyleWord(true);
        salida.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 4));
        for (int i = 0; i < nombresBotones.length; i++) {
            Calculo calculo = calculos[i];
            JButton boton = new JButton(nombresBotones[i]);
            boton.addActionListener(e -> salida.setText(ejecutarSeguro(calculo, campos)));
            botones.add(boton);
        }

        JPanel arriba = new JPanel(new BorderLayout(0, 6));
        arriba.add(formulario, BorderLayout.CENTER);
        arriba.add(botones, BorderLayout.SOUTH);

        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.setBorder(new EmptyBorder(12, 12, 12, 12));
        panel.add(arriba, BorderLayout.NORTH);
        panel.add(new JScrollPane(salida), BorderLayout.CENTER);
        return panel;
    }

    /** Ejecuta el cálculo con catchs múltiples: primero el específico, luego el general. */
    private String ejecutarSeguro(Calculo calculo, JTextField[] campos) {
        String[] textos = new String[campos.length];
        for (int i = 0; i < campos.length; i++) {
            textos[i] = campos[i].getText().trim();
        }
        try {
            return calculo.ejecutar(textos);
        } catch (InputMismatchException e) {
            return "El valor debe ser numérico (use punto para los decimales).";
        } catch (NoSuchElementException e) {
            return "Debe ingresar todos los valores.";
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new VentanaCalculos().setVisible(true));
    }
}

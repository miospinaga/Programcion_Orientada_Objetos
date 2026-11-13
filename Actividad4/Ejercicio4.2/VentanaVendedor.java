package Excepciones;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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

/** Interfaz gráfica del Ejercicio 6.5 (Lanzamiento de excepciones). */
public class VentanaVendedor extends JFrame {

    private final TablaAscii tablaAscii = new TablaAscii();

    public VentanaVendedor() {
        super("Ejercicio 6.5 - Lanzamiento de excepciones");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(580, 430);
        setLocationRelativeTo(null);

        JTabbedPane pestanas = new JTabbedPane();
        pestanas.addTab("Vendedor", crearPanelVendedor());
        pestanas.addTab("Constructor con excepción", crearPanelConstructor());
        pestanas.addTab("Tabla ASCII", crearPanelAscii());
        add(pestanas);
    }

    // ---------- Pestaña 1: Vendedor ----------
    private JPanel crearPanelVendedor() {
        JTextField txtNombre = new JTextField();
        JTextField txtApellidos = new JTextField();
        JTextField txtEdad = new JTextField();
        JTextArea salida = nuevaSalida();
        JButton btnVerificar = new JButton("Verificar edad");

        btnVerificar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            String apellidos = txtApellidos.getText().trim();
            if (nombre.isEmpty() || apellidos.isEmpty()) {
                salida.setText("Debe ingresar el nombre y los apellidos.");
                return;
            }
            try {
                Vendedor vendedor = new Vendedor(nombre, apellidos);
                vendedor.verificarEdad(Integer.parseInt(txtEdad.getText().trim()));
                salida.setText(vendedor.obtenerDatos());
            } catch (NumberFormatException ex) {
                salida.setText("La edad debe ser un número entero.");
            } catch (IllegalArgumentException ex) {
                salida.setText("IllegalArgumentException: " + ex.getMessage());
            }
        });

        return armar(new String[]{"Nombre del vendedor:", "Apellidos del vendedor:", "Edad del vendedor:"},
                new JTextField[]{txtNombre, txtApellidos, txtEdad}, new JButton[]{btnVerificar}, salida);
    }

    // ---------- Pestaña 2: constructor que lanza excepción ----------
    private JPanel crearPanelConstructor() {
        JTextField txtNombre = new JTextField();
        JTextField txtPrecio = new JTextField();
        JTextArea salida = nuevaSalida();
        JButton btnCrear = new JButton("Crear objeto");

        btnCrear.addActionListener(e -> {
            try {
                double precio = Double.parseDouble(txtPrecio.getText().trim());
                salida.setText(PruebaConstructor.intentarCrear(txtNombre.getText(), precio));
            } catch (NumberFormatException ex) {
                salida.setText("El precio debe ser un número.");
            }
        });

        return armar(new String[]{"Nombre del producto:", "Precio:"},
                new JTextField[]{txtNombre, txtPrecio}, new JButton[]{btnCrear}, salida);
    }

    // ---------- Pestaña 3: tabla ASCII ----------
    private JPanel crearPanelAscii() {
        JTextField txtSimbolo = new JTextField();
        JTextField txtNumero = new JTextField();
        JTextArea salida = nuevaSalida();
        JButton btnGet = new JButton("Obtener número (get)");
        JButton btnSet = new JButton("Asignar número (set)");

        btnGet.addActionListener(e -> {
            try {
                // Un campo vacío se envía como null para probar la excepción
                int numero = tablaAscii.get(textoONulo(txtSimbolo));
                salida.setText("get(\"" + txtSimbolo.getText() + "\") = " + numero);
            } catch (SimboloInexistenteException ex) {
                salida.setText("SimboloInexistenteException: " + ex.getMessage());
            } catch (IllegalArgumentException ex) {
                salida.setText("IllegalArgumentException: " + ex.getMessage());
            }
        });

        btnSet.addActionListener(e -> {
            try {
                int numero = Integer.parseInt(txtNumero.getText().trim());
                tablaAscii.set(textoONulo(txtSimbolo), numero);
                salida.setText("Se asoció \"" + txtSimbolo.getText() + "\" con el número " + numero);
            } catch (NumberFormatException ex) {
                salida.setText("El número debe ser un entero.");
            } catch (IllegalArgumentException ex) {
                salida.setText("IllegalArgumentException: " + ex.getMessage());
            }
        });

        return armar(new String[]{"Símbolo (vacío = null):", "Número (solo para set):"},
                new JTextField[]{txtSimbolo, txtNumero}, new JButton[]{btnGet, btnSet}, salida);
    }

    // ---------- Utilidades ----------
    private String textoONulo(JTextField campo) {
        return campo.getText().isEmpty() ? null : campo.getText();
    }

    private JTextArea nuevaSalida() {
        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        return area;
    }

    private JPanel armar(String[] etiquetas, JTextField[] campos, JButton[] botones, JTextArea salida) {
        JPanel formulario = new JPanel(new GridLayout(etiquetas.length, 2, 8, 8));
        for (int i = 0; i < etiquetas.length; i++) {
            formulario.add(new JLabel(etiquetas[i]));
            formulario.add(campos[i]);
        }
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 4));
        for (JButton boton : botones) {
            panelBotones.add(boton);
        }
        JPanel arriba = new JPanel(new BorderLayout(0, 6));
        arriba.add(formulario, BorderLayout.CENTER);
        arriba.add(panelBotones, BorderLayout.SOUTH);

        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.setBorder(new EmptyBorder(12, 12, 12, 12));
        panel.add(arriba, BorderLayout.NORTH);
        panel.add(new JScrollPane(salida), BorderLayout.CENTER);
        return panel;
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new VentanaVendedor().setVisible(true));
    }
}

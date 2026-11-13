package Excepciones;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/** Interfaz gráfica del Ejercicio 6.7 (Validación de campos). */
public class VentanaMaraton extends JFrame {

    private EquipoMaratonProgramacion equipo;  // Equipo creado (null hasta que se cree)

    public VentanaMaraton() {
        super("Ejercicio 6.7 - Validación de campos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 520);
        setLocationRelativeTo(null);

        JTabbedPane pestanas = new JTabbedPane();
        pestanas.addTab("Equipo de maratón", crearPanelEquipo());
        pestanas.addTab("Contraseña", crearPanelContrasena());
        add(pestanas);
    }

    // ---------- Pestaña 1: equipo de maratón ----------
    private JPanel crearPanelEquipo() {
        JTextField txtEquipo = new JTextField();
        JTextField txtUniversidad = new JTextField();
        JTextField txtLenguaje = new JTextField();
        JTextField txtNombre = new JTextField();
        JTextField txtApellidos = new JTextField();
        JTextArea salida = nuevaSalida();
        salida.setText("1. Cree el equipo.\n2. Añada de 2 a 3 integrantes.");

        JPanel formulario = new JPanel(new GridLayout(5, 2, 8, 6));
        formulario.add(new JLabel("Nombre del equipo:"));
        formulario.add(txtEquipo);
        formulario.add(new JLabel("Universidad:"));
        formulario.add(txtUniversidad);
        formulario.add(new JLabel("Lenguaje de programación:"));
        formulario.add(txtLenguaje);
        formulario.add(new JLabel("Nombre del integrante:"));
        formulario.add(txtNombre);
        formulario.add(new JLabel("Apellidos del integrante:"));
        formulario.add(txtApellidos);

        JButton btnCrear = new JButton("Crear equipo");
        JButton btnAnadir = new JButton("Añadir integrante");

        btnCrear.addActionListener(e -> {
            String nombre = txtEquipo.getText().trim();
            String universidad = txtUniversidad.getText().trim();
            String lenguaje = txtLenguaje.getText().trim();
            if (nombre.isEmpty() || universidad.isEmpty() || lenguaje.isEmpty()) {
                salida.setText("Debe completar el nombre del equipo, la universidad y el lenguaje.");
                return;
            }
            equipo = new EquipoMaratonProgramacion(nombre, universidad, lenguaje);
            salida.setText("Equipo creado.\n\n" + equipo.obtenerDatos());
        });

        btnAnadir.addActionListener(e -> {
            if (equipo == null) {
                salida.setText("Primero debe crear el equipo.");
                return;
            }
            try {
                String nombre = txtNombre.getText().trim();
                String apellidos = txtApellidos.getText().trim();
                EquipoMaratonProgramacion.validarCampo(nombre);     // Valida el nombre
                EquipoMaratonProgramacion.validarCampo(apellidos);  // Valida los apellidos
                equipo.anadir(new Programador(nombre, apellidos));
                salida.setText("Integrante añadido.\n\n" + equipo.obtenerDatos());
                txtNombre.setText("");
                txtApellidos.setText("");
            } catch (Exception ex) {
                salida.setText("Exception: " + ex.getMessage() + "\n\n" + equipo.obtenerDatos());
            }
        });

        return armar(formulario, new JButton[]{btnCrear, btnAnadir}, salida);
    }

    // ---------- Pestaña 2: contraseña ----------
    private JPanel crearPanelContrasena() {
        JPasswordField txtClave = new JPasswordField();
        JPasswordField txtConfirmacion = new JPasswordField();
        JTextArea salida = nuevaSalida();
        salida.setText("Requisitos de la contraseña:\n"
                + "- Mínimo 8 caracteres\n"
                + "- Sin espacios en blanco\n"
                + "- Al menos una letra minúscula, una mayúscula,\n  un número y un carácter especial\n"
                + "- Debe ingresarse dos veces (confirmación)");

        JPanel formulario = new JPanel(new GridLayout(2, 2, 8, 6));
        formulario.add(new JLabel("Contraseña:"));
        formulario.add(txtClave);
        formulario.add(new JLabel("Confirmar contraseña:"));
        formulario.add(txtConfirmacion);

        JButton btnValidar = new JButton("Validar contraseña");
        btnValidar.addActionListener(e -> {
            try {
                ValidadorContrasena.validar(new String(txtClave.getPassword()),
                        new String(txtConfirmacion.getPassword()));
                salida.setText("La contraseña es válida.");
            } catch (ContrasenaInvalidaException ex) {
                salida.setText("ContrasenaInvalidaException: " + ex.getMessage());
            }
        });

        return armar(formulario, new JButton[]{btnValidar}, salida);
    }

    // ---------- Utilidades ----------
    private JTextArea nuevaSalida() {
        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        return area;
    }

    private JPanel armar(JPanel formulario, JButton[] botones, JTextArea salida) {
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
        SwingUtilities.invokeLater(() -> new VentanaMaraton().setVisible(true));
    }
}

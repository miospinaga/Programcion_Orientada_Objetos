package Notas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Ventana principal: solicita cinco notas y muestra promedio,
 * desviación estándar, mayor y menor.
 */
public class VentanaPrincipal extends JFrame implements ActionListener {

    private Container contenedor;
    private JLabel nota1, nota2, nota3, nota4, nota5;
    private JLabel promedio, desviacion, mayor, menor;
    private JTextField campoNota1, campoNota2, campoNota3, campoNota4, campoNota5;
    private JButton calcular, limpiar;

    public VentanaPrincipal() {
        setTitle("Notas");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }

    public void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        nota1 = new JLabel("Nota 1:");
        nota2 = new JLabel("Nota 2:");
        nota3 = new JLabel("Nota 3:");
        nota4 = new JLabel("Nota 4:");
        nota5 = new JLabel("Nota 5:");
        nota1.setBounds(20, 20, 60, 25);
        nota2.setBounds(20, 55, 60, 25);
        nota3.setBounds(20, 90, 60, 25);
        nota4.setBounds(20, 125, 60, 25);
        nota5.setBounds(20, 160, 60, 25);

        campoNota1 = new JTextField();
        campoNota2 = new JTextField();
        campoNota3 = new JTextField();
        campoNota4 = new JTextField();
        campoNota5 = new JTextField();
        campoNota1.setBounds(90, 20, 160, 25);
        campoNota2.setBounds(90, 55, 160, 25);
        campoNota3.setBounds(90, 90, 160, 25);
        campoNota4.setBounds(90, 125, 160, 25);
        campoNota5.setBounds(90, 160, 160, 25);

        calcular = new JButton("Calcular");
        limpiar = new JButton("Limpiar");
        calcular.setBounds(20, 200, 110, 25);
        limpiar.setBounds(140, 200, 110, 25);
        calcular.addActionListener(this);
        limpiar.addActionListener(this);

        promedio = new JLabel("Promedio = ");
        desviacion = new JLabel("Desviación estándar = ");
        mayor = new JLabel("Valor mayor = ");
        menor = new JLabel("Valor menor = ");
        promedio.setBounds(20, 245, 240, 25);
        desviacion.setBounds(20, 280, 240, 25);
        mayor.setBounds(20, 315, 240, 25);
        menor.setBounds(20, 350, 240, 25);

        contenedor.add(nota1);
        contenedor.add(nota2);
        contenedor.add(nota3);
        contenedor.add(nota4);
        contenedor.add(nota5);
        contenedor.add(campoNota1);
        contenedor.add(campoNota2);
        contenedor.add(campoNota3);
        contenedor.add(campoNota4);
        contenedor.add(campoNota5);
        contenedor.add(calcular);
        contenedor.add(limpiar);
        contenedor.add(promedio);
        contenedor.add(desviacion);
        contenedor.add(mayor);
        contenedor.add(menor);

        setSize(300, 420);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) {
            calcularResultados();
        } else if (evento.getSource() == limpiar) {
            limpiarCampos();
        }
    }

    private void calcularResultados() {
        JTextField[] campos = {campoNota1, campoNota2, campoNota3, campoNota4, campoNota5};
        double[] valores = new double[5];

        for (int i = 0; i < campos.length; i++) {
            String texto = campos[i].getText().trim();

            // Parte propuesta 2: todas las notas son obligatorias
            if (texto.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Debe ingresar la nota " + (i + 1) + ". Las cinco notas son obligatorias.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                campos[i].requestFocus();
                return;
            }

            // Parte propuesta 1: solo se aceptan datos numéricos
            try {
                valores[i] = Double.parseDouble(texto.replace(',', '.'));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "La nota " + (i + 1) + " no es un número válido.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                campos[i].requestFocus();
                return;
            }
        }

        Notas misNotas = new Notas(valores);
        promedio.setText(String.format("Promedio = %.2f", misNotas.calcularPromedio()));
        desviacion.setText(String.format("Desviación estándar = %.2f", misNotas.calcularDesviacion()));
        mayor.setText(String.format("Valor mayor = %.1f", misNotas.calcularMayor()));
        menor.setText(String.format("Valor menor = %.1f", misNotas.calcularMenor()));
    }

    private void limpiarCampos() {
        campoNota1.setText("");
        campoNota2.setText("");
        campoNota3.setText("");
        campoNota4.setText("");
        campoNota5.setText("");
        promedio.setText("Promedio = ");
        desviacion.setText("Desviación estándar = ");
        mayor.setText("Valor mayor = ");
        menor.setText("Valor menor = ");
        campoNota1.requestFocus();
    }
}

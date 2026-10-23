package Figuras;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Ventana principal: un botón por cada figura geométrica.
 */
public class VentanaPrincipal extends JFrame implements ActionListener {

    private Container contenedor;
    private JButton cilindro, esfera, piramide, cubo, prisma;

    public VentanaPrincipal() {
        setTitle("Figuras");
        setSize(340, 160);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }

    public void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        cilindro = new JButton("Cilindro");
        esfera = new JButton("Esfera");
        piramide = new JButton("Pir\u00e1mide");
        cubo = new JButton("Cubo");
        prisma = new JButton("Prisma");

        cilindro.setBounds(15, 20, 95, 28);
        esfera.setBounds(120, 20, 95, 28);
        piramide.setBounds(225, 20, 95, 28);
        cubo.setBounds(15, 60, 95, 28);
        prisma.setBounds(120, 60, 95, 28);

        cilindro.addActionListener(this);
        esfera.addActionListener(this);
        piramide.addActionListener(this);
        cubo.addActionListener(this);
        prisma.addActionListener(this);

        contenedor.add(cilindro);
        contenedor.add(esfera);
        contenedor.add(piramide);
        contenedor.add(cubo);
        contenedor.add(prisma);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == cilindro) {
            new VentanaCilindro().inicio();
        } else if (evento.getSource() == esfera) {
            new VentanaEsfera().inicio();
        } else if (evento.getSource() == piramide) {
            new VentanaPiramide().inicio();
        } else if (evento.getSource() == cubo) {
            new VentanaCubo().inicio();
        } else if (evento.getSource() == prisma) {
            new VentanaPrisma().inicio();
        }
    }
}

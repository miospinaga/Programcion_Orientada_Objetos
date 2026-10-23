package Figuras;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaPrisma extends JFrame implements ActionListener {

    private Container contenedor;
    private JLabel largo, ancho, altura, volumen, superficie;
    private JTextField campoLargo, campoAncho, campoAltura;
    private JButton calcular;
    private PanelDibujo dibujo;

    public VentanaPrisma() {
        setTitle("Prisma");
        setSize(400, 285);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    public void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        largo = new JLabel("Largo (cm):");
        largo.setBounds(20, 20, 100, 25);
        campoLargo = new JTextField();
        campoLargo.setBounds(125, 20, 120, 25);
        ancho = new JLabel("Ancho (cm):");
        ancho.setBounds(20, 55, 100, 25);
        campoAncho = new JTextField();
        campoAncho.setBounds(125, 55, 120, 25);
        altura = new JLabel("Altura (cm):");
        altura.setBounds(20, 90, 100, 25);
        campoAltura = new JTextField();
        campoAltura.setBounds(125, 90, 120, 25);

        calcular = new JButton("Calcular");
        calcular.setBounds(20, 125, 225, 25);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm\u00b3): ");
        volumen.setBounds(20, 170, 240, 25);
        superficie = new JLabel("Superficie (cm\u00b2): ");
        superficie.setBounds(20, 205, 240, 25);

        dibujo = new PanelDibujo("prisma");
        dibujo.setBounds(270, 20, 110, 130);

        contenedor.add(largo);
        contenedor.add(campoLargo);
        contenedor.add(ancho);
        contenedor.add(campoAncho);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
        contenedor.add(dibujo);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() != calcular) {
            return;
        }

        Double largoValor = Util.leerPositivo(this, campoLargo, "Largo");
        if (largoValor == null) {
            return;
        }
        Double anchoValor = Util.leerPositivo(this, campoAncho, "Ancho");
        if (anchoValor == null) {
            return;
        }
        Double alturaValor = Util.leerPositivo(this, campoAltura, "Altura");
        if (alturaValor == null) {
            return;
        }

        Prisma figura = new Prisma(largoValor, anchoValor, alturaValor);
        volumen.setText(String.format("Volumen (cm\u00b3): %.2f", figura.calcularVolumen()));
        superficie.setText(String.format("Superficie (cm\u00b2): %.2f", figura.calcularSuperficie()));
    }
}

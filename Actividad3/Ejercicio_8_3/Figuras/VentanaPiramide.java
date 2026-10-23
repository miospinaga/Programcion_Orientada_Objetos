package Figuras;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaPiramide extends JFrame implements ActionListener {

    private Container contenedor;
    private JLabel base, altura, apotema, volumen, superficie;
    private JTextField campoBase, campoAltura, campoApotema;
    private JButton calcular;
    private PanelDibujo dibujo;

    public VentanaPiramide() {
        setTitle("Pir\u00e1mide");
        setSize(400, 285);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    public void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        base = new JLabel("Base (cm):");
        base.setBounds(20, 20, 100, 25);
        campoBase = new JTextField();
        campoBase.setBounds(125, 20, 120, 25);
        altura = new JLabel("Altura (cm):");
        altura.setBounds(20, 55, 100, 25);
        campoAltura = new JTextField();
        campoAltura.setBounds(125, 55, 120, 25);
        apotema = new JLabel("Apotema (cm):");
        apotema.setBounds(20, 90, 100, 25);
        campoApotema = new JTextField();
        campoApotema.setBounds(125, 90, 120, 25);

        calcular = new JButton("Calcular");
        calcular.setBounds(20, 125, 225, 25);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm\u00b3): ");
        volumen.setBounds(20, 170, 240, 25);
        superficie = new JLabel("Superficie (cm\u00b2): ");
        superficie.setBounds(20, 205, 240, 25);

        dibujo = new PanelDibujo("piramide");
        dibujo.setBounds(270, 20, 110, 130);

        contenedor.add(base);
        contenedor.add(campoBase);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(apotema);
        contenedor.add(campoApotema);
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

        Double baseValor = Util.leerPositivo(this, campoBase, "Base");
        if (baseValor == null) {
            return;
        }
        Double alturaValor = Util.leerPositivo(this, campoAltura, "Altura");
        if (alturaValor == null) {
            return;
        }
        Double apotemaValor = Util.leerPositivo(this, campoApotema, "Apotema");
        if (apotemaValor == null) {
            return;
        }

        Piramide figura = new Piramide(baseValor, alturaValor, apotemaValor);
        volumen.setText(String.format("Volumen (cm\u00b3): %.2f", figura.calcularVolumen()));
        superficie.setText(String.format("Superficie (cm\u00b2): %.2f", figura.calcularSuperficie()));
    }
}

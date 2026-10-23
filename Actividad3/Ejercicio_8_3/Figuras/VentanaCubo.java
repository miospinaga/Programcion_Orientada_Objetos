package Figuras;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaCubo extends JFrame implements ActionListener {

    private Container contenedor;
    private JLabel lado, volumen, superficie;
    private JTextField campoLado;
    private JButton calcular;
    private PanelDibujo dibujo;

    public VentanaCubo() {
        setTitle("Cubo");
        setSize(400, 215);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    public void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        lado = new JLabel("Lado (cm):");
        lado.setBounds(20, 20, 100, 25);
        campoLado = new JTextField();
        campoLado.setBounds(125, 20, 120, 25);

        calcular = new JButton("Calcular");
        calcular.setBounds(20, 55, 225, 25);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm\u00b3): ");
        volumen.setBounds(20, 100, 240, 25);
        superficie = new JLabel("Superficie (cm\u00b2): ");
        superficie.setBounds(20, 135, 240, 25);

        dibujo = new PanelDibujo("cubo");
        dibujo.setBounds(270, 20, 110, 130);

        contenedor.add(lado);
        contenedor.add(campoLado);
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

        Double ladoValor = Util.leerPositivo(this, campoLado, "Lado");
        if (ladoValor == null) {
            return;
        }

        Cubo figura = new Cubo(ladoValor);
        volumen.setText(String.format("Volumen (cm\u00b3): %.2f", figura.calcularVolumen()));
        superficie.setText(String.format("Superficie (cm\u00b2): %.2f", figura.calcularSuperficie()));
    }
}

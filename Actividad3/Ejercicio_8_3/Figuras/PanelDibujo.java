package Figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 * Panel que dibuja la imagen de cada figura geométrica (parte propuesta 2).
 */
public class PanelDibujo extends JPanel {

    private String tipo;
    private static final Color RELLENO = new Color(190, 215, 240);
    private static final Color RELLENO_CLARO = new Color(220, 235, 250);
    private static final Color RELLENO_OSCURO = new Color(150, 185, 220);

    public PanelDibujo(String tipo) {
        this.tipo = tipo;
        setPreferredSize(new Dimension(110, 130));
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(1.6f));

        switch (tipo) {
            case "cilindro": dibujarCilindro(g2); break;
            case "esfera": dibujarEsfera(g2); break;
            case "piramide": dibujarPiramide(g2); break;
            case "cubo": dibujarCajaPerspectiva(g2, 60, 60, 25); break;
            case "prisma": dibujarCajaPerspectiva(g2, 75, 42, 25); break;
            default: break;
        }
    }

    private void dibujarCilindro(Graphics2D g2) {
        g2.setColor(RELLENO);
        g2.fillRect(20, 32, 70, 68);
        g2.fillOval(20, 88, 70, 24);
        g2.setColor(Color.BLACK);
        g2.drawLine(20, 32, 20, 100);
        g2.drawLine(90, 32, 90, 100);
        g2.drawArc(20, 88, 70, 24, 180, 180);
        g2.setColor(RELLENO_CLARO);
        g2.fillOval(20, 20, 70, 24);
        g2.setColor(Color.BLACK);
        g2.drawOval(20, 20, 70, 24);
    }

    private void dibujarEsfera(Graphics2D g2) {
        g2.setColor(RELLENO);
        g2.fillOval(15, 25, 80, 80);
        g2.setColor(Color.BLACK);
        g2.drawOval(15, 25, 80, 80);
        g2.drawArc(15, 55, 80, 20, 180, 180);
        g2.setStroke(new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,
                10f, new float[]{4f, 4f}, 0f));
        g2.drawArc(15, 55, 80, 20, 0, 180);
    }

    private void dibujarPiramide(Graphics2D g2) {
        int[] fx = {55, 15, 80};
        int[] fy = {20, 100, 100};
        int[] dx = {55, 80, 105};
        int[] dy = {20, 100, 80};
        g2.setColor(RELLENO);
        g2.fillPolygon(fx, fy, 3);
        g2.setColor(RELLENO_OSCURO);
        g2.fillPolygon(dx, dy, 3);
        g2.setColor(Color.BLACK);
        g2.drawPolygon(fx, fy, 3);
        g2.drawPolygon(dx, dy, 3);
        g2.setStroke(new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,
                10f, new float[]{4f, 4f}, 0f));
        g2.drawLine(15, 100, 40, 80);
        g2.drawLine(40, 80, 105, 80);
        g2.drawLine(40, 80, 55, 20);
    }

    /** Caja en perspectiva: sirve para el cubo y el prisma rectangular. */
    private void dibujarCajaPerspectiva(Graphics2D g2, int ancho, int alto, int prof) {
        int x = 10;
        int y = 130 - 20 - alto;
        int[] topX = {x, x + prof, x + prof + ancho, x + ancho};
        int[] topY = {y, y - prof, y - prof, y};
        int[] derX = {x + ancho, x + ancho + prof, x + ancho + prof, x + ancho};
        int[] derY = {y, y - prof, y - prof + alto, y + alto};
        g2.setColor(RELLENO);
        g2.fillRect(x, y, ancho, alto);
        g2.setColor(RELLENO_CLARO);
        g2.fillPolygon(topX, topY, 4);
        g2.setColor(RELLENO_OSCURO);
        g2.fillPolygon(derX, derY, 4);
        g2.setColor(Color.BLACK);
        g2.drawRect(x, y, ancho, alto);
        g2.drawPolygon(topX, topY, 4);
        g2.drawPolygon(derX, derY, 4);
    }
}

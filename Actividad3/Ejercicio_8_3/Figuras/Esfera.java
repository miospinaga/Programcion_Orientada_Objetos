package Figuras;

public class Esfera extends FiguraGeometrica {

    private double radio;

    public Esfera(double radio) {
        this.radio = radio;
    }

    public double calcularVolumen() {
        setVolumen(4.0 / 3.0 * Math.PI * Math.pow(radio, 3));
        return getVolumen();
    }

    public double calcularSuperficie() {
        setSuperficie(4 * Math.PI * Math.pow(radio, 2));
        return getSuperficie();
    }
}

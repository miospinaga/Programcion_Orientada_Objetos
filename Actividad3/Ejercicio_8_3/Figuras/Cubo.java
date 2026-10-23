package Figuras;

public class Cubo extends FiguraGeometrica {

    private double lado;

    public Cubo(double lado) {
        this.lado = lado;
    }

    public double calcularVolumen() {
        setVolumen(Math.pow(lado, 3));
        return getVolumen();
    }

    public double calcularSuperficie() {
        setSuperficie(6 * Math.pow(lado, 2));
        return getSuperficie();
    }
}

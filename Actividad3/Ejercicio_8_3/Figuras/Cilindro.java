package Figuras;

public class Cilindro extends FiguraGeometrica {

    private double radio;
    private double altura;

    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
    }

    public double calcularVolumen() {
        setVolumen(Math.PI * Math.pow(radio, 2) * altura);
        return getVolumen();
    }

    public double calcularSuperficie() {
        setSuperficie(2 * Math.PI * radio * (radio + altura));
        return getSuperficie();
    }
}

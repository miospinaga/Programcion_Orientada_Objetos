package Figuras;

/**
 * Prisma rectangular (largo, ancho y altura).
 */
public class Prisma extends FiguraGeometrica {

    private double largo;
    private double ancho;
    private double altura;

    public Prisma(double largo, double ancho, double altura) {
        this.largo = largo;
        this.ancho = ancho;
        this.altura = altura;
    }

    public double calcularVolumen() {
        setVolumen(largo * ancho * altura);
        return getVolumen();
    }

    public double calcularSuperficie() {
        setSuperficie(2 * (largo * ancho + largo * altura + ancho * altura));
        return getSuperficie();
    }
}

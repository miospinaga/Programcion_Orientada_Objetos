package Figuras;

/**
 * Pirámide de base cuadrada.
 */
public class Piramide extends FiguraGeometrica {

    public double base;
    public double altura;
    public double apotema;

    public Piramide(double base, double altura, double apotema) {
        this.base = base;
        this.altura = altura;
        this.apotema = apotema;
    }

    public double calcularVolumen() {
        setVolumen(Math.pow(base, 2) * altura / 3);
        return getVolumen();
    }

    public double calcularSuperficie() {
        // área de la base + 4 caras triangulares (base * apotema / 2 cada una)
        setSuperficie(Math.pow(base, 2) + 2 * base * apotema);
        return getSuperficie();
    }
}

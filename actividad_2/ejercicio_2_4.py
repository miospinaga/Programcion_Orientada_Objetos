import math


class Circulo:
    """Círculo definido por su radio en centímetros."""

    def __init__(self, radio):
        self.radio = radio

    def calcular_area(self):
        return math.pi * self.radio ** 2

    def calcular_perimetro(self):
        return 2 * math.pi * self.radio


class Rectangulo:
    """Rectángulo definido por su base y altura en centímetros."""

    def __init__(self, base, altura):
        self.base = base
        self.altura = altura

    def calcular_area(self):
        return self.base * self.altura

    def calcular_perimetro(self):
        return 2 * (self.base + self.altura)


class Cuadrado:
    """Cuadrado definido por la longitud de su lado en centímetros."""

    def __init__(self, lado):
        self.lado = lado

    def calcular_area(self):
        return self.lado ** 2

    def calcular_perimetro(self):
        return 4 * self.lado


class TrianguloRectangulo:
    """Triángulo rectángulo definido por su base y altura en centímetros."""

    def __init__(self, base, altura):
        self.base = base
        self.altura = altura

    def calcular_area(self):
        return self.base * self.altura / 2

    def calcular_hipotenusa(self):
        return math.sqrt(self.base ** 2 + self.altura ** 2)

    def calcular_perimetro(self):
        return self.base + self.altura + self.calcular_hipotenusa()

    def determinar_tipo_triangulo(self):
        """Devuelve 'equilátero', 'isósceles' o 'escaleno' según sus lados."""
        a, b, c = self.base, self.altura, self.calcular_hipotenusa()
        if math.isclose(a, b) and math.isclose(b, c):
            return "equilátero"
        if math.isclose(a, b) or math.isclose(a, c) or math.isclose(b, c):
            return "isósceles"
        return "escaleno"


# ---------- Ejercicios propuestos ----------
class Rombo:
    """Rombo definido por sus diagonales en centímetros."""

    def __init__(self, diagonal_mayor, diagonal_menor):
        self.diagonal_mayor = diagonal_mayor
        self.diagonal_menor = diagonal_menor

    def calcular_area(self):
        return self.diagonal_mayor * self.diagonal_menor / 2

    def calcular_perimetro(self):
        lado = math.sqrt((self.diagonal_mayor / 2) ** 2 + (self.diagonal_menor / 2) ** 2)
        return 4 * lado


class Trapecio:
    """Trapecio definido por sus bases, altura y lados no paralelos (cm)."""

    def __init__(self, base_mayor, base_menor, altura, lado1, lado2):
        self.base_mayor = base_mayor
        self.base_menor = base_menor
        self.altura = altura
        self.lado1 = lado1
        self.lado2 = lado2

    def calcular_area(self):
        return (self.base_mayor + self.base_menor) * self.altura / 2

    def calcular_perimetro(self):
        return self.base_mayor + self.base_menor + self.lado1 + self.lado2


class PruebaFiguras:
    """Clase de prueba: crea las figuras y prueba sus métodos."""

    @staticmethod
    def main():
        circulo = Circulo(2)
        print("El área del círculo es =", circulo.calcular_area())
        print("El perímetro del círculo es =", circulo.calcular_perimetro())
        print()

        rectangulo = Rectangulo(2, 1)
        print("El área del rectángulo es =", rectangulo.calcular_area())
        print("El perímetro del rectángulo es =", rectangulo.calcular_perimetro())
        print()

        cuadrado = Cuadrado(3)
        print("El área del cuadrado es =", cuadrado.calcular_area())
        print("El perímetro del cuadrado es =", cuadrado.calcular_perimetro())
        print()

        triangulo = TrianguloRectangulo(3, 5)
        print("El área del triángulo es =", triangulo.calcular_area())
        print("El perímetro del triángulo es =", triangulo.calcular_perimetro())
        print("Es un triángulo", triangulo.determinar_tipo_triangulo())
        print()

        # Ejercicios propuestos
        rombo = Rombo(6, 4)
        print("El área del rombo es =", rombo.calcular_area())
        print("El perímetro del rombo es =", rombo.calcular_perimetro())
        print()

        trapecio = Trapecio(6, 4, 3, 3.5, 3.5)
        print("El área del trapecio es =", trapecio.calcular_area())
        print("El perímetro del trapecio es =", trapecio.calcular_perimetro())


PruebaFiguras.main()

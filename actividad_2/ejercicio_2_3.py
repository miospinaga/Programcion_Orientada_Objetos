from enum import Enum


class TipoCom(Enum):
    """Tipo de combustible."""
    GASOLINA = 1
    BIOETANOL = 2
    DIESEL = 3
    BIODIESEL = 4
    GAS_NATURAL = 5


class TipoA(Enum):
    """Tipo de automóvil."""
    CIUDAD = 1
    SUBCOMPACTO = 2
    COMPACTO = 3
    FAMILIAR = 4
    EJECUTIVO = 5
    SUV = 6


class TipoColor(Enum):
    """Color del automóvil."""
    BLANCO = 1
    NEGRO = 2
    ROJO = 3
    NARANJA = 4
    AMARILLO = 5
    VERDE = 6
    AZUL = 7
    VIOLETA = 8


class Automovil:
    """Modela un automóvil con su estado (atributos) y su comportamiento."""

    VALOR_MULTA = 100000  # supuesto: valor de cada multa (el libro no lo define)

    def __init__(self, marca, modelo, motor, tipo_combustible, tipo_automovil,
                 numero_puertas, cantidad_asientos, velocidad_maxima, color,
                 es_automatico=False):
        self.marca = marca                      # str: fabricante
        self.modelo = modelo                    # int: año de fabricación
        self.motor = motor                      # int: litros del cilindraje
        self.tipo_combustible = tipo_combustible  # TipoCom
        self.tipo_automovil = tipo_automovil    # TipoA
        self.numero_puertas = numero_puertas    # int
        self.cantidad_asientos = cantidad_asientos  # int
        self.velocidad_maxima = velocidad_maxima    # int: km/h
        self.color = color                      # TipoColor
        self.velocidad_actual = 0               # int: km/h
        self.es_automatico = es_automatico      # bool (propuesto)
        self.cantidad_multas = 0                # int (propuesto)

    # ---------- Métodos get ----------
    def get_marca(self): return self.marca
    def get_modelo(self): return self.modelo
    def get_motor(self): return self.motor
    def get_tipo_combustible(self): return self.tipo_combustible
    def get_tipo_automovil(self): return self.tipo_automovil
    def get_numero_puertas(self): return self.numero_puertas
    def get_cantidad_asientos(self): return self.cantidad_asientos
    def get_velocidad_maxima(self): return self.velocidad_maxima
    def get_color(self): return self.color
    def get_velocidad_actual(self): return self.velocidad_actual
    def get_es_automatico(self): return self.es_automatico

    # ---------- Métodos set ----------
    def set_marca(self, marca): self.marca = marca
    def set_modelo(self, modelo): self.modelo = modelo
    def set_motor(self, motor): self.motor = motor
    def set_tipo_combustible(self, tipo): self.tipo_combustible = tipo
    def set_tipo_automovil(self, tipo): self.tipo_automovil = tipo
    def set_numero_puertas(self, n): self.numero_puertas = n
    def set_cantidad_asientos(self, n): self.cantidad_asientos = n
    def set_velocidad_maxima(self, v): self.velocidad_maxima = v
    def set_color(self, color): self.color = color
    def set_velocidad_actual(self, v): self.velocidad_actual = v
    def set_es_automatico(self, valor): self.es_automatico = valor

    # ---------- Comportamiento ----------
    def acelerar(self, incremento):
        """Aumenta la velocidad sin superar la máxima. Si lo intenta, genera multa."""
        if self.velocidad_actual + incremento > self.velocidad_maxima:
            print("No se puede acelerar más allá de la velocidad máxima.")
            self.cantidad_multas += 1
        else:
            self.velocidad_actual += incremento

    def desacelerar(self, decremento):
        """Reduce la velocidad sin permitir valores negativos."""
        if self.velocidad_actual - decremento < 0:
            print("No se puede decrementar a una velocidad negativa.")
        else:
            self.velocidad_actual -= decremento

    def frenar(self):
        """Coloca la velocidad actual en cero."""
        self.velocidad_actual = 0

    def calcular_tiempo_llegada(self, distancia):
        """Tiempo estimado (horas) = distancia (km) / velocidad actual (km/h)."""
        if self.velocidad_actual == 0:
            print("No se puede calcular el tiempo: el automóvil está detenido.")
            return None
        return distancia / self.velocidad_actual

    def tiene_multas(self):
        """Indica si el vehículo tiene multas (propuesto)."""
        return self.cantidad_multas > 0

    def calcular_total_multas(self):
        """Valor total de las multas del vehículo (propuesto)."""
        return self.cantidad_multas * self.VALOR_MULTA

    def imprimir(self):
        """Muestra en pantalla los valores de los atributos del automóvil."""
        print("Marca =", self.marca)
        print("Modelo =", self.modelo)
        print("Motor =", self.motor)
        print("Tipo de combustible =", self.tipo_combustible.name)
        print("Tipo de automóvil =", self.tipo_automovil.name)
        print("Número de puertas =", self.numero_puertas)
        print("Cantidad de asientos =", self.cantidad_asientos)
        print("Velocidad máxima =", self.velocidad_maxima)
        print("Color =", self.color.name)
        print("Es automático =", self.es_automatico)


def main():
    auto1 = Automovil("Ford", 2018, 3, TipoCom.DIESEL, TipoA.EJECUTIVO,
                      5, 6, 250, TipoColor.NEGRO)
    auto1.imprimir()

    auto1.set_velocidad_actual(100)
    print("Velocidad actual =", auto1.get_velocidad_actual())
    auto1.acelerar(20)
    print("Velocidad actual =", auto1.get_velocidad_actual())
    auto1.desacelerar(50)
    print("Velocidad actual =", auto1.get_velocidad_actual())
    auto1.frenar()
    print("Velocidad actual =", auto1.get_velocidad_actual())
    auto1.desacelerar(10)  # reproduce el mensaje de la Figura 2.9

    # Prueba de los ejercicios propuestos
    auto1.set_velocidad_actual(240)
    auto1.acelerar(50)     # supera 250 km/h -> multa
    print("¿Tiene multas?", auto1.tiene_multas())
    print("Total multas =", auto1.calcular_total_multas())


main()

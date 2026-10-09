from enum import Enum


class TipoPlaneta(Enum):
    """Tipos de planeta de acuerdo con su tamaño."""
    GASEOSO = 1
    TERRESTRE = 2
    ENANO = 3


class Planeta:
    """Modela un planeta del sistema solar."""

    UA_EN_KM = 149_597_870  # una unidad astronómica en kilómetros

    def __init__(self, nombre=None, cantidad_satelites=0, masa=0.0,
                 volumen=0.0, diametro=0, distancia_sol=0,
                 tipo=None, es_observable=False,
                 periodo_orbital=0.0, periodo_rotacion=0.0):
        """
        Constructor de la clase Planeta.
        :param nombre: nombre del planeta (str)
        :param cantidad_satelites: cantidad de satélites (int)
        :param masa: masa en kilogramos (float)
        :param volumen: volumen en kilómetros cúbicos (float)
        :param diametro: diámetro en kilómetros (int)
        :param distancia_sol: distancia media al Sol en millones de km (int)
        :param tipo: tipo de planeta (TipoPlaneta)
        :param es_observable: observable a simple vista (bool)
        :param periodo_orbital: periodo orbital en años (float)
        :param periodo_rotacion: periodo de rotación en días (float)
        """
        self.nombre = nombre
        self.cantidad_satelites = cantidad_satelites
        self.masa = masa
        self.volumen = volumen
        self.diametro = diametro
        self.distancia_sol = distancia_sol
        self.tipo = tipo
        self.es_observable = es_observable
        self.periodo_orbital = periodo_orbital
        self.periodo_rotacion = periodo_rotacion

    def imprimir(self):
        """Imprime en pantalla los valores de los atributos del planeta."""
        print("Nombre del planeta =", self.nombre)
        print("Cantidad de satélites =", self.cantidad_satelites)
        print("Masa del planeta =", self.masa)
        print("Volumen del planeta =", self.volumen)
        print("Diámetro del planeta =", self.diametro)
        print("Distancia al sol =", self.distancia_sol)
        print("Tipo de planeta =", self.tipo.name if self.tipo else None)
        print("Es observable =", self.es_observable)
        print("Periodo orbital (años) =", self.periodo_orbital)
        print("Periodo de rotación (días) =", self.periodo_rotacion)

    def calcular_densidad(self):
        """Devuelve la densidad: masa / volumen."""
        if self.volumen == 0:
            return 0.0
        return self.masa / self.volumen

    def es_planeta_exterior(self):
        """
        Un planeta es exterior si está más allá del cinturón de asteroides,
        que llega hasta 3.4 UA. Se compara en millones de kilómetros.
        """
        limite_millones_km = 3.4 * self.UA_EN_KM / 1_000_000
        return self.distancia_sol > limite_millones_km


def main():
    """Crea dos planetas y muestra sus atributos, densidad y si es exterior."""
    p1 = Planeta("Tierra", 1, 5.9736e24, 1.08321e12, 12742, 150,
                 TipoPlaneta.TERRESTRE, True, 1.0, 1.0)
    p2 = Planeta("Júpiter", 79, 1.899e27, 1.4313e15, 139820, 750,
                 TipoPlaneta.GASEOSO, True, 11.86, 0.41)

    for p in (p1, p2):
        p.imprimir()
        print(f"Densidad del planeta = {p.calcular_densidad():.6E}")
        print("Es planeta exterior =", p.es_planeta_exterior())
        print()


main()

class Persona:
    """
    Define objetos de tipo Persona con nombre, apellidos, número de
    documento de identidad, año de nacimiento, país de nacimiento y género.
    """

    def __init__(self, nombre, apellidos, numero_documento_identidad,
                 anio_nacimiento, pais_nacimiento, genero):
        """
        Constructor de la clase Persona.
        :param pais_nacimiento: país de nacimiento (str)
        :param genero: género de la persona, 'H' o 'M' (str de un solo carácter)
        """
        if genero not in ("H", "M"):
            raise ValueError("El género debe ser 'H' o 'M'")
        self.nombre = nombre
        self.apellidos = apellidos
        self.numero_documento_identidad = numero_documento_identidad
        self.anio_nacimiento = anio_nacimiento
        self.pais_nacimiento = pais_nacimiento
        self.genero = genero

    def imprimir(self):
        """Imprime en pantalla los datos de la persona."""
        print("Nombre =", self.nombre)
        print("Apellidos =", self.apellidos)
        print("Número de documento de identidad =", self.numero_documento_identidad)
        print("Año de nacimiento =", self.anio_nacimiento)
        print("País de nacimiento =", self.pais_nacimiento)
        print("Género =", self.genero)
        print()


def main():
    """Crea dos personas e imprime sus datos en pantalla."""
    p1 = Persona("Pedro", "Pérez", "1053121010", 1998, "Colombia", "H")
    p2 = Persona("Luis", "León", "1053223344", 2001, "Colombia", "H")
    p1.imprimir()
    p2.imprimir()


main()

from enum import Enum


class TipoCuenta(Enum):
    """Tipo de cuenta bancaria."""
    AHORROS = 1
    CORRIENTE = 2


class CuentaBancaria:
    """Modela una cuenta bancaria con operaciones básicas."""

    def __init__(self, nombres_titular, apellidos_titular, numero_cuenta,
                 tipo_cuenta, porcentaje_interes_mensual=0.0):
        self.nombres_titular = nombres_titular
        self.apellidos_titular = apellidos_titular
        self.numero_cuenta = numero_cuenta          # int
        self.saldo = 0.0                            # float, valor inicial 0
        self.tipo_cuenta = tipo_cuenta              # TipoCuenta
        self.porcentaje_interes_mensual = porcentaje_interes_mensual  # propuesto

    def imprimir(self):
        """Imprime los datos de la cuenta."""
        print("Nombres del titular =", self.nombres_titular)
        print("Apellidos del titular =", self.apellidos_titular)
        print("Número de cuenta =", self.numero_cuenta)
        print("Tipo de cuenta =", self.tipo_cuenta.name)
        self.consultar_saldo()
        print("Porcentaje de interés mensual =", self.porcentaje_interes_mensual)

    def consultar_saldo(self):
        """Muestra el saldo actual."""
        print("Saldo =", self.saldo)

    def consignar(self, valor):
        """Suma 'valor' al saldo. Devuelve True si la operación fue exitosa."""
        if valor <= 0:
            print("El valor a consignar debe ser mayor que cero.")
            return False
        self.saldo += valor
        print(f"Se ha consignado ${valor} en la cuenta. El nuevo saldo es ${self.saldo}")
        return True

    def retirar(self, valor):
        """Resta 'valor' del saldo si hay fondos. Devuelve True si fue exitoso."""
        if valor <= 0:
            print("El valor a retirar debe ser mayor que cero.")
            return False
        if valor > self.saldo:
            print("Saldo insuficiente para realizar el retiro.")
            return False
        self.saldo -= valor
        print(f"Se ha retirado ${valor} en la cuenta. El nuevo saldo es ${self.saldo}")
        return True

    def comparar_cuentas(self, cuenta):
        """Indica si dos cuentas son la misma (supuesto: mismo número de cuenta)."""
        if self.numero_cuenta == cuenta.numero_cuenta:
            print("Las cuentas son iguales.")
        else:
            print("Las cuentas son diferentes.")

    def transferencia(self, cuenta, valor):
        """Transfiere 'valor' de esta cuenta a la cuenta destino."""
        if valor <= 0 or valor > self.saldo:
            print("No se pudo realizar la transferencia: saldo insuficiente o valor inválido.")
            return
        self.saldo -= valor
        cuenta.saldo += valor
        print(f"Transferencia exitosa de ${valor} a la cuenta {cuenta.numero_cuenta}.")

    # ---------- Ejercicio propuesto ----------
    def calcular_nuevo_saldo(self):
        """Aplica el interés mensual al saldo, lo actualiza y lo devuelve."""
        self.saldo = self.saldo + self.saldo * self.porcentaje_interes_mensual / 100
        return self.saldo


def main():
    cuenta1 = CuentaBancaria("Pedro", "Pérez", 123456789, TipoCuenta.AHORROS)
    cuenta1.imprimir()
    cuenta1.consignar(200000)
    cuenta1.consignar(300000)
    cuenta1.retirar(400000)

    # Pruebas adicionales
    cuenta2 = CuentaBancaria("Luis", "León", 987654321, TipoCuenta.CORRIENTE)
    cuenta1.transferencia(cuenta2, 50000)
    cuenta1.comparar_cuentas(cuenta2)

    cuenta1.porcentaje_interes_mensual = 2
    nuevo = cuenta1.calcular_nuevo_saldo()
    print(f"Nuevo saldo con interés del 2% = ${nuevo}")


main()

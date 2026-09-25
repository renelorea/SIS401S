from Objeto.Calculadora import Calculadora

class CalculadoraBasica(Calculadora):

    def suma(self):
        return self.numero1 + self.numero2

    def resta(self):
        return self.numero1 - self.numero2

    def multiplicacion(self):
        return self.numero1 * self.numero2

    def division(self):
        return self.numero1 / self.numero2
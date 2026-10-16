class Personal:
    def __init__(self, nombre="", edad=0, color="", tamaño=0.0, peso=0.0):
        self.nombre = nombre
        self.edad = edad
        self.color = color
        self.tamaño = tamaño
        self.peso = peso

    # Getters y Setters
    def get_nombre(self):
        return self.nombre

    def set_nombre(self, nombre):
        self.nombre = nombre

    def get_edad(self):
        return self.edad

    def set_edad(self, edad):
        self.edad = edad

    def get_color(self):
        return self.color

    def set_color(self, color):
        self.color = color

    def get_tamaño(self):
        return self.tamaño

    def set_tamaño(self, tamaño):
        self.tamaño = tamaño

    def get_peso(self):
        return self.peso

    def set_peso(self, peso):
        self.peso = peso


# Programa principal
if __name__ == "__main__":
    p1 = Personal()
    p1.set_nombre("Ana")
    p1.set_edad(25)
    p1.set_color("Morena")
    p1.set_tamaño(1.65)
    p1.set_peso(60.5)

    print("Nombre:", p1.get_nombre())
    print("Edad:", p1.get_edad())
    print("Color:", p1.get_color())
    print("Tamaño:", p1.get_tamaño())
    print("Peso:", p1.get_peso())

class Persona:
    # Constructor equivalente en Python
    def __init__(self):
        self.nombre = ""
        self.edad = 0
        self.color = ""
        self.tamano = 0.0
        self.peso = 0.0

    # Getters y Setters
    def set_nombre(self, nombre):
        self.nombre = nombre
        
    def get_nombre(self):
        return self.nombre

    def set_edad(self, edad):
        self.edad = edad
        
    def get_edad(self):
        return self.edad

    def set_color(self, color):
        self.color = color
        
    def get_color(self):
        return self.color

    def set_tamano(self, tamano):
        self.tamano = tamano
        
    def get_tamano(self):
        return self.tamano

    def set_peso(self, peso):
        self.peso = peso
        
    def get_peso(self):
        return self.peso


# Equivalente al public static void main de Java
if __name__ == "__main__":
    # 1. Instanciar el objeto
    persona = Persona()

    # 2. Asignar los datos
    persona.set_nombre("Daniela")
    persona.set_edad(25)
    persona.set_color("Moreno")
    persona.set_tamano(1.55)
    persona.set_peso(62.0)

    # 3. Imprimir los datos en consola
    print(f"Nombre: {persona.get_nombre()}")
    print(f"Edad: {persona.get_edad()}")
    print(f"Color: {persona.get_color()}")
    print(f"Tamaño: {persona.get_tamano()}")
    print(f"Peso: {persona.get_peso()}")
class Persona:
    def __init__(self, nombre="", edad=0, color="", tamano=0.0, peso=0.0):
        self.nombre = nombre
        self.edad = edad
        self.color = color
        self.tamano = tamano
        self.peso = peso

persona = Persona("Daniela", 28, "Moreno", 1.54, 62.0)

print("Nombre:", persona.nombre)
print("Edad:", persona.edad)
print("Color:", persona.color)
print("Tamano:", persona.tamano)
print("Peso:", persona.peso)
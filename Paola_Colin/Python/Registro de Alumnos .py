class Persona:
    def __init__(self, nombre, edad, color, tamano, peso):
        self.nombre = nombre
        self.edad = edad
        self.color = color
        self.tamano = tamano
        self.peso = peso


lista_personas = []
total = 14

print("-----REGISTRO DE DATOS-----")

for i in range(1, total + 1):
    print(f"\nPersona número {i}:")
    
    nombre = input("Nombre: ")
    edad = int(input("Edad: "))
    color = input("Color: ")
    tamano = float(input("Tamaño (ej: 1.65): "))
    peso = float(input("Peso (ej: 60.5): "))
    
    lista_personas.append(Persona(nombre, edad, color, tamano, peso))


print("-----Lista COMPLETA de las personas-----")
print(f"{'Nombre':<15} {'Edad':<6} {'Color':<10} {'Tamaño':<10} {'Peso':<8}")
print("-" * 50)

for p in lista_personas:
    print(f"{p.nombre:<15} {p.edad:<6} {p.color:<10} {p.tamano:<10.2f} {p.peso:<8.2f}")
try:
    from persona import Persona
except Exception:

    class Persona:
        def __init__(self, nombre, edad, color_piel, peso, altura):
            self.nombre = nombre
            self.edad = edad
            self.color_piel = color_piel
            self.peso = peso
            self.altura = altura

        def __str__(self):
            return f"{self.nombre}, {self.edad} años, piel {self.color_piel}, {self.peso}kg, {self.altura}m"

def main():
    personas = []

    personas.append(Persona("Carlos Caballero", 19, "Moreno", 65, 1.75))
    personas.append(Persona("Carlos De La Luz", 21, "Claro", 70, 1.65))
    personas.append(Persona("Jorge Estrada", 30, "Claro", 80, 1.80))
    personas.append(Persona("Raul Millan", 22, "Claro", 55, 1.60))
    personas.append(Persona("Francisco Torres", 28, "Moreno", 75, 1.70))
    personas.append(Persona("Justin Nuñez", 27, "Moreno", 65, 1.68))
    personas.append(Persona("Jorge Bryan", 35, "Claro", 85, 1.85))
    personas.append(Persona("Montserrat Reyes", 24, "Claro", 58, 1.62))
    personas.append(Persona("Daniela Rojas", 32, "Moreno", 78, 1.78))
    personas.append(Persona("Paola Adilene", 26, "Moreno", 52, 1.58))
    personas.append(Persona("Yeshua Calderon", 29, "Claro", 72, 1.72))
    personas.append(Persona("Roberto Galvez", 23, "Claro", 62, 1.66))
    personas.append(Persona("Yael Reyes", 31, "Moreno", 88, 1.82))
    personas.append(Persona("Armando Lorea", 21, "Moreno", 57, 1.64))

    print("Lista de personas:")
    for persona in personas:
        print(persona)


if __name__ == "__main__":
    main()
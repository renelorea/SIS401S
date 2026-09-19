from persona import Persona

def main():
    personas = []

    personas.append(Persona("Carlos Caballero", 19, "Moreno", 65, 1.75))
    personas.append(Persona("Carlos De La Luz", 21, "Claro", 70, 1.65))
    personas.append(Persona("Pedro López", 30, "Negro", 80, 1.80))
    personas.append(Persona("Ana Martínez", 22, "Blanco", 55, 1.60))
    personas.append(Persona("Luis Rodríguez", 28, "Moreno", 75, 1.70))
    personas.append(Persona("Laura Hernández", 27, "Negro", 65, 1.68))
    personas.append(Persona("Carlos Silva", 35, "Blanco", 85, 1.85))
    personas.append(Persona("Sofía Ramírez", 24, "Moreno", 58, 1.62))
    personas.append(Persona("Jorge Morales", 32, "Negro", 78, 1.78))
    personas.append(Persona("Elena Castro", 26, "Blanco", 52, 1.58))
    personas.append(Persona("Diego Ortega", 29, "Moreno", 72, 1.72))
    personas.append(Persona("Valeria Vega", 23, "Negro", 62, 1.66))
    personas.append(Persona("Andrés Ríos", 31, "Blanco", 88, 1.82))
    personas.append(Persona("Camila Díaz", 21, "Moreno", 57, 1.64))

    print("Lista de personas:")
    for persona in personas:
        print(persona)


if __name__ == "__main__":
    main()
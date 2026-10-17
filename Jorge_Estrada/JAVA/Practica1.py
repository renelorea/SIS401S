class Persona:
    def __init__(self, nombre, edad, color, tamano, peso):
        self.nombre = nombre
        self.edad = edad
        self.color = color
        self.tamano = tamano
        self.peso = peso

    def __str__(self):
        return (f"Nombre: {self.nombre}\n"
                f"Edad: {self.edad}\n"
                f"Color: {self.color}\n"
                f"Tamaño: {self.tamano}\n"
                f"Peso: {self.peso}\n")


def registrar_persona(lista):
    print("\n--- Registrar Persona ---")
    nombre = input("Nombre: ")
    edad = int(input("Edad: "))
    color = input("Color: ")
    tamano = float(input("Tamaño: "))
    peso = float(input("Peso: "))
    persona = Persona(nombre, edad, color, tamano, peso)
    lista.append(persona)
    print("✅ Persona registrada correctamente.")


def listar_personas(lista):
    print("\n--- Lista de Personas ---")
    if not lista:
        print("No hay personas registradas.")
    else:
        for i, persona in enumerate(lista, start=1):
            print(f"\nPersona {i}:\n{persona}")


def buscar_persona(lista):
    nombre = input("\nIngrese el nombre a buscar: ")
    encontrados = [p for p in lista if p.nombre.lower() == nombre.lower()]
    if encontrados:
        print("\n--- Resultado de búsqueda ---")
        for persona in encontrados:
            print(persona)
    else:
        print("❌ No se encontró ninguna persona con ese nombre.")


def menu():
    personas = []
    while True:
        print("\n=== MENÚ PRINCIPAL ===")
        print("1. Registrar persona")
        print("2. Listar personas")
        print("3. Buscar persona")
        print("4. Salir")

        opcion = input("Seleccione una opción: ")

        if opcion == "1":
            registrar_persona(personas)
        elif opcion == "2":
            listar_personas(personas)
        elif opcion == "3":
            buscar_persona(personas)
        elif opcion == "4":
            print("👋 Saliendo del programa...")
            break
        else:
            print("⚠️ Opción no válida. Intente de nuevo.")


if __name__ == "__main__":
    menu()

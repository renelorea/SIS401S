# Programa para gestionar una lista de 6 compañeros

# Inicializamos la lista con 6 compañeros de ejemplo
companeros = [
    {"id": 1, "nombre": "Carlos", "edad": 19, "color_piel": "Moreno", "tamaño": "1.70m", "peso": "65kg"},
    {"id": 2, "nombre": "María", "edad": 22, "color_piel": "Blanca", "tamaño": "1.62m", "peso": "54kg"},
    {"id": 3, "nombre": "Luis", "edad": 28, "color_piel": "Moreno", "tamaño": "1.68m", "peso": "60kg"},
    {"id": 4, "nombre": "Diego", "edad": 23, "color_piel": "Morena", "tamaño": "1.58m", "peso": "52kg"},
    {"id": 5, "nombre": "Jorge", "edad": 30, "color_piel": "Blanco", "tamaño": "1.75m", "peso": "70kg"},
    {"id": 6, "nombre": "Sofía", "edad": 20, "color_piel": "Blanca", "tamaño": "1.68m", "peso": "60kg"},
]

def mostrar_companeros():
    print("\n--- LISTA DE 6 COMPAÑEROS ---")
    for c in companeros:
        print(f"[{c['id']}] {c['nombre']:<8} | Edad: {c['edad']} | Piel: {c['color_piel']:<8} | Tamaño: {c['tamaño']} | Peso: {c['peso']}")
    print("------------------------------\n")

def actualizar_companero():
    mostrar_companeros()
    try:
        id_seleccionado = int(input("Ingresa el número [ID] del compañero que deseas actualizar (1-6): "))
        
        # Buscar el compañero correspondiente en la lista
        companero = next((c for c in companeros if c["id"] == id_seleccionado), None)
        
        if companero:
            print(f"\nActualizando a: {companero['nombre']} (Presiona ENTER para dejar el dato actual sin cambios)")
            
            nuevo_nombre = input(f"Nombre [{companero['nombre']}]: ")
            nueva_edad = input(f"Edad [{companero['edad']}]: ")
            nuevo_color = input(f"Color de piel [{companero['color_piel']}]: ")
            nuevo_tamano = input(f"Tamaño [{companero['tamaño']}]: ")
            nuevo_peso = input(f"Peso [{companero['peso']}]: ")

            # Actualizar solo si el usuario escribió un valor nuevo
            if nuevo_nombre: companero['nombre'] = nuevo_nombre
            if nueva_edad: companero['edad'] = int(nueva_edad)
            if nuevo_color: companero['color_piel'] = nuevo_color
            if nuevo_tamano: companero['tamaño'] = nuevo_tamano
            if nuevo_peso: companero['peso'] = nuevo_peso
            
            print("\n¡Datos actualizados correctamente!")
        else:
            print("\nError: Número de ID no encontrado.")
    except ValueError:
        print("\nError: Por favor, ingresa un número válido.")

def iniciar_programa():
    while True:
        print("\n=== MENÚ PRINCIPAL ===")
        print("1. Ver lista de compañeros")
        print("2. Actualizar datos de un compañero")
        print("3. Salir")
        
        opcion = input("Elige una opción: ")
        
        if opcion == '1':
            mostrar_companeros()
        elif opcion == '2':
            actualizar_companero()
        elif opcion == '3':
            print("Saliendo del programa...")
            break
        else:
            print("Opción no válida. Intenta de nuevo.")

# Punto de entrada del programa
if __name__ == "__main__":
    iniciar_programa()
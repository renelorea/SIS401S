class Persona:
    def __init__(self):
        self.nombre = ""
        self.edad = 0
        self.color = ""
        self.tamano = 0.0
        self.peso = 0.0

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

if __name__ == "__main__":
    lista_alumnos = []
    total_alumnos = 14

    print("=== REGISTRO DE ALUMNOS ===")

    for i in range(1, total_alumnos + 1):
        print(f"\n--- Alumno {i} de {total_alumnos} ---")
        persona = Persona()
        
        persona.set_nombre(input("Nombre: "))
        persona.set_edad(int(input("Edad: ")))
        persona.set_color(input("Color: "))
        persona.set_tamano(float(input("Tamano (ej. 1.70): ")))
        persona.set_peso(float(input("Peso (ej. 65.5): ")))
        
        lista_alumnos.append(persona)

    print("\n=================================")
    print("       LISTA DE ALUMNOS         ")
    print("=================================")
    
    for i in range(len(lista_alumnos)):
        p = lista_alumnos[i]
        print(f"{i + 1}. {p.get_nombre()} | {p.get_edad()} anos | {p.get_color()} | {p.get_tamano()} m | {p.get_peso()} kg")
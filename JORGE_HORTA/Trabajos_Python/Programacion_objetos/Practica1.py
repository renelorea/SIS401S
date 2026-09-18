from Objeto.Persona import Persona
alumnos = []
for i in range(14):
    persona = Persona()
    print("Alumno", i + 1)
    persona.nombre = input("Nombre: ")
    persona.edad = int(input("Edad: "))
    persona.color = input("Color: ")
    persona.tamaño = float(input("Tamaño: "))
    persona.peso = float(input("Peso: "))
    alumnos.append(persona)
    print("\n=== AlUMNOS ====")
    for persona in alumnos: 
        print("Nombre:",persona.nombre)
        print("Edad:",persona.edad)
        print("Color:",persona.color)
        print("Tamaño:",persona.tamaño)
        print("Peso:",persona.peso)
        print("-------------------")
    
from Objeto.Persona import Persona
from Objeto.Direccion import Direccion
alumnos = []
for i in range(14):

    persona = Persona()
    direccion = Direccion()

    print("Alumno", i + 1,"====")
    print("Nombre: ") 
    persona.nombre = input()
    print("Edad: ")
    persona.edad = int(input())
    print("Test: ")
    persona.test = input()
    print("Estatura: ")
    persona.estatura = float(input())
    print("Peso: ")
    persona.peso = float(input())

    print("----DIRECCION----")

    print("Calle: ")
    direccion.calle = input()
    print("Numero: ")
    direccion.numero = int(input())
    print("Colonia: ")
    direccion.colonia = input()
    print("Codigopostal: ")
    direccion.codigopostal = int(input())
    print("Estado: ")
    direccion.estado = input()
    print("Pais: ")
    direccion.pais = input()
    persona.direccion = direccion
    alumnos.append(persona)
    print()

    print("====ALUMNOS====")

for persona in alumnos:

    print("Nombre: ",persona.nombre)
    print("Edad: ",persona.edad)
    print("Test: ",persona.test)
    print("Estatura: ",persona.estatura)
    print("Peso: ",persona.peso)
    
    print("====DIRECCION====")
    print("Calle: ",persona.direccion.calle)
    print("Numero: ",persona.direccion.numero)
    print("Colonia: ",persona.direccion.colonia)
    print("Codigopostal: ",persona.direccion.codigopostal)
    print("Estado: ",persona.direccion.estado)
    print("Pais: ",persona.direccion.pais)
    print("==========")

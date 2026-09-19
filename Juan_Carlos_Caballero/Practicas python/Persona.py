class Persona:
    def __init__(self, nombre, edad, color, peso, estatura):
        self.nombre = nombre
        self.edad = edad
        self.color = color
        self.peso = peso
        self.estatura = estatura
    
    def get_nombre(self):
        return self.nombre
    
    def set_nombre(self, nombre):
        self.nombre = nombre
    
    def get_edad(self):
        return self.edad
    
    def set_edad(self, edad):
        self.edad = edad
    
    def get_color(self):
        return self.color
    
    def set_color(self, color):
        self.color = color
    
    def get_peso(self):
        return self.peso
    
    def set_peso(self, peso):
        self.peso = peso
    
    def get_estatura(self):
        return self.estatura
    
    def set_estatura(self, estatura):
        self.estatura = estatura
    
    def __str__(self):
        return f"Persona{{nombre='{self.nombre}', edad={self.edad}, color='{self.color}', peso={self.peso}, estatura={self.estatura}}}"

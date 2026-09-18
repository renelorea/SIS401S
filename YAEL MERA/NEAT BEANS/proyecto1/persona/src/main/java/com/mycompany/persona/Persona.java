package com.mycompany.persona;

public class Persona {
    
    // Atributos
    private String nombre;
    private int edad;
    private String color;
    private double tamano;
    private double peso;
    
    // Constructor vacío
    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.color = "";
        this.tamano = 0.0;
        this.peso = 0.0;
    }
    
    // Métodos set y get
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setTamano(double tamano) {
        this.tamano = tamano;
    }
    
    public double getTamano() {
        return tamano;
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public double getPeso() {
        return peso;
    }
    
    // Método principal para probar la clase
    public static void main(String[] args) {
        
        Persona persona = new Persona();
        
        persona.setNombre("Daniela");
        persona.setEdad(25);
        persona.setColor("Moreno");
        persona.setTamano(1.55);
        persona.setPeso(62.0);
        
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Edad: " + persona.getEdad());
        System.out.println("Color: " + persona.getColor());
        System.out.println("Tamaño: " + persona.getTamano());
        System.out.println("Peso: " + persona.getPeso());
    }
}


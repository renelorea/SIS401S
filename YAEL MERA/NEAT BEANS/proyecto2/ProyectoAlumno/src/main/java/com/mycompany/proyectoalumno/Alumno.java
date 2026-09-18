package com.mycompany.proyectoalumnos;

public class Alumno {
    private String nombre;
    private int edad;
    private String color;
    private double tamano;
    private double peso;

    public Alumno(String nombre, int edad, String color, double tamano, double peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.color = color;
        this.tamano = tamano;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return nombre + " | " + edad + " años | " + color + " | " + tamano + " m | " + peso + " kg";
    }
}

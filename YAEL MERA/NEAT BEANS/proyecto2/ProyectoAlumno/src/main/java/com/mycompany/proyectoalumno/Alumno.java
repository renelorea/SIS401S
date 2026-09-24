package com.mycompany.proyectoalumno;

public class Alumno {
    private String nombre;
    private int edad;
    private String color;
    private double tamano;
    private double peso;
    Direecion direecion;

    public Alumno(String nombre, int edad, String color, double tamano, double peso,Direecion direecion) {
        this.nombre = nombre;
        this.edad = edad;
        this.color = color;
        this.tamano = tamano;
        this.peso = peso;
        this.direecion=direecion;
    }

    public Direecion getDireecion() {
        return direecion;
    }

    public void setDireecion(Direecion direecion) {
        this.direecion = direecion;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getTamano() {
        return tamano;
    }

    public void setTamano(double tamano) {
        this.tamano = tamano;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    

    @Override
    public String toString() {
        return nombre + " | " + edad + " años | " + color + " | " + tamano + " m | " + peso + " kg";
    }
}

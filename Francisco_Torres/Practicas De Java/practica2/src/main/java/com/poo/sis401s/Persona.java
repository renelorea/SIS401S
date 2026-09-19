package com.poo.sis401s;

public class Persona {
    private String nombre;
    private int edad;
    private String color;
    private int peso;
    private double estatura;

    public Persona(String nombre, int edad, String color, int peso, double estatura) {
        this.nombre = nombre;
        this.edad = edad;
        this.color = color;
        this.peso = peso;
        this.estatura = estatura;
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

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    @Override
    public String toString() {
        return nombre + " | Edad: " + edad + " | Color: " + color +
               " | Peso: " + peso + "kg | Estatura: " + estatura + "m";
    }
}
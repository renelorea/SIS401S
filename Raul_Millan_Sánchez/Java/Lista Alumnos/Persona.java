package com.paralauniversidad.persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Persona {

    private String nombre;
    private int edad;
    private String colorPiel;
    private double peso;
    private double altura;
    private Direccion direccion;

    public Persona(String nombre, int edad, String colorPiel, double peso, double altura, Direccion direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.colorPiel = colorPiel;
        this.peso = peso;
        this.altura = altura;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Alumno: " + this.nombre + ", " + this.edad + " años, piel " + this.colorPiel + 
               ", " + this.peso + "kg, " + this.altura + "m\n" +
               "Direccion: " + this.direccion.toString();
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();
        
        int totalAlumnos = 14; 

        System.out.println("--- REGISTRO DE ALUMNOS ---");

        for (int i = 0; i < totalAlumnos; i++) {
            System.out.println("\n---> Ingresa los datos del alumno " + (i + 1) + " <---");
            
            System.out.print("Nombre: ");
            String nombre = teclado.nextLine();
            
            System.out.print("Edad: ");
            int edad = teclado.nextInt();
            teclado.nextLine();
            
            System.out.print("Color de piel: ");
            String colorPiel = teclado.nextLine();
            
            System.out.print("Peso (kg): ");
            double peso = teclado.nextDouble();
            
            System.out.print("Altura (M): ");
            double altura = teclado.nextDouble();
            teclado.nextLine();
            
            System.out.println("- Direccin del alumno -");
            System.out.print("Calle: ");
            String calle = teclado.nextLine();
            
            System.out.print("Numero (ej. 123 o S/N): ");
            String numero = teclado.nextLine();
            
            System.out.print("Colonia: ");
            String colonia = teclado.nextLine();
            
            System.out.print("Codigo Postal: ");
            String codigoPostal = teclado.nextLine();
            
            System.out.print("Estado: ");
            String estado = teclado.nextLine();
            
            System.out.print("Pais: ");
            String pais = teclado.nextLine();

            Direccion nuevaDireccion = new Direccion(calle, numero, colonia, codigoPostal, estado, pais);
            Persona nuevaPersona = new Persona(nombre, edad, colorPiel, peso, altura, nuevaDireccion);
            
            personas.add(nuevaPersona);
        }

        System.out.println("\n=======================================");
        System.out.println("      LISTA COMPLETA DE ALUMNOS        ");
        System.out.println("=======================================");
        for (Persona persona : personas) {
            System.out.println(persona.toString());
            System.out.println("---------------------------------------");
        }

        teclado.close();
    }
}
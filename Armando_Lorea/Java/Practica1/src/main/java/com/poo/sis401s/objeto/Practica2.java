/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poo.sis401s.objeto;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author arman
 */
public class Practica2 {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Persona> listaAlumnos = new ArrayList<>();
        int totalAlumnos = 14;

        System.out.println("Registro de alumnos");

        for (int i = 1; i <= totalAlumnos; i++) {
            System.out.println("Alumno " + i + " de " + totalAlumnos + " ---");
            Persona persona = new Persona();

            System.out.print("Nombre: ");
            persona.setNombre(scanner.nextLine());

            System.out.print("Edad: ");
            persona.setEdad(scanner.nextInt());
            scanner.nextLine(); 

            System.out.print("Color: ");
            persona.setColor(scanner.nextLine());

            System.out.print("Tamano: ");
            persona.setTamano(scanner.nextDouble());

            System.out.print("Peso: ");
            persona.setPeso(scanner.nextDouble());
            scanner.nextLine(); 

            listaAlumnos.add(persona);
        }

        System.out.println("LISTA DE ALUMNOS");
        for (int i = 0; i < listaAlumnos.size(); i++) {
            Persona p = listaAlumnos.get(i);
            System.out.println((i + 1) + ". " + p.getNombre() + " | " 
                    + p.getEdad() + " anos | " 
                    + p.getColor() + " | " 
                    + p.getTamano() + " m | " 
                    + p.getPeso() + " kg");
        }

        scanner.close();
    }
}
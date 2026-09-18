package com.mycompany.proyectoalumnos;

import java.util.ArrayList;
import java.util.Scanner;

public class PROYECTOALUMNOS {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        int totalAlumnos = 14;

        System.out.println("=== REGISTRO DE ALUMNOS ===");

        for (int i = 1; i <= totalAlumnos; i++) {
            System.out.println("\n--- Alumno " + i + " de " + totalAlumnos + " ---");
            System.out.print("Nombre: ");
            String nombre = teclado.nextLine();
            System.out.print("Edad: ");
            int edad = Integer.parseInt(teclado.nextLine());
            System.out.print("Color: ");
            String color = teclado.nextLine();
            System.out.print("Tamaño (ej. 1.70): ");
            double tamano = Double.parseDouble(teclado.nextLine());
            System.out.print("Peso (ej. 65.5): ");
            double peso = Double.parseDouble(teclado.nextLine());

            Alumno alumno = new Alumno(nombre, edad, color, tamano, peso);
            listaAlumnos.add(alumno);
        }

        System.out.println("\n=================================");
        System.out.println("       LISTA DE ALUMNOS         ");
        System.out.println("=================================");

        for (int i = 0; i < listaAlumnos.size(); i++) {
            System.out.println((i + 1) + ". " + listaAlumnos.get(i));
        }
    }
}

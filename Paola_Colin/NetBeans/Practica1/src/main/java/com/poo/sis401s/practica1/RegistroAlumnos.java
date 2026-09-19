/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poo.sis401s.practica1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pao
 */
public class RegistroAlumnos {
public static void main(String[] args){
    Scanner scanner = new Scanner (System.in);
    ArrayList<Persona> alumnosLista = new ArrayList<>();
    int TOTAL = 14;
    
    System.out.println("-----INGRESO DE DATOS-----");
    
    for (int i = 1; i<=TOTAL; i++){
    System.out.println("Alumno #: " + i + "de" + TOTAL);
    Persona persona = new Persona ();
    
    System.out.print("Nombre: ");
    persona.setNombre(scanner.nextLine());
    
    System.out.print("Edad: ");
    persona.setEdad(scanner.nextInt());
    scanner.nextLine();
    
    System.out.print("Clor: ");
    persona.setColor(scanner.nextLine());
    
    System.out.print("Tamaño: ");
    persona.setTamaño(scanner.nextDouble());
    
    System.out.print("Peso: ");
    persona.setPeso(scanner.nextDouble());
    scanner.nextLine();
    
    alumnosLista.add(persona);
    }
    
    System.out.println("=====LISTA DE ESTUDIANTES=====");
    System.out.printf("%-15s %-6s %-10s %-8s%n",
            "NOMBRE", "EDAD", "COLOR", "TAMAÑO", "PESO");
    System.out.println("----------------------------------------");
    for (int pos = 0; pos < alumnosLista.size(); pos++){
        Persona p  = alumnosLista.get(pos);
        System.out.printf("%-15s %-6d %-10s %-10.2f %-8.2f%n",
                p.nombre, p.edad, p.color, p.tamaño, p.peso);
    }
    scanner.close();
}
}
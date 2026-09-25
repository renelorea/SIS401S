/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poo.sis401s.objeto.Direccion.Directorio_Escolar;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author arman
 */
public class Direcorio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Persona> listaAlumnos = new ArrayList<>();
        ArrayList<Direccion> listaDirecciones = new ArrayList<>();
        
        int totalAlumnos = 14; 

        System.out.println("REGISTRO COMPLETO DE ALUMNOS");

        for (int i = 1; i <= totalAlumnos; i++) {
            System.out.println("Direcorio De  Alumno " + i );
 
            Persona persona = new Persona();
            Direccion direccion = new Direccion();

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

            System.out.println("> Domicilio de " + persona.getNombre() + ":");
            
            System.out.print("Calle: ");
            direccion.setCalle(scanner.nextLine());

            System.out.print("Numero: ");
            direccion.setNumero(scanner.nextInt());
            scanner.nextLine(); 

            System.out.print("Colonia: ");
            direccion.setColonia(scanner.nextLine());

            System.out.print("C.P.: ");
            direccion.setCP(scanner.nextInt());
            scanner.nextLine(); 

            System.out.print("Estado: ");
            direccion.setEstado(scanner.nextLine());

            System.out.print("Pais: ");
            direccion.setPais(scanner.nextLine());

            listaAlumnos.add(persona);
            listaDirecciones.add(direccion);
        }

        System.out.println("DIRECTORIO ESCOLAR");
    
        for (int i = 0; i < listaAlumnos.size(); i++) {
            Persona p = listaAlumnos.get(i);
            Direccion d = listaDirecciones.get(i);
            
            System.out.println((i + 1) + ". " + p.getNombre() + " (" + p.getEdad() + " años)");
            System.out.println("   Vive en: " + d.getCalle() + " #" + d.getNumero() + ", Col. " + d.getColonia() + ". C.P. " + d.getCP());
        }

        scanner.close();
    }
}   


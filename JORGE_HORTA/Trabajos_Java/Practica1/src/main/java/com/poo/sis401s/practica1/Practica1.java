/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.poo.sis401s.practica1;
import java.util.Scanner;
import com.poo.sis401s.OBJETO.Persona;
import java.util.ArrayList;

/**
 *
 * @author lobog
 */
public class Practica1 {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      ArrayList<Persona> alumnos = new ArrayList<>();
      for (int i = 0; i < 14; i++){
          Persona persona = new Persona();
          System.out.print("Alumno: "+(i + 1));
          System.out.print("Nombre: ");
          persona.setNombre(sc.nextLine());
          System.out.print("Edad: ");
          persona.setEdad(sc.nextInt());
          sc.nextLine();
          System.out.print("Color: ");
          persona.setColor(sc.nextLine());
          System.out.print("Tamaño:");
          persona.setTamaño(sc.nextDouble());
          System.out.print("Peso:");
          persona.setPeso(sc.nextDouble());
          sc.nextLine();
          alumnos.add(persona);
          System.out.println();
      }
      System.out.println("===ALUMNOS===");
    for(Persona persona : alumnos){
        System.out.println("Nombre: "+ persona.getNombre());
        System.out.println("Edad: "+ persona.getEdad());
        System.out.println("Color: "+ persona.getColor());
        System.out.println("Tamaño: "+ persona.getTamaño());
        System.out.println("Peso: "+ persona.getPeso());
        System.out.println("--------");
        
          
          
      }
    }

    
}

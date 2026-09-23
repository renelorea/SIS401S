/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.poo.sis401s.practica1;
import java.util.Scanner;
import com.poo.sis401s.OBJETO.Persona;
import java.util.ArrayList;
import com.poo.sis401s.OBJETO.Direccion;
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
          Direccion direccion = new Direccion();
          System.out.println("====ALUMNO===="+ (i + 1)+"====");
          System.out.print("Nombre: ");
          persona.setNombre(sc.nextLine());
          System.out.print("Edad: ");
          persona.setEdad(sc.nextInt());
          sc.nextLine();
          System.out.print("Test: ");
          persona.setTest(sc.nextLine());
          System.out.print("Estatura:");
          persona.setEstatura(sc.nextDouble());
          System.out.print("Peso:");
          persona.setPeso(sc.nextDouble());
          sc.nextLine();
          System.out.println("----DIRECCION----");
          
          System.out.print("Calle: ");
          direccion.setCalle(sc.nextLine());
          System.out.print("Numero: ");
          direccion.setNumero(sc.nextInt());
          System.out.print("Colonia: ");
          direccion.setColonia(sc.nextLine());
          sc.nextLine();
          System.out.print("Codigopostal: ");
          direccion.setCodigopostal(sc.nextInt());
          System.out.print("Estado: ");
          sc.nextLine();
          direccion.setEstado(sc.nextLine());
          System.out.print("Pais: ");
          direccion.setPais(sc.nextLine());
          
          persona.setDireccion(direccion);
          alumnos.add(persona);
          System.out.println();
      }
       System.out.println("====ALUMNOS====");
       for (Persona persona : alumnos){
        System.out.println("Nombre: "+ persona.getNombre());
        System.out.println("Edad: "+ persona.getEdad());
        System.out.println("Test: "+ persona.getTest());
        System.out.println("Estatura: "+ persona.getEstatura());
        System.out.println("Peso: "+ persona.getPeso());
      
        System.out.println("----DIRECCION----");
        
        
        System.out.println("Calle: "+ persona.getDireccion().getCalle());
        
        System.out.println("Numero: "+ persona.getDireccion().getNumero());
        
        System.out.println("Colonia: "+ persona.getDireccion().getColonia());
        
        System.out.println("Codigopostal: "+ persona.getDireccion().getCodigopostal());
        
        System.out.println("Estado: "+ persona.getDireccion().getEstado());
        
        System.out.println("Pais: "+persona.getDireccion().getPais());
      
        System.out.println("--------");
        
          
      }
      }
    }

    


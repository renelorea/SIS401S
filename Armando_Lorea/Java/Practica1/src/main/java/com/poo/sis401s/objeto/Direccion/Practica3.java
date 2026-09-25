/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poo.sis401s.objeto.Direccion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author arman
 */
public class Practica3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Direccion> listaDirecciones = new ArrayList<>();

        int totalDirecciones = 2; 

        System.out.println("=== Registro de Direcciones ===");

        for (int i = 1; i <= totalDirecciones; i++) {
            System.out.println("\n--- Dirección " + i + " de " + totalDirecciones + " ---");

            Direccion direccion = new Direccion();

            System.out.print("Calle: ");
            direccion.setCalle(scanner.nextLine());

            System.out.print("Número: ");
            direccion.setNumero(scanner.nextInt());
            scanner.nextLine(); 

            System.out.print("Colonia: ");
            direccion.setColonia(scanner.nextLine());

            System.out.print("C.P.: ");
            direccion.setCP(scanner.nextInt());
            scanner.nextLine(); 

            System.out.print("Estado: ");
            direccion.setEstado(scanner.nextLine());

            System.out.print("País: ");
            direccion.setPais(scanner.nextLine());

            listaDirecciones.add(direccion);
        }

        System.out.println("LISTA DE DIRECCIONES");
        
        for (int i = 0; i < listaDirecciones.size(); i++) {
            Direccion d = listaDirecciones.get(i);
            System.out.println((i + 1) + ". " + d.getCalle() + " #" + d.getNumero() 
                    + " | Col. " + d.getColonia() 
                    + " | C.P. " + d.getCP() 
                    + " | " + d.getEstado() 
                    + ", " + d.getPais());
        }

        scanner.close();
    }
}

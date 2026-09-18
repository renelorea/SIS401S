/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.poo.sis401s.objeto;

/**
 *
 * @author arman
 */
public class Practica1 {

    public static void main(String[] args) {
        Persona persona = new Persona();
        
        persona.setNombre("Daniela");
        persona.setEdad(25);
        persona.setColor("Moreno");
        persona.setTamano(1.55);
        persona.setPeso(62.0);
        
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Edad: " + persona.getEdad());
        System.out.println("Color: " + persona.getColor());
        System.out.println("Tamaño: " + persona.getTamano());
        System.out.println("Peso: " + persona.getPeso());
        }
}

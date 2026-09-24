/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.poo.sis401s.practica1;

/**
 *
 * @author pao
 */
public class Practica1 {

    public static void main(String[] args) {
        Persona persona= new Persona();
        
        persona.setNombre("Daniela");
        persona.setEdad(28);
        persona.setColor("Moreno");
        persona.setTamaño(1.54);
        persona.setPeso(62);
        
        System.out.println("Nombre: "+persona.getNombre());
        System.out.println("Edad: "+persona.getEdad());
        System.out.println("Color: "+persona.getColor());
        System.out.println("Tamaño: "+persona.getTamaño());
        System.out.println("Peso: "+persona.getPeso());
    }
}

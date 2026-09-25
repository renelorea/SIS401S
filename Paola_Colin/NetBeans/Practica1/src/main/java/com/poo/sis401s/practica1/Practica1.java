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
        Direccion direccion = new Direccion ();
        
        direccion.setCalle("Cerrada a Marqueza");
        direccion.setNumero(-1);
        direccion.setColonia("Mirador");
        direccion.setCodigoPostal(54967);
        direccion.setEstado("Mexico");
        direccion.setPais("Mexico");
        
        Persona2 persona= new Persona2();
        
        persona.setNombre("Paola");
        persona.setEdad(18);
        persona.setTez ("Moreno");
        persona.setEstatura(1.60);
        persona.setPeso(50);
        
        
        System.out.println("Nombre: "+persona.getNombre());
        System.out.println("Edad: "+persona.getEdad());
        System.out.println("Color: "+persona.getTez());
        System.out.println("Tamaño: "+persona.getEstatura());
        System.out.println("Peso: "+persona.getPeso());
        System.out.println("Calle: "+direccion.getCalle());
        System.out.println("Numero: "+direccion.getNumero());
        System.out.println("Colonia: "+direccion.getColonia());
        System.out.println("CodigoPostal: "+direccion.getCodigoPostal());
        System.out.println("Estado: "+direccion.getEstado());
        System.out.println("Pais: "+direccion.getPais());
    }
}

package com.poo.sis401s;

import java.util.ArrayList;
import java.util.List;

public class Practica2 {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();

        personas.add(new Persona("Carlos Caballero", 19, "Moreno", 65   , 1.75));
        personas.add(new Persona("Carlos De La Luz", 21, "Claro", 70, 1.65));
        personas.add(new Persona("Jorge Estrada", 36, "Claro", 70, 1.60));
        personas.add(new Persona("Montserrat Reyes", 22, "Blanco", 55, 1.50));
        personas.add(new Persona("Luis Torres", 21, "Moreno", 75, 1.90));
        personas.add(new Persona("Paola Adilene", 20, "Morena", 65, 1.68));
        personas.add(new Persona("Yael Reyes", 19, "Moreno", 85, 1.50));
        personas.add(new Persona("Armando Lorea", 21, "Moreno", 70, 1.62));
        personas.add(new Persona("Raul Millan", 32, "Claro", 67, 1.70));
        personas.add(new Persona("Roberto Galvez", 19, "Blanco", 52, 1.58));
        personas.add(new Persona("Yeshua Hazael", 19, "Claro", 72, 1.62));
        personas.add(new Persona("Justin Jair", 20, "Moreno", 62, 1.66));
        personas.add(new Persona("Daniela Rojas", 26, "Morena", 60, 1.62));
        personas.add(new Persona("Jaqueline Díaz", 25, "Morena", 57, 1.64));

        System.out.println("Lista de personas:");
        for (Persona persona : personas) {
            System.out.println(persona);

        }

    }
}

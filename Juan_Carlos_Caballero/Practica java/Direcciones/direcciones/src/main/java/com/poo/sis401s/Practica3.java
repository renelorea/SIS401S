package com.poo.sis401s;

import java.util.ArrayList;
import java.util.List;

public class Practica3 {
    public static void main(String[] args) {
        List<Direccion> direcciones = new ArrayList<>();

        direcciones.add(new Direccion("Calle 1", 123, "Colonia A", 12345, "Estado X", "Pais Y"));
        direcciones.add(new Direccion("Calle 2", 456, "Colonia B", 67890, "Estado Z", "Pais W"));
        direcciones.add(new Direccion("Calle 3", 789, "Colonia C", 13579, "Estado V", "Pais U"));
        direcciones.add(new Direccion("Calle 4", 246, "Colonia D", 97531, "Estado T", "Pais S"));
        direcciones.add(new Direccion("Calle 5", 135, "Colonia E", 86420, "Estado R", "Pais Q"));
        direcciones.add(new Direccion("Calle 6", 246, "Colonia F", 97531, "Estado U", "Pais T"));
        direcciones.add(new Direccion("Calle 7", 357, "Colonia G", 86420, "Estado S", "Pais R"));
        direcciones.add(new Direccion("Calle 8", 468, "Colonia H", 75310, "Estado Q", "Pais P"));
        direcciones.add(new Direccion("Calle 9", 579, "Colonia I", 64208, "Estado O", "Pais N"));
        direcciones.add(new Direccion("Calle 10", 680, "Colonia J", 53107, "Estado M", "Pais L"));

        System.out.println("Lista de direcciones:");
        for (Direccion Direccion : direcciones) {
            System.out.println(Direccion);

        }

    }
}

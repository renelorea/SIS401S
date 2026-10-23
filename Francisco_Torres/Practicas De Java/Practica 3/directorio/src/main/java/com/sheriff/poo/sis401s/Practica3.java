package com.sheriff.poo.sis401s;

import java.util.ArrayList;
import java.util.List;

public class Practica3 {
    public static void main(String[] args) {
        List<Direccion> directorio = new ArrayList<>();

        directorio.add(new Direccion("Hombres Illustres", 19, "Melchor Ocampo", 54880, "México", "Estado de México"));
        directorio .add(new Direccion("Melchor Ocampo", 21, "Melchor Ocampo", 54880, "México", "Estado de México"));
        directorio.add(new Direccion("Porfirio Diaz", 36, "Visitacion", 54880, "México", "Estado de México"));
        directorio.add(new Direccion("Ignacion Zaragoza", 22, "Tultepec", 54880, "México", "Estado de México"));
        directorio.add(new Direccion("Himno Nacional", 21, "Tenopalco", 54880, "México", "Estado de México"));
        directorio.add(new Direccion("Lerdo de Tejada", 20, "Joyas de Cuautitlan", 54880, "México", "Estado de México"));
        directorio.add(new Direccion("Venustiano Carranza", 19, "Tultepec", 54880, "México", "Estado de México"));
        directorio.add(new Direccion("Francisco I. Madero", 25, "Coacalco", 54880, "México", "Estado de México" ));

        System.out.println("Lista de direcciones:");
        for (Direccion direccion : directorio) {
            System.out.println(direccion.getCalleString(direccion.calle) + " " + direccion.getNumero(direccion.numero) + ", " + direccion.getColonia(direccion.colonia) + ", " + direccion.getCodigoPostal(direccion.codigopostal) + ", " + direccion.Estado + ", " + direccion.Pais);
        }

    }
}

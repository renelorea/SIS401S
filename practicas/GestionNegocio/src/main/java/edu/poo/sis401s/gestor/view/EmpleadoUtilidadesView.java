/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.view;

import edu.poo.sis401s.gestor.model.Empleado;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 * Metodos de apoyo para las ventanas: validar datos y mostrar mensajes.
 */
public class EmpleadoUtilidadesView {

    private EmpleadoUtilidadesView() {
    }

    // Convierte texto a entero; regresa null si no es un numero entero valido
    public static Integer aEntero(String texto) {
        try {
            return Integer.valueOf(texto.trim());
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    // Convierte texto a decimal; regresa null si no es un numero valido
    public static Double aDecimal(String texto) {
        try {
            return Double.valueOf(texto.trim());
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    public static boolean esVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }

    // Arma el texto con todos los datos de un empleado
    public static String detalle(Empleado e) {
        return "ID: " + e.getId() + "\n"
                + "Nombre: " + e.getNombre() + "\n"
                + "Edad: " + e.getEdad() + " años\n"
                + "Puesto: " + e.getPuesto() + "\n"
                + "Salario: $" + String.format("%.2f", e.getSalario()) + "\n"
                + "Teléfono: " + e.getTelefono() + "\n"
                + "Dirección: " + e.getDireccion() + "\n"
                + "Fecha de ingreso: " + e.getFechaIngreso();
    }

    public static void error(Component padre, String mensaje) {
        JOptionPane.showMessageDialog(padre, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void info(Component padre, String mensaje) {
        JOptionPane.showMessageDialog(padre, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }
}
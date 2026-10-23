/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Ventana con las instrucciones de uso del menu.
 */
public class EmpleadoInstruccionesView extends JDialog {

    private static final String TEXTO
            = "BIENVENIDO AL MÓDULO DE EMPLEADOS\n\n"
            + "Este módulo sirve para llevar el registro de los empleados del negocio. "
            + "Desde el menú principal puedes elegir una de estas opciones:\n\n"
            + "1. Agregar empleado\n"
            + "   Para registrar a un empleado nuevo. Llena todos los campos: ID (número único), "
            + "nombre, edad (18 a 99), puesto, salario, teléfono (10 dígitos), dirección y "
            + "fecha de ingreso (dd/mm/aaaa). Presiona Guardar para registrarlo.\n\n"
            + "2. Mostrar todos los empleados\n"
            + "   Para ver en una tabla a todos los empleados registrados y cuántos hay.\n\n"
            + "3. Buscar empleado por ID\n"
            + "   Para consultar los datos completos de un empleado. Escribe su ID y presiona Buscar.\n\n"
            + "4. Modificar puesto y salario\n"
            + "   Para actualizar el puesto y el salario de un empleado. Escribe su ID, presiona "
            + "Cargar datos para ver lo actual, cambia lo que necesites y presiona Guardar cambios.\n\n"
            + "5. Eliminar empleado\n"
            + "   Para dar de baja a un empleado. Escribe su ID y presiona Eliminar; el sistema "
            + "te pedirá confirmación antes de borrarlo.\n\n"
            + "6. Salir\n"
            + "   Cierra el programa.\n\n"
            + "NOTA: los datos se guardan solo mientras el programa está abierto. "
            + "Al cerrarlo, la lista de empleados se vacía.";

    public EmpleadoInstruccionesView(Frame owner) {
        super(owner, "Instrucciones", true);
        construir();
    }

    private void construir() {
        JTextArea area = new JTextArea(TEXTO);
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setFont(new Font("SansSerif", Font.PLAIN, 14));
        area.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        area.setCaretPosition(0);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());
        JPanel abajo = new JPanel();
        abajo.add(btnCerrar);

        add(new JScrollPane(area), BorderLayout.CENTER);
        add(abajo, BorderLayout.SOUTH);
        setSize(560, 520);
        setLocationRelativeTo(getOwner());
    }
}

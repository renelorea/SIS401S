/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.view;

import edu.poo.sis401s.gestor.model.Empleado;
import edu.poo.sis401s.gestor.controller.EmpleadoController;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Ventana para eliminar un empleado (pide confirmacion antes de borrar).
 */
public class EmpleadoEliminarView extends JDialog {

    private final EmpleadoController controlador;
    private final JTextField txtId = new JTextField(10);

    public EmpleadoEliminarView(Frame owner, EmpleadoController controlador) {
        super(owner, "Eliminar empleado", true);
        this.controlador = controlador;
        construir();
    }

    private void construir() {
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(e -> eliminar());
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());

        JPanel centro = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        centro.add(new JLabel("ID del empleado:"));
        centro.add(txtId);

        JPanel abajo = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        abajo.add(btnEliminar);
        abajo.add(btnCerrar);

        add(centro, BorderLayout.CENTER);
        add(abajo, BorderLayout.SOUTH);
        getRootPane().setDefaultButton(btnEliminar);
        setSize(380, 160);
        setResizable(false);
        setLocationRelativeTo(getOwner());
    }

    private void eliminar() {
        Integer id = EmpleadoUtilidadesView.aEntero(txtId.getText());
        if (id == null) {
            EmpleadoUtilidadesView.error(this, "Escribe un ID válido (número entero).");
            return;
        }
        Empleado e = controlador.buscarEmpleadoPorId(id);
        if (e == null) {
            EmpleadoUtilidadesView.error(this, "No se encontró ningún empleado con ese ID.");
            return;
        }
        int respuesta = JOptionPane.showConfirmDialog(this,
                "¿Seguro que quieres eliminar a " + e.getNombre() + " (ID " + e.getId() + ")?",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            if (controlador.eliminarEmpleado(id)) {
                EmpleadoUtilidadesView.info(this, "Empleado eliminado correctamente.");
                txtId.setText("");
            } else {
                EmpleadoUtilidadesView.error(this, "No se pudo eliminar el empleado.");
            }
        }
    }
}

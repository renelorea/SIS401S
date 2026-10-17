/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.view;

import edu.poo.sis401s.gestor.model.Empleado;
import edu.poo.sis401s.gestor.services.EmpleadoService;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Ventana que muestra todos los empleados en una tabla.
 */
public class EmpleadoListadoView extends JDialog {

    private final EmpleadoService service;
    private final DefaultTableModel modelo;
    private final JLabel lblTotal = new JLabel();

    public EmpleadoListadoView(Frame owner, EmpleadoService service) {
        super(owner, "Lista de empleados", true);
        this.service = service;
        String[] columnas = {"ID", "Nombre", "Edad", "Puesto", "Salario",
            "Teléfono", "Dirección", "Fecha de ingreso"};
        modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        construir();
        cargarDatos();
    }

    private void construir() {
        JTable tabla = new JTable(modelo);
        tabla.setRowHeight(24);
        JScrollPane scroll = new JScrollPane(tabla);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(e -> cargarDatos());
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());

        JPanel abajo = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        abajo.add(lblTotal);
        abajo.add(btnActualizar);
        abajo.add(btnCerrar);

        add(scroll, BorderLayout.CENTER);
        add(abajo, BorderLayout.SOUTH);
        setSize(850, 380);
        setLocationRelativeTo(getOwner());
    }

    private void cargarDatos() {
        modelo.setRowCount(0);
        int total = 0;
        for (Empleado e : service.obtenerTodos()) {
            modelo.addRow(new Object[]{e.getId(), e.getNombre(), e.getEdad(),
                e.getPuesto(), e.getSalario(), e.getTelefono(),
                e.getDireccion(), e.getFechaIngreso()});
            total++;
        }
        lblTotal.setText("Total de empleados: " + total);
    }
}

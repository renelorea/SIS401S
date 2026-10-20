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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Ventana para buscar un empleado por su ID.
 */
public class EmpleadoBuscarView extends JDialog {

    private final EmpleadoController controlador;
    private final JTextField txtId = new JTextField(10);
    private final JTextArea txtResultado = new JTextArea(9, 30);

    public EmpleadoBuscarView(Frame owner, EmpleadoController controlador) {
        super(owner, "Buscar empleado por ID", true);
        this.controlador = controlador;
        construir();
    }

    private void construir() {
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(e -> buscar());

        JPanel arriba = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        arriba.add(new JLabel("ID del empleado:"));
        arriba.add(txtId);
        arriba.add(btnBuscar);

        txtResultado.setEditable(false);
        txtResultado.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        JScrollPane scroll = new JScrollPane(txtResultado);
        scroll.setBorder(BorderFactory.createTitledBorder("Resultado"));

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());
        JPanel abajo = new JPanel();
        abajo.add(btnCerrar);

        add(arriba, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(abajo, BorderLayout.SOUTH);
        getRootPane().setDefaultButton(btnBuscar);
        pack();
        setLocationRelativeTo(getOwner());
    }

    private void buscar() {
        Integer id = EmpleadoUtilidadesView.aEntero(txtId.getText());
        if (id == null) {
            EmpleadoUtilidadesView.error(this, "Escribe un ID válido (número entero).");
            return;
        }
        Empleado e = controlador.buscarEmpleadoPorId(id);
        if (e == null) {
            txtResultado.setText("");
            EmpleadoUtilidadesView.error(this, "No se encontró ningún empleado con ese ID.");
        } else {
            txtResultado.setText(EmpleadoUtilidadesView.detalle(e));
        }
    }
}

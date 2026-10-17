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
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Ventana para modificar el puesto y el salario de un empleado.
 */
public class EmpleadoModificarView extends JDialog {

    private final EmpleadoService service;
    private final JTextField txtId = new JTextField();
    private final JLabel lblNombre = new JLabel("-");
    private final JTextField txtPuesto = new JTextField();
    private final JTextField txtSalario = new JTextField();

    public EmpleadoModificarView(Frame owner, EmpleadoService service) {
        super(owner, "Modificar empleado", true);
        this.service = service;
        construir();
    }

    private void construir() {
        JPanel formulario = new JPanel(new GridLayout(4, 2, 8, 8));
        formulario.setBorder(BorderFactory.createEmptyBorder(15, 15, 5, 15));
        formulario.add(new JLabel("ID del empleado:"));
        formulario.add(txtId);
        formulario.add(new JLabel("Empleado:"));
        formulario.add(lblNombre);
        formulario.add(new JLabel("Nuevo puesto:"));
        formulario.add(txtPuesto);
        formulario.add(new JLabel("Nuevo salario:"));
        formulario.add(txtSalario);

        JButton btnCargar = new JButton("Cargar datos");
        btnCargar.addActionListener(e -> cargar());
        JButton btnGuardar = new JButton("Guardar cambios");
        btnGuardar.addActionListener(e -> guardar());
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        botones.add(btnCargar);
        botones.add(btnGuardar);
        botones.add(btnCerrar);

        add(formulario, BorderLayout.CENTER);
        add(botones, BorderLayout.SOUTH);
        setSize(460, 250);
        setResizable(false);
        setLocationRelativeTo(getOwner());
    }

    // Busca al empleado y muestra su puesto y salario actuales
    private void cargar() {
        Integer id = EmpleadoUtilidadesView.aEntero(txtId.getText());
        if (id == null) {
            EmpleadoUtilidadesView.error(this, "Escribe un ID válido (número entero).");
            return;
        }
        Empleado e = service.buscarPorId(id);
        if (e == null) {
            EmpleadoUtilidadesView.error(this, "No se encontró ningún empleado con ese ID.");
            return;
        }
        lblNombre.setText(e.getNombre());
        txtPuesto.setText(e.getPuesto());
        txtSalario.setText(String.valueOf(e.getSalario()));
    }

    private void guardar() {
        Integer id = EmpleadoUtilidadesView.aEntero(txtId.getText());
        if (id == null) {
            EmpleadoUtilidadesView.error(this, "Escribe un ID válido (número entero).");
            return;
        }
        if (EmpleadoUtilidadesView.esVacio(txtPuesto.getText())) {
            EmpleadoUtilidadesView.error(this, "El puesto no puede estar vacío.");
            return;
        }
        Double salario = EmpleadoUtilidadesView.aDecimal(txtSalario.getText());
        if (salario == null || salario <= 0) {
            EmpleadoUtilidadesView.error(this, "El salario debe ser un número mayor a 0.");
            return;
        }
        if (service.modificarEmpleado(id, txtPuesto.getText().trim(), salario)) {
            EmpleadoUtilidadesView.info(this, "Empleado modificado correctamente.");
        } else {
            EmpleadoUtilidadesView.error(this, "No se encontró ningún empleado con ese ID.");
        }
    }
}

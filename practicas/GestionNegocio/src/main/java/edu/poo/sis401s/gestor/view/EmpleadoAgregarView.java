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
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Ventana para registrar un empleado nuevo.
 */
public class EmpleadoAgregarView extends JDialog {

    private final EmpleadoController controlador;
    private final JTextField txtId = new JTextField();
    private final JTextField txtNombre = new JTextField();
    private final JTextField txtEdad = new JTextField();
    private final JTextField txtPuesto = new JTextField();
    private final JTextField txtSalario = new JTextField();
    private final JTextField txtTelefono = new JTextField();
    private final JTextField txtDireccion = new JTextField();
    private final JTextField txtFecha = new JTextField();

    public EmpleadoAgregarView(Frame owner, EmpleadoController controlador) {
        super(owner, "Agregar empleado", true);
        this.controlador = controlador;
        construir();
    }

    private void construir() {
        JPanel formulario = new JPanel(new GridLayout(8, 2, 8, 8));
        formulario.setBorder(BorderFactory.createEmptyBorder(15, 15, 5, 15));
        formulario.add(new JLabel("ID:"));
        formulario.add(txtId);
        formulario.add(new JLabel("Nombre:"));
        formulario.add(txtNombre);
        formulario.add(new JLabel("Edad:"));
        formulario.add(txtEdad);
        formulario.add(new JLabel("Puesto:"));
        formulario.add(txtPuesto);
        formulario.add(new JLabel("Salario:"));
        formulario.add(txtSalario);
        formulario.add(new JLabel("Teléfono (10 dígitos):"));
        formulario.add(txtTelefono);
        formulario.add(new JLabel("Dirección:"));
        formulario.add(txtDireccion);
        formulario.add(new JLabel("Fecha de ingreso (dd/mm/aaaa):"));
        formulario.add(txtFecha);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardar());
        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(e -> limpiar());
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        botones.add(btnGuardar);
        botones.add(btnLimpiar);
        botones.add(btnCerrar);

        add(formulario, BorderLayout.CENTER);
        add(botones, BorderLayout.SOUTH);
        getRootPane().setDefaultButton(btnGuardar);
        setSize(480, 400);
        setResizable(false);
        setLocationRelativeTo(getOwner());
    }

    private void guardar() {
        Integer id = EmpleadoUtilidadesView.aEntero(txtId.getText());
        if (id == null || id <= 0) {
            EmpleadoUtilidadesView.error(this, "El ID debe ser un número entero positivo.");
            return;
        }
        if (controlador.buscarEmpleadoPorId(id) != null) {
            EmpleadoUtilidadesView.error(this, "Ya existe un empleado con ese ID.");
            return;
        }
        if (EmpleadoUtilidadesView.esVacio(txtNombre.getText())) {
            EmpleadoUtilidadesView.error(this, "El nombre no puede estar vacío.");
            return;
        }
        Integer edad = EmpleadoUtilidadesView.aEntero(txtEdad.getText());
        if (edad == null || edad < 18 || edad > 99) {
            EmpleadoUtilidadesView.error(this, "La edad debe ser un número entre 18 y 99.");
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
        String telefono = txtTelefono.getText().trim();
        if (!telefono.matches("\\d{10}")) {
            EmpleadoUtilidadesView.error(this, "El teléfono debe tener exactamente 10 dígitos.");
            return;
        }
        if (EmpleadoUtilidadesView.esVacio(txtDireccion.getText())) {
            EmpleadoUtilidadesView.error(this, "La dirección no puede estar vacía.");
            return;
        }
        String fecha = txtFecha.getText().trim();
        if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
            EmpleadoUtilidadesView.error(this, "La fecha debe tener el formato dd/mm/aaaa.");
            return;
        }

        Empleado nuevo = new Empleado(id, txtNombre.getText().trim(), edad,
                txtPuesto.getText().trim(), salario, telefono,
                txtDireccion.getText().trim(), fecha);
        controlador.agregarEmpleado(nuevo);
        EmpleadoUtilidadesView.info(this, "Empleado registrado correctamente.");
        limpiar();
    }

    private void limpiar() {
        txtId.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        txtPuesto.setText("");
        txtSalario.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtFecha.setText("");
        txtId.requestFocus();
    }
}

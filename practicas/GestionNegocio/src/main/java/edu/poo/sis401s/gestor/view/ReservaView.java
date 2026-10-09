/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.gestionnegocio.view;

/**
 *
 * @author yeyos
 */




import edu.poo.gestionnegocio.model.Reserva;
import edu.poo.gestionnegocio.repository.ReservaRepository;
import edu.poo.gestionnegocio.service.ReservaService;
import edu.poo.gestionnegocio.controller.ReservaController;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.time.LocalDateTime;

public class ReservaView extends JFrame {
    private final ReservaController controller;
    private DefaultTableModel modeloTabla;
    private JTable tabla;

    public ReservaView(ReservaController controller) {
        this.controller = controller;
        setTitle("Gestión de Reservas - Historial");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Modelo y tabla (estatus y comentarios editables)
        modeloTabla = new DefaultTableModel(
            new Object[]{"Código", "Persona", "Servicio", "Cantidad", "Precio", "Fecha", "Prioridad", "Estatus", "Comentarios"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 7 || column == 8; // Solo editar estatus y comentarios
            }
        };

        tabla = new JTable(modeloTabla);

        // Listener para cambios en tabla
        tabla.getModel().addTableModelListener(e -> {
            int fila = e.getFirstRow();
            int columna = e.getColumn();

            if (columna == 8) { // Comentarios
                String nuevoComentario = (String) modeloTabla.getValueAt(fila, columna);
                String codigo = (String) modeloTabla.getValueAt(fila, 0);
                controller.actualizarComentario(codigo, nuevoComentario);
            }

            if (columna == 7) { // Estatus
                String nuevoEstatus = (String) modeloTabla.getValueAt(fila, columna);
                String codigo = (String) modeloTabla.getValueAt(fila, 0);
                controller.cambiarEstatus(codigo, nuevoEstatus);
            }
        });

        // Render para prioridad con color
        tabla.getColumnModel().getColumn(6).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                String prioridad = (String) value;
                if (prioridad == null) c.setBackground(Color.WHITE);
                else switch (prioridad) {
                    case "Alta" -> c.setBackground(Color.RED);
                    case "Media" -> c.setBackground(Color.YELLOW);
                    case "Baja" -> c.setBackground(Color.GREEN);
                    default -> c.setBackground(Color.WHITE);
                }
                return c;
            }
        });

        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);

        // --- Panel de entrada ---
        JTextField txtNombre = new JTextField(10);
        JTextField txtServicio = new JTextField(10);
        JTextField txtCantidad = new JTextField(5);
        JTextField txtPrecio = new JTextField(7);
        JTextArea txtComentarios = new JTextArea(3, 20);
        JComboBox<String> cmbPrioridad = new JComboBox<>(new String[]{"Alta", "Media", "Baja"});

        JPanel panelEntrada = new JPanel();
        panelEntrada.add(new JLabel("Nombre:"));
        panelEntrada.add(txtNombre);
        panelEntrada.add(new JLabel("Servicio:"));
        panelEntrada.add(txtServicio);
        panelEntrada.add(new JLabel("Cantidad:"));
        panelEntrada.add(txtCantidad);
        panelEntrada.add(new JLabel("Precio:"));
        panelEntrada.add(txtPrecio);
        panelEntrada.add(new JLabel("Prioridad:"));
        panelEntrada.add(cmbPrioridad);
        panelEntrada.add(new JLabel("Comentarios:"));
        panelEntrada.add(new JScrollPane(txtComentarios));

        add(panelEntrada, BorderLayout.NORTH);

        // Botón Agregar
        JButton btnAgregar = new JButton("Agregar Reserva");
        btnAgregar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            String servicio = txtServicio.getText();
            int cantidad = Integer.parseInt(txtCantidad.getText());
            double precio = Double.parseDouble(txtPrecio.getText());
            String comentarios = txtComentarios.getText();
            String prioridad = (String) cmbPrioridad.getSelectedItem();

            Reserva nueva = new Reserva("R-" + (controller.listarReservas().size() + 1),
                                        nombre, "Pendiente");
            nueva.setServicio(servicio);
            nueva.setCantidad(cantidad);
            nueva.setPrecio(precio);
            nueva.setComentarios(comentarios);
            nueva.setFecha(LocalDateTime.now());
            nueva.setPrioridad(prioridad);

            controller.agregarReserva(nueva);
            refrescarTabla();

            // Limpiar campos
            txtNombre.setText("");
            txtServicio.setText("");
            txtCantidad.setText("");
            txtPrecio.setText("");
            txtComentarios.setText("");
            cmbPrioridad.setSelectedIndex(0);
        });

        // Botón Marcar Entregada
        JButton btnEntregada = new JButton("Marcar Entregada");
        btnEntregada.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                String codigo = (String) modeloTabla.getValueAt(fila, 0);
                controller.cambiarEstatus(codigo, "Entregada");
                refrescarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona una reserva primero.");
            }
        });

        // Botón Cambiar Estatus
        JButton btnEditarEstatus = new JButton("Cambiar Estatus");
        btnEditarEstatus.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                String codigo = (String) modeloTabla.getValueAt(fila, 0);
                String estatusActual = (String) modeloTabla.getValueAt(fila, 7);

                String[] opciones = {"Pendiente", "Entregada"};
                String nuevoEstatus = (String) JOptionPane.showInputDialog(
                    this,
                    "Selecciona nuevo estatus:",
                    "Editar Estatus",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    estatusActual
                );

                if (nuevoEstatus != null) {
                    controller.cambiarEstatus(codigo, nuevoEstatus);
                    refrescarTabla();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona una reserva primero.");
            }
        });

        // Botón Editar Comentario
        JButton btnEditarComentario = new JButton("Editar Comentario");
        btnEditarComentario.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                String codigo = (String) modeloTabla.getValueAt(fila, 0);
                String comentarioActual = (String) modeloTabla.getValueAt(fila, 8);

                String nuevoComentario = JOptionPane.showInputDialog(
                    this, "Modificar comentario:", comentarioActual);

                if (nuevoComentario != null) {
                    controller.actualizarComentario(codigo, nuevoComentario);
                    refrescarTabla();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona una reserva primero.");
            }
        });

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEntregada);
        panelBotones.add(btnEditarEstatus);
        panelBotones.add(btnEditarComentario);

        add(panelBotones, BorderLayout.SOUTH);
        refrescarTabla();
    }

    private void refrescarTabla() {
        modeloTabla.setRowCount(0);
        for (Reserva r : controller.listarReservas()) {
            modeloTabla.addRow(new Object[]{
                r.getCodigo(),
                r.getPersona(),
                r.getServicio(),
                r.getCantidad(),
                r.getPrecio(),
                r.getFecha(),
                r.getPrioridad(),
                r.getEstatus(),
                r.getComentarios()
            });
        }
    }

    public static void main(String[] args) {
        ReservaRepository repo = new ReservaRepository();
        ReservaService service = new ReservaService(repo);
        ReservaController controller = new ReservaController(service);

        // Reserva inicial para que la tabla no esté vacía
        service.agregarReserva(new Reserva("R-1", "Yael", "Pendiente"));

        SwingUtilities.invokeLater(() -> {
            new ReservaView(controller).setVisible(true);
        });
    }
}

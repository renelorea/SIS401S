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
import edu.poo.gestionnegocio.services.ReservaService;
import edu.poo.gestionnegocio.controller.ReservaController;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

public class ReservaView extends JFrame {
    private final ReservaController controller;
    private final ReservaService service;
    private DefaultTableModel modeloTabla;
    private JTable tabla;

    public ReservaView(ReservaController controller, ReservaService service) {
        this.controller = controller;
        this.service = service;
        setTitle("Gestión de Reservas - Historial");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Modelo y tabla
        modeloTabla = new DefaultTableModel(
            new Object[]{"Código", "Persona", "Servicio", "Cantidad", "Precio", "Fecha", "Prioridad", "Estatus", "Comentarios"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // la edición se hace con botones
            }
        };

        tabla = new JTable(modeloTabla);

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

        // Campo de búsqueda
        JTextField txtBuscar = new JTextField(10);
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(e -> {
            String criterio = txtBuscar.getText();
            List<Reserva> resultados = service.buscarPorNombre(criterio);
            modeloTabla.setRowCount(0);
            for (Reserva r : resultados) {
                modeloTabla.addRow(new Object[]{
                    r.getCodigo(), r.getPersona(), r.getServicio(),
                    r.getCantidad(), r.getPrecio(), r.getFecha(),
                    r.getPrioridad(), r.getEstatus(), r.getComentarios()
                });
            }
        });

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
        panelEntrada.add(new JLabel("Buscar por nombre:"));
        panelEntrada.add(txtBuscar);
        panelEntrada.add(btnBuscar);

        add(panelEntrada, BorderLayout.NORTH);

        // Botón Agregar
        JButton btnAgregar = new JButton("Agregar Reserva");
        btnAgregar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            String servicioTxt = txtServicio.getText();
            int cantidad = Integer.parseInt(txtCantidad.getText());
            double precio = Double.parseDouble(txtPrecio.getText());
            String comentarios = txtComentarios.getText();
            String prioridad = (String) cmbPrioridad.getSelectedItem();

            Reserva nueva = new Reserva("R-" + (controller.listarReservas().size() + 1),
                                        nombre, "Pendiente");
            nueva.setServicio(servicioTxt);
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
                    controller.cambiarEstatus(codigo, nuevoEstatus, "Yael");
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
                    controller.actualizarComentario(codigo, nuevoComentario, "Yael");
                    refrescarTabla();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona una reserva primero.");
            }
        });

        // Botón Ver Historial
        JButton btnHistorial = new JButton("Ver Historial");
        btnHistorial.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for (String h : service.listarHistorial()) {
                sb.append(h).append("\n");
            }
            JTextArea area = new JTextArea(sb.toString(), 15, 50);
            area.setEditable(false);
            JOptionPane.showMessageDialog(this, new JScrollPane(area),
                                          "Historial de Cambios", JOptionPane.INFORMATION_MESSAGE);
        });

        // Botón Exportar Historial con JFileChooser
        JButton btnExportarHistorial = new JButton("Exportar Historial");
        btnExportarHistorial.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Guardar historial de reservas");
            chooser.setSelectedFile(new java.io.File("historial_reservas.txt"));
            if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                String ruta = chooser.getSelectedFile().getAbsolutePath();
                service.exportarHistorialTxt(ruta);
                JOptionPane.showMessageDialog(this, "Historial exportado en: " + ruta);
            }
        });

        // Botón Exportar Reservas con JFileChooser
        JButton btnExportarReservas = new JButton("Exportar Reservas");
        btnExportarReservas.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Guardar reservas");
            chooser.setSelectedFile(new java.io.File("reservas.txt"));
            if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                String ruta = chooser.getSelectedFile().getAbsolutePath();
                service.exportarReservasTxt(ruta);
                JOptionPane.showMessageDialog(this, "Reservas exportadas en: " + ruta);
            }
        });

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditarEstatus);
        panelBotones.add(btnEditarComentario);
        panelBotones.add(btnHistorial);
        panelBotones.add(btnExportarHistorial);
        panelBotones.add(btnExportarReservas);

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
            new ReservaView(controller, service).setVisible(true);
        });
    }
}
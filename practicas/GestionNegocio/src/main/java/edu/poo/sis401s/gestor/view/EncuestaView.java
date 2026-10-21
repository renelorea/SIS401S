package edu.poo.sis401s.gestor.view;

import edu.poo.sis401s.gestor.controller.EncuestaController;
import edu.poo.sis401s.gestor.model.Cliente;
import edu.poo.sis401s.gestor.model.Encuesta;
import edu.poo.sis401s.gestor.model.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 * Ventana (JFrame escrito a mano) para registrar y consultar encuestas.
 */
public class EncuestaView extends JFrame {
    private final EncuestaController controller;
    private final Usuario usuario;

    private JComboBox<Cliente> cmbCliente;
    private JComboBox<Integer> cmbCalificacion;
    private JTextArea txtComentario;
    private JTable tabla;
    private DefaultTableModel modelo;
    private JLabel lblPromedio;
    private JButton btnEliminar;

    public EncuestaView(EncuestaController controller, Usuario usuario) {
        this.controller = controller;
        this.usuario = usuario;
        construirInterfaz();
        cargarTabla();
    }

    private void construirInterfaz() {
        setTitle("Encuestas de satisfacción");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(720, 520));
        setSize(800, 580);
        setLocationRelativeTo(null);

        JPanel raiz = new JPanel(new BorderLayout(10, 10));
        raiz.setBorder(new EmptyBorder(12, 12, 12, 12));
        raiz.setBackground(Color.WHITE);

        JLabel titulo = new JLabel("ENCUESTAS DE SATISFACCIÓN");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        raiz.add(titulo, BorderLayout.NORTH);

        JPanel centro = new JPanel(new BorderLayout(0, 10));
        centro.setOpaque(false);
        centro.add(crearFormulario(), BorderLayout.NORTH);
        centro.add(crearTabla(), BorderLayout.CENTER);
        raiz.add(centro, BorderLayout.CENTER);

        raiz.add(crearBarraInferior(), BorderLayout.SOUTH);
        setContentPane(raiz);
    }

    private JPanel crearFormulario() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createTitledBorder("Nueva encuesta"));

        cmbCliente = new JComboBox<>();
        cmbCliente.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                    int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Cliente c) {
                    setText(c.getId() + " - " + c.getNombre());
                }
                return this;
            }
        });
        for (Cliente c : controller.listarClientes()) {
            cmbCliente.addItem(c);
        }

        cmbCalificacion = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        cmbCalificacion.setSelectedItem(5);

        txtComentario = new JTextArea(3, 30);
        txtComentario.setLineWrap(true);
        txtComentario.setWrapStyleWord(true);

        JButton btnGuardar = new JButton("Guardar encuesta");
        btnGuardar.addActionListener(e -> guardarEncuesta());

        agregar(panel, new JLabel("Cliente:"), 0, 0, GridBagConstraints.NONE, 0, GridBagConstraints.WEST);
        agregar(panel, cmbCliente, 1, 0, GridBagConstraints.HORIZONTAL, 1, GridBagConstraints.WEST);
        agregar(panel, new JLabel("Calificación (1-5):"), 0, 1, GridBagConstraints.NONE, 0, GridBagConstraints.WEST);
        agregar(panel, cmbCalificacion, 1, 1, GridBagConstraints.NONE, 0, GridBagConstraints.WEST);
        agregar(panel, new JLabel("Comentario:"), 0, 2, GridBagConstraints.NONE, 0, GridBagConstraints.NORTHWEST);
        agregar(panel, new JScrollPane(txtComentario), 1, 2, GridBagConstraints.HORIZONTAL, 1, GridBagConstraints.WEST);
        agregar(panel, btnGuardar, 1, 3, GridBagConstraints.NONE, 0, GridBagConstraints.EAST);
        return panel;
    }

    private void agregar(JPanel panel, Component comp, int x, int y, int fill,
            double pesoX, int ancla) {
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = x;
        gc.gridy = y;
        gc.fill = fill;
        gc.weightx = pesoX;
        gc.anchor = ancla;
        gc.insets = new Insets(4, 6, 4, 6);
        panel.add(comp, gc);
    }

    private JScrollPane crearTabla() {
        modelo = new DefaultTableModel(
                new Object[]{"ID", "Cliente", "Calificación", "Comentario"}, 0) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        tabla = new JTable(modelo);
        tabla.setRowHeight(24);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.getColumnModel().getColumn(0).setMaxWidth(50);
        tabla.getColumnModel().getColumn(2).setMaxWidth(100);
        return new JScrollPane(tabla);
    }

    private JPanel crearBarraInferior() {
        JPanel barra = new JPanel(new BorderLayout());
        barra.setOpaque(false);

        lblPromedio = new JLabel();
        lblPromedio.setFont(new Font("Segoe UI", Font.BOLD, 13));

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        botones.setOpaque(false);

        btnEliminar = new JButton("Eliminar seleccionada");
        btnEliminar.addActionListener(e -> eliminarSeleccionada());
        btnEliminar.setVisible("admin".equalsIgnoreCase(usuario.getRol()));

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(e -> cargarTabla());

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());

        botones.add(btnEliminar);
        botones.add(btnActualizar);
        botones.add(btnCerrar);

        barra.add(lblPromedio, BorderLayout.WEST);
        barra.add(botones, BorderLayout.EAST);
        return barra;
    }

    private void cargarTabla() {
        modelo.setRowCount(0);
        for (Encuesta e : controller.listarEncuestas()) {
            modelo.addRow(new Object[]{e.getId(), e.getCliente().getNombre(),
                e.getCalificacion(), e.getComentario()});
        }
        lblPromedio.setText(String.format("Promedio: %.2f / 5   |   Encuestas: %d",
                controller.calcularPromedio(), modelo.getRowCount()));
    }

    private void guardarEncuesta() {
        Cliente cliente = (Cliente) cmbCliente.getSelectedItem();
        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "No hay clientes registrados.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int calificacion = (Integer) cmbCalificacion.getSelectedItem();
        try {
            controller.registrarEncuesta(cliente.getId(), calificacion, txtComentario.getText());
            JOptionPane.showMessageDialog(this, "Encuesta registrada correctamente.");
            txtComentario.setText("");
            cmbCalificacion.setSelectedItem(5);
            cargarTabla();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarSeleccionada() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una encuesta de la tabla.");
            return;
        }
        int confirmar = JOptionPane.showConfirmDialog(this,
                "¿Eliminar la encuesta seleccionada?", "Confirmar",
                JOptionPane.YES_NO_OPTION);
        if (confirmar != JOptionPane.YES_OPTION) {
            return;
        }
        int id = (Integer) modelo.getValueAt(fila, 0);
        if (controller.eliminarEncuesta(id)) {
            cargarTabla();
        }
    }
}

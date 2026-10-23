package com.mycompany.historialpedidos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;


public class HistorialPedidos extends JFrame {

  
    public static class ItemPedido {
        String nombre;
        int cantidad;
        String prioridad;   // Alta, Media, Baja

        public ItemPedido(String nombre, int cantidad, String prioridad) {
            this.nombre = nombre;
            this.cantidad = cantidad;
            this.prioridad = prioridad;
        }
    }

    
    public static class Pedido {
        String codigo;
        String persona;
        LocalDateTime fecha;
        ArrayList<ItemPedido> productos;  // <-- varios productos
        String estatus;                   // Pendiente, En Proceso, Entregado, Cancelado
        String comentarios;

        public Pedido(String codigo, String persona, LocalDateTime fecha,
                      ArrayList<ItemPedido> productos, String estatus, String comentarios) {
            this.codigo = codigo;
            this.persona = persona;
            this.fecha = fecha;
            this.productos = productos;
            this.estatus = estatus;
            this.comentarios = comentarios;
        }
    }

    private final ArrayList<Pedido> pedidos = new ArrayList<>();
    private final DefaultTableModel modelo;
    private final JTable tabla;
    private final JComboBox<String> filtroEstatus;
    private final JLabel lblTotales;
    private static final String[] ESTATUS = {"Pendiente", "En Proceso", "Entregado", "Cancelado"};
    private static final String[] PRIORIDADES = {"Alta", "Media", "Baja"};
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public HistorialPedidos() {
        super("Historial de Pedidos - Plan Reserva");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050, 550);
        setLocationRelativeTo(null);

        cargarDatosEjemplo();

        String[] columnas = {"Codigo", "Persona", "Fecha/Hora", "Producto",
                             "Cantidad", "Prioridad", "Estatus", "Comentarios"};
        modelo = new DefaultTableModel(columnas, 0) {
            @Override public boolean isCellEditable(int f, int c) { return false; }
        };
        tabla = new JTable(modelo);
        tabla.setRowHeight(28);
        tabla.setFont(new Font("Arial", Font.PLAIN, 13));
        tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));

        int[] anchos = {75, 130, 125, 180, 70, 80, 100, 220};
        for (int i = 0; i < anchos.length; i++) {
            tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }

        tabla.getColumnModel().getColumn(6).setCellRenderer(new EstatusRenderer());
        tabla.getColumnModel().getColumn(7).setCellRenderer(new ComentarioRenderer());

        JScrollPane scroll = new JScrollPane(tabla);

        JPanel barra = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        barra.add(new JLabel("Filtrar por estatus:"));
        filtroEstatus = new JComboBox<>(new String[]{"Todos", "Pendiente", "En Proceso", "Entregado", "Cancelado"});
        filtroEstatus.addActionListener(e -> refrescarTabla());
        barra.add(filtroEstatus);

        JButton btnEstatus = new JButton("Cambiar Estatus");
        JButton btnComentario = new JButton("Agregar Comentario");
        JButton btnDetalle = new JButton("Ver Detalle");
        JButton btnNuevo = new JButton("Nuevo Pedido");

        btnEstatus.addActionListener(e -> cambiarEstatus());
        btnComentario.addActionListener(e -> agregarComentario());
        btnDetalle.addActionListener(e -> verDetalle());
        btnNuevo.addActionListener(e -> nuevoPedido());

        barra.add(btnEstatus);
        barra.add(btnComentario);
        barra.add(btnDetalle);
        barra.add(btnNuevo);

        lblTotales = new JLabel();
        lblTotales.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
        lblTotales.setFont(new Font("Arial", Font.ITALIC, 12));

        add(barra, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(lblTotales, BorderLayout.SOUTH);

        refrescarTabla();
        actualizarTotales();
    }

    // ---- Datos de ejemplo: algunos pedidos con VARIOS productos ----
    private void cargarDatosEjemplo() {
        ArrayList<ItemPedido> p1 = new ArrayList<>();
        p1.add(new ItemPedido("Caja de tornillos #8", 5, "Alta"));
        p1.add(new ItemPedido("Tuercas 3/8", 100, "Baja"));
        pedidos.add(new Pedido("P-001", "Maria Lopez", LocalDateTime.now().minusDays(2),
                p1, "Entregado", "Entregado completo en almacen central."));

        ArrayList<ItemPedido> p2 = new ArrayList<>();
        p2.add(new ItemPedido("Brocha 2 pulgadas", 12, "Media"));
        pedidos.add(new Pedido("P-002", "Juan Perez", LocalDateTime.now().minusDays(1),
                p2, "Pendiente", "Esperando confirmacion del proveedor."));

        ArrayList<ItemPedido> p3 = new ArrayList<>();
        p3.add(new ItemPedido("Pintura blanca 19L", 3, "Alta"));
        p3.add(new ItemPedido("Rodillo de pintura", 6, "Media"));
        p3.add(new ItemPedido("Disolvente 1L", 2, "Baja"));
        pedidos.add(new Pedido("P-003", "Ana Torres", LocalDateTime.now().minusHours(6),
                p3, "En Proceso", "Producto fuera de inventario, se pidio directamente a proveedor."));

        ArrayList<ItemPedido> p4 = new ArrayList<>();
        p4.add(new ItemPedido("Lijas grano 120", 50, "Baja"));
        pedidos.add(new Pedido("P-004", "Luis Gomez", LocalDateTime.now().minusHours(3),
                p4, "Pendiente", "Solicitado por area de carpinteria."));

        ArrayList<ItemPedido> p5 = new ArrayList<>();
        p5.add(new ItemPedido("Guantes de trabajo", 20, "Media"));
        pedidos.add(new Pedido("P-005", "Sofia Ruiz", LocalDateTime.now().minusDays(3),
                p5, "Cancelado", "Cancelado por el solicitante, ya no se requiere."));
    }

    
    private void refrescarTabla() {
        modelo.setRowCount(0);
        String filtro = (String) filtroEstatus.getSelectedItem();
        for (Pedido p : pedidos) {
            if (filtro.equals("Todos") || filtro.equals(p.estatus)) {
                for (ItemPedido it : p.productos) {
                    modelo.addRow(new Object[]{
                        p.codigo, p.persona, p.fecha.format(FORMATO),
                        it.nombre, it.cantidad, it.prioridad, p.estatus, p.comentarios
                    });
                }
            }
        }
    }

    private void actualizarTotales() {
        long pend = pedidos.stream().filter(p -> p.estatus.equals("Pendiente")).count();
        long entr = pedidos.stream().filter(p -> p.estatus.equals("Entregado")).count();
        lblTotales.setText("Total de pedidos: " + pedidos.size()
                + "   |   Pendientes: " + pend
                + "   |   Entregados: " + entr);
    }

    private Pedido pedidoSeleccionado() {
        int fila = tabla.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Selecciona un pedido en la tabla.");
            return null;
        }
        String codigo = (String) modelo.getValueAt(fila, 0);
        for (Pedido p : pedidos) if (p.codigo.equals(codigo)) return p;
        return null;
    }

    private void cambiarEstatus() {
        Pedido p = pedidoSeleccionado();
        if (p == null) return;
        String nuevo = (String) JOptionPane.showInputDialog(this,
                "Nuevo estatus para " + p.codigo + ":", "Cambiar Estatus",
                JOptionPane.QUESTION_MESSAGE, null, ESTATUS, p.estatus);
        if (nuevo != null) {
            p.estatus = nuevo;
            refrescarTabla();
            actualizarTotales();
        }
    }

    private void agregarComentario() {
        Pedido p = pedidoSeleccionado();
        if (p == null) return;
        JTextArea area = new JTextArea(p.comentarios, 5, 30);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        int ok = JOptionPane.showConfirmDialog(this, new JScrollPane(area),
                "Comentarios del pedido " + p.codigo, JOptionPane.OK_CANCEL_OPTION);
        if (ok == JOptionPane.OK_OPTION) {
            p.comentarios = area.getText().trim();
            refrescarTabla();
        }
    }

    private void verDetalle() {
        Pedido p = pedidoSeleccionado();
        if (p == null) return;
        StringBuilder lista = new StringBuilder();
        int totalPiezas = 0;
        for (ItemPedido it : p.productos) {
            lista.append("  - ").append(it.nombre)
                 .append("   x").append(it.cantidad)
                 .append("   (Prioridad: ").append(it.prioridad).append(")\n");
            totalPiezas += it.cantidad;
        }
        String detalle = "CODIGO: " + p.codigo
                + "\nSOLICITA: " + p.persona
                + "\nFECHA: " + p.fecha.format(FORMATO)
                + "\nPRODUCTOS (" + p.productos.size() + "):\n" + lista
                + "TOTAL PIEZAS: " + totalPiezas
                + "\nESTATUS: " + p.estatus
                + "\n\nCOMENTARIOS:\n" + (p.comentarios.isEmpty() ? "(sin comentarios)" : p.comentarios);
        JOptionPane.showMessageDialog(this, detalle, "Detalle del Pedido", JOptionPane.INFORMATION_MESSAGE);
    }

    
    private void nuevoPedido() {
        String codigo = "P-" + String.format("%03d", pedidos.size() + 1);
        String persona = JOptionPane.showInputDialog(this, "Persona que solicita:");
        if (persona == null || persona.trim().isEmpty()) return;

        ArrayList<ItemPedido> productos = new ArrayList<>();
        boolean agregarOtro = true;

        while (agregarOtro) {
           
            String nombre = JOptionPane.showInputDialog(this, "Nombre del producto:");
            if (nombre == null) break; // Cancelar
            if (nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Escribe el nombre del producto.");
                continue;
            }

           
            int cantidad = 1;
            String cantStr = JOptionPane.showInputDialog(this,
                    "Cantidad (piezas) de " + nombre.trim() + ":", "1");
            if (cantStr == null) break;
            try {
                cantidad = Integer.parseInt(cantStr.trim());
                if (cantidad <= 0) cantidad = 1;
            } catch (NumberFormatException e) {
                cantidad = 1;
            }

            
            String prio = (String) JOptionPane.showInputDialog(this,
                    "Prioridad de " + nombre.trim() + ":", "Prioridad",
                    JOptionPane.QUESTION_MESSAGE, null, PRIORIDADES, "Media");
            if (prio == null) prio = "Media";

            productos.add(new ItemPedido(nombre.trim(), cantidad, prio));

           
            int otro = JOptionPane.showConfirmDialog(this,
                    "¿Agregar otro producto al pedido " + codigo + "?",
                    "Producto agregado (" + productos.size() + ")",
                    JOptionPane.YES_NO_OPTION);
            agregarOtro = (otro == JOptionPane.YES_OPTION);
        }

        if (productos.isEmpty()) return; 

        pedidos.add(new Pedido(codigo, persona.trim(), LocalDateTime.now(),
                productos, "Pendiente", "Pedido recien creado."));
        refrescarTabla();
        actualizarTotales();
    }

    
    static class EstatusRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable t, Object v, boolean sel,
                                                       boolean focus, int f, int c) {
            JLabel lbl = (JLabel) super.getTableCellRendererComponent(t, v, sel, focus, f, c);
            lbl.setHorizontalAlignment(SwingConstants.CENTER);
            lbl.setOpaque(true);
            lbl.setFont(lbl.getFont().deriveFont(Font.BOLD));
            Color fondo;
            switch (String.valueOf(v)) {
                case "Entregado":  fondo = new Color(46, 160, 67); break;
                case "Pendiente":  fondo = new Color(217, 119, 6); break;
                case "En Proceso": fondo = new Color(66, 133, 244); break;
                case "Cancelado":  fondo = new Color(200, 60, 60); break;
                default:           fondo = Color.GRAY;
            }
            if (sel) fondo = fondo.darker();
            lbl.setBackground(fondo);
            lbl.setForeground(Color.WHITE);
            return lbl;
        }
    }

   
    static class ComentarioRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable t, Object v, boolean sel,
                                                       boolean focus, int f, int c) {
            JLabel lbl = (JLabel) super.getTableCellRendererComponent(t, v, sel, focus, f, c);
            String texto = String.valueOf(v == null ? "" : v);
            lbl.setText(texto.length() > 35 ? texto.substring(0, 35) + "..." : texto);
            lbl.setToolTipText("<html><p width=\"280\">" + texto + "</p></html>");
            return lbl;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HistorialPedidos().setVisible(true));
    }
}
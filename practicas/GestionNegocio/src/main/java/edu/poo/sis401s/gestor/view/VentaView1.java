/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.poo.sis401s.gestor.view;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.table.JTableHeader;

/**
 *
 * @author lobog
 */
public class VentaView1 extends javax.swing.JFrame {
    private final edu.poo.sis401s.gestor.controller.VentaController controller =
        new edu.poo.sis401s.gestor.controller.VentaController();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentaView1.class.getName());

    /**
     * Creates new form VentaView1
     */
    public VentaView1() {
        initComponents();
        actualizarTabla();
       aplicarEstilo();
        setLocationRelativeTo(null);
    }
private void aplicarEstilo() {
   Color azul = new Color(23, 36, 58);
Color azulSecundario = new Color(38, 59, 86);
Color turquesa = new Color(8, 127, 140);
Color fondo = new Color(23, 36, 58);
Color texto = Color.WHITE;
Color blanco = new Color(38, 59, 86);
    getContentPane().setBackground(fondo);
    setTitle("Registro de Ventas");

    aplicarEstiloComponentes(
        getContentPane(), azul, azulSecundario,
        turquesa, fondo, texto, blanco
    );
}

private void aplicarEstiloComponentes(
        Container contenedor,
        Color azul,
        Color azulSecundario,
        Color turquesa,
        Color fondo,
        Color texto,
        Color blanco) {

    for (Component componente : contenedor.getComponents()) {

        if (componente instanceof JPanel) {
            componente.setBackground(fondo);

        } else if (componente instanceof JLabel) {
            JLabel etiqueta = (JLabel) componente;
            etiqueta.setForeground(texto);

            String titulo = etiqueta.getText();

            if (titulo != null &&
                titulo.toUpperCase().contains("REGISTRO DE VENTAS")) {

                etiqueta.setForeground(Color.WHITE);
                etiqueta.setFont(
                    new Font("SansSerif", Font.BOLD, 28)
                );
            }

        } else if (componente instanceof JTextField) {
            JTextField campo = (JTextField) componente;
            campo.setBackground(blanco);
            campo.setForeground(texto);
            campo.setCaretColor(turquesa);
            campo.setFont(
                new Font("SansSerif", Font.PLAIN, 14)
            );
            campo.setBorder(
                BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(
                        new Color(203, 213, 225)
                    ),
                    BorderFactory.createEmptyBorder(5, 8, 5, 8)
                )
            );

        } else if (componente instanceof JTextArea) {
            JTextArea area = (JTextArea) componente;
            area.setBackground(blanco);
            area.setForeground(texto);
            area.setFont(
                new Font("SansSerif", Font.PLAIN, 13)
            );

        } else if (componente instanceof JButton) {
            JButton boton = (JButton) componente;
            boton.setBackground(turquesa);
            boton.setForeground(azul);
            boton.setFont(
                new Font("SansSerif", Font.BOLD, 12)
            );
            boton.setFocusPainted(false);
            boton.setOpaque(true);
            boton.setBorder(
                BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(turquesa),
                    BorderFactory.createEmptyBorder(8, 12, 8, 12)
                )
            );

        } else if (componente instanceof JScrollPane) {
            componente.setBackground(blanco);
            ((JScrollPane) componente).getViewport()
                .setBackground(blanco);

        } else if (componente instanceof JTable) {
            JTable tabla = (JTable) componente;
            tabla.setBackground(blanco);
            tabla.setForeground(texto);
            tabla.setGridColor(new Color(226, 232, 240));
            tabla.setSelectionBackground(turquesa);
            tabla.setSelectionForeground(azul);
            tabla.setRowHeight(26);
            tabla.setFont(
                new Font("SansSerif", Font.PLAIN, 12)
            );

            JTableHeader encabezado = tabla.getTableHeader();
            encabezado.setBackground(azul);
            encabezado.setForeground(blanco);
            encabezado.setFont(
                new Font("SansSerif", Font.BOLD, 12)
            );
            encabezado.setReorderingAllowed(false);
        }

        if (componente instanceof Container) {
            aplicarEstiloComponentes(
                (Container) componente,
                azul, azulSecundario, turquesa,
                fondo, texto, blanco
            );
        }
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegistrar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblProducto = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        txtPrecioUnitario = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContenido = new javax.swing.JTable();
        lblIngresosTitulo = new javax.swing.JLabel();
        lblVenasRegistradasTitulo = new javax.swing.JLabel();
        lblIngresosValor = new javax.swing.JLabel();
        lblVentasValor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRegistrar.setText("Registrar Venta");
        btnRegistrar.addActionListener(this::btnRegistrarActionPerformed);

        btnConsultar.setText("Consultar Venta");
        btnConsultar.addActionListener(this::btnConsultarActionPerformed);

        btnLimpiar.setText("Limpiar Campos");
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        lblTitulo.setText("REGISTRO DE VENTAS");

        lblProducto.setText("PRODUCTO");

        lblCantidad.setText("CANTIDAD");

        lblPrecio.setText("PRECIO UNITARIO");

        lblFecha.setText("FECHA");

        tblContenido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "PRODUCTO", "CANTIDAD", "PRECIO UNITARIO", "FECHA", "IMPORTE"
            }
        ));
        jScrollPane1.setViewportView(tblContenido);

        jScrollPane2.setViewportView(jScrollPane1);

        lblIngresosTitulo.setText("INGRESOS ACUMULADOS");

        lblVenasRegistradasTitulo.setText("VENTAS REGISTRADAS");

        lblIngresosValor.setText("$0.00");

        lblVentasValor.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblProducto)
                    .addComponent(txtProducto)
                    .addComponent(lblPrecio)
                    .addComponent(txtPrecioUnitario)
                    .addComponent(lblIngresosTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIngresosValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCantidad)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(lblFecha)
                    .addComponent(txtFecha)
                    .addComponent(lblVentasValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblVenasRegistradasTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrar)
                        .addGap(142, 142, 142)
                        .addComponent(btnConsultar)
                        .addGap(107, 107, 107)
                        .addComponent(btnLimpiar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(309, 309, 309)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTitulo)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProducto)
                            .addComponent(lblCantidad))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrecio)
                            .addComponent(lblFecha))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIngresosTitulo)
                            .addComponent(lblVenasRegistradasTitulo))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblIngresosValor, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                            .addComponent(lblVentasValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrar)
                    .addComponent(btnConsultar)
                    .addComponent(btnLimpiar))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        actualizarTabla();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        String producto = txtProducto.getText().trim();
String textoCantidad = txtCantidad.getText().trim();
String textoPrecio = txtPrecioUnitario.getText().trim();
String fecha = txtFecha.getText().trim();

if (producto.isEmpty() || textoCantidad.isEmpty()
        || textoPrecio.isEmpty() || fecha.isEmpty()) {
    javax.swing.JOptionPane.showMessageDialog(this,
            "Completa todos los campos.");
    return;
}

try {
    int cantidad = Integer.parseInt(textoCantidad);
    double precio = Double.parseDouble(textoPrecio);

    if (cantidad <= 0 || precio <= 0) {
        javax.swing.JOptionPane.showMessageDialog(this,
                "La cantidad y el precio deben ser mayores que cero.");
        return;
    }

    edu.poo.sis401s.gestor.model.Venta venta =
            new edu.poo.sis401s.gestor.model.Venta(
                    producto, cantidad, precio, fecha);

    if (controller.registrarVenta(venta)) {
        javax.swing.JOptionPane.showMessageDialog(this,
                "¡Venta registrada correctamente!");

        txtProducto.setText("");
        txtCantidad.setText("");
        txtPrecioUnitario.setText("");
        txtFecha.setText("");

        actualizarTabla();
    } else {
        javax.swing.JOptionPane.showMessageDialog(this,
                "No se pudo registrar la venta.");
    }

} catch (NumberFormatException e) {
    javax.swing.JOptionPane.showMessageDialog(this,
            "Cantidad debe ser un entero y precio debe ser numérico.");
}
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        txtProducto.setText("");
        txtCantidad.setText("");
        txtPrecioUnitario.setText("");
        txtFecha.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed
private void actualizarTabla(){
    javax.swing.table.DefaultTableModel modelo =
            (javax.swing.table.DefaultTableModel) tblContenido.getModel();
    modelo.setRowCount(0);
    java.util.List<edu.poo.sis401s.gestor.model.Venta> ventas =
            controller.buscarTodas();
    double ingresos = 0;
    for(edu.poo.sis401s.gestor.model.Venta venta : ventas){
        double importe = venta.getCantidad()*venta.getPrecio();
        ingresos += importe;
        modelo.addRow(new Object[]{
       venta.getProducto(),
            venta.getCantidad(),
            venta.getPrecio(),
            venta.getFecha(),
            importe});
    }
    lblIngresosValor.setText(String.format("$%.2f", ingresos));
    lblVentasValor.setText(String.valueOf(ventas.size()));
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new VentaView1().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIngresosTitulo;
    private javax.swing.JLabel lblIngresosValor;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVenasRegistradasTitulo;
    private javax.swing.JLabel lblVentasValor;
    private javax.swing.JTable tblContenido;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtPrecioUnitario;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}

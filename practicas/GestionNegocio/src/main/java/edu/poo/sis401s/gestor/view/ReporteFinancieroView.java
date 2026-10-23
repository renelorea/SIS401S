/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.poo.sis401s.gestor.view;
import edu.poo.sis401s.gestor.controller.ReporteFinancieroController;
import edu.poo.sis401s.gestor.model.ReporteFinanciero;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import edu.poo.sis401s.gestor.model.Venta;
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
public class ReporteFinancieroView extends javax.swing.JFrame {
    private final ReporteFinancieroController controlleer = new ReporteFinancieroController();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ReporteFinancieroView.class.getName());

    /**
     * Creates new form ReporteFinancieroView
     */
    public ReporteFinancieroView() {
        initComponents();
        btnActualizarActionPerformed(null);
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

                etiqueta.setForeground(azul);
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

        jLabel1 = new javax.swing.JLabel();
        lblIngresosTitulos = new javax.swing.JLabel();
        lblIngresosValores = new javax.swing.JLabel();
        lblVentasTitulo = new javax.swing.JLabel();
        lblVentasValor = new javax.swing.JLabel();
        lblUnidadesTitulo = new javax.swing.JLabel();
        lblPromedioTitulo = new javax.swing.JLabel();
        lblUnidadesValor = new javax.swing.JLabel();
        lblPromedioValor = new javax.swing.JLabel();
        lblProducto = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLimite = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnConsultarProducto = new javax.swing.JButton();
        btnConsultarFecha = new javax.swing.JButton();
        btnCompararIngresos = new javax.swing.JButton();
        btnVentasSobreLimite = new javax.swing.JButton();
        btnVentasBajoLimite = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        btnProductosDestacados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setText("REPORTE FINANCIERO");

        lblIngresosTitulos.setText("INGRESOS TOTALES");

        lblIngresosValores.setText("$0.00");

        lblVentasTitulo.setText("VENTAS REGISTRADAS");

        lblVentasValor.setText("0");

        lblUnidadesTitulo.setText("UNIDADES VENDIDAS");

        lblPromedioTitulo.setText("PROMEDIO POR VENTA");

        lblUnidadesValor.setText("0");

        lblPromedioValor.setText("$0.00");

        lblProducto.setText("Producto:");

        txtProducto.addActionListener(this::txtProductoActionPerformed);

        jLabel2.setText("Fecha:");

        jLabel3.setText("Limite de importe:");

        btnActualizar.setText("Actualizar reporte");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        btnConsultarProducto.setText("Consultar producto");
        btnConsultarProducto.addActionListener(this::btnConsultarProductoActionPerformed);

        btnConsultarFecha.setText("Consultar fecha");
        btnConsultarFecha.addActionListener(this::btnConsultarFechaActionPerformed);

        btnCompararIngresos.setText("Comparar ingresos");
        btnCompararIngresos.addActionListener(this::btnCompararIngresosActionPerformed);

        btnVentasSobreLimite.setText("Ventas sobre limite");
        btnVentasSobreLimite.addActionListener(this::btnVentasSobreLimiteActionPerformed);

        btnVentasBajoLimite.setText("Ventas bajo limite");
        btnVentasBajoLimite.addActionListener(this::btnVentasBajoLimiteActionPerformed);

        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Producto", "Cantidad", "recio Unitario", "Fecha", "Importe"
            }
        ));
        jScrollPane1.setViewportView(tblResultados);

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane2.setViewportView(txtResultado);

        btnProductosDestacados.setText("Productos destacados");
        btnProductosDestacados.addActionListener(this::btnProductosDestacadosActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblIngresosTitulos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblIngresosValores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblVentasTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblVentasValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblProducto)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(lblUnidadesValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lblUnidadesTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(51, 51, 51)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblPromedioTitulo)
                                                    .addComponent(lblPromedioValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnVentasSobreLimite)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                                .addComponent(btnVentasBajoLimite))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel3)
                                                    .addGap(18, 18, 18)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                                        .addComponent(txtLimite)))
                                                .addComponent(btnConsultarProducto)
                                                .addComponent(btnCompararIngresos)
                                                .addComponent(btnProductosDestacados)
                                                .addComponent(btnActualizar)
                                                .addComponent(btnConsultarFecha)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIngresosTitulos)
                    .addComponent(lblVentasTitulo))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIngresosValores)
                            .addComponent(lblVentasValor))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUnidadesTitulo)
                            .addComponent(lblPromedioTitulo))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblPromedioValor))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblUnidadesValor)))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProducto)
                            .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addComponent(btnActualizar)
                                .addGap(18, 18, 18)
                                .addComponent(btnConsultarFecha)
                                .addGap(14, 14, 14)
                                .addComponent(btnConsultarProducto)
                                .addGap(18, 18, 18)
                                .addComponent(btnCompararIngresos)
                                .addGap(18, 18, 18)
                                .addComponent(btnProductosDestacados))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVentasSobreLimite)
                            .addComponent(btnVentasBajoLimite))))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here
        ReporteFinanciero reporte = controlleer.buscarTodos();

DefaultTableModel modelo =
(DefaultTableModel) tblResultados.getModel();

modelo.setRowCount(0);

double ingresos = reporte.calcularTotal();
int unidades = (int) reporte.calcularUnidades();

for (Venta venta : reporte.getVentas()) {
    double importe = venta.getCantidad() * venta.getPrecio();

    modelo.addRow(new Object[]{
        venta.getProducto(),
        venta.getCantidad(),
        venta.getPrecio(),
        venta.getFecha(),
        importe
    });
}

lblIngresosValores.setText(String.format("$%.2f", ingresos));
lblVentasValor.setText(String.valueOf(reporte.getNumeroVentas()));
lblUnidadesValor.setText(String.valueOf(unidades));
lblPromedioValor.setText(String.format(
"$%.2f", reporte.calcularPromedioVenta()));
 
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnConsultarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarProductoActionPerformed
        // TODO add your handling code here:
        String producto = txtProducto.getText().trim();
        if (producto.isEmpty()|| producto.equals("jTextField1")){
            JOptionPane.showMessageDialog(this, "Escribe el nombre del producto.");
            return;}
        int unidades = controlleer.buscarPorProducto(producto); double ingresos = controlleer.buscarIngresoPorProducto(producto);
if (unidades == 0) { JOptionPane.showMessageDialog(this, "No se encontraron ventas de: " + producto); txtResultado.setText("Sin resultados para el producto: " + producto); return; }
txtResultado.setText( "REPORTE POR PRODUCTO\n\n" + "Producto: " + producto + "\n" + "Unidades vendidas: " + unidades + "\n" + "Ingresos generados: " + String.format("$%.2f", ingresos) );
    }//GEN-LAST:event_btnConsultarProductoActionPerformed

    private void btnConsultarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarFechaActionPerformed
        // TODO add your handling code here:
        String fecha = txtFecha.getText().trim();

if (fecha.isEmpty() || fecha.equals("jTextField1")) {
JOptionPane.showMessageDialog(this,
"Escribe la fecha que deseas consultar.");
return;
}

int cantidad = controlleer.contarVentasPorFecha(fecha);
double ingresos = controlleer.buscarTotalPorFecha(fecha);

txtResultado.setText(
"REPORTE POR FECHA\n\n"
+ "Fecha: " + fecha + "\n"
+ "Ventas registradas: " + cantidad + "\n"
+ "Ingresos del día: " + String.format("$%.2f", ingresos)
);
    }//GEN-LAST:event_btnConsultarFechaActionPerformed

    private void btnProductosDestacadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosDestacadosActionPerformed
        // TODO add your handling code here:
        String masVendido = controlleer.buscarProductoMasVendido();
String mayorIngreso = controlleer.buscarProductoMayorIngreso();
double promedio = controlleer.calcularPromedioVenta();
int sobrePromedio = controlleer.contarVentasSobrePromedio();

txtResultado.setText(
"PRODUCTOS DESTACADOS\n\n"
+ "Producto más vendido: " + masVendido + "\n"
+ "Producto con mayores ingresos: " + mayorIngreso + "\n"
+ "Promedio por venta: " + String.format("$%.2f", promedio) + "\n"
+ "Ventas sobre el promedio: " + sobrePromedio
);
    }//GEN-LAST:event_btnProductosDestacadosActionPerformed

    private void btnVentasSobreLimiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasSobreLimiteActionPerformed
        // TODO add your handling code here:
        String textoLimite = txtLimite.getText().trim();
if (textoLimite.isEmpty() || textoLimite.equals("jTextField1")) { JOptionPane.showMessageDialog(this, "Escribe el importe límite."); return; }
try { double limite = Double.parseDouble(textoLimite);
if (limite < 0) {
    JOptionPane.showMessageDialog(this,
            "El límite no puede ser negativo.");
    return;
}

int cantidad = controlleer.contarVentasSobreProducto(limite);

txtResultado.setText(
        "VENTAS SOBRE EL LÍMITE\n\n"
        + "Importe límite: " + String.format("$%.2f", limite) + "\n"
        + "Cantidad de ventas superiores: " + cantidad
);
} catch (NumberFormatException e) { JOptionPane.showMessageDialog(this, "Escribe un importe numérico válido.");}
    }//GEN-LAST:event_btnVentasSobreLimiteActionPerformed

    private void btnVentasBajoLimiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasBajoLimiteActionPerformed
        // TODO add your handling code here:
        String textoLimite = txtLimite.getText().trim();
if (textoLimite.isEmpty() || textoLimite.equals("jTextField1")) { JOptionPane.showMessageDialog(this, "Escribe el importe límite."); return; }
try { double limite = Double.parseDouble(textoLimite);
if (limite < 0) {
    JOptionPane.showMessageDialog(this,
            "El límite no puede ser negativo.");
    return;
}

int cantidad = controlleer.contarVentasBajoLimite(limite);

txtResultado.setText(
        "VENTAS BAJO EL LÍMITE\n\n"
        + "Importe límite: " + String.format("$%.2f", limite) + "\n"
        + "Cantidad de ventas inferiores: " + cantidad
);
} catch (NumberFormatException e) { JOptionPane.showMessageDialog(this, "Escribe un importe numérico válido."); }
    }//GEN-LAST:event_btnVentasBajoLimiteActionPerformed

    private void btnCompararIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompararIngresosActionPerformed
        // TODO add your handling code here:
        String fechaActual = txtFecha.getText().trim();

if (fechaActual.isEmpty() || fechaActual.equals("jTextField1")) {
    JOptionPane.showMessageDialog(this, "Escribe la fecha actual que deseas comparar.");
    return;
}

String fechaAnterior = JOptionPane.showInputDialog(
    this,
    "Escribe la fecha anterior para comparar los ingresos:"
);

if (fechaAnterior == null || fechaAnterior.trim().isEmpty()) {
    return;
}

fechaAnterior = fechaAnterior.trim();

double ingresoActual = controlleer.buscarTotalPorFecha(fechaActual);
double ingresoAnterior = controlleer.buscarTotalPorFecha(fechaAnterior);

double diferencia = controlleer.compararIngresosPorFecha(
    fechaActual, fechaAnterior
);

double variacion = controlleer.calcularVariacionPorcentualPorFecha(
    fechaActual, fechaAnterior
);

String cambio;

if (diferencia > 0) {
    cambio = "Los ingresos aumentaron.";
} else if (diferencia < 0) {
    cambio = "Los ingresos disminuyeron.";
} else {
    cambio = "Los ingresos se mantuvieron iguales.";
}

txtResultado.setText(
    "COMPARACIÓN DE INGRESOS\n\n"
    + "Fecha actual: " + fechaActual + "\n"
    + "Ingresos actuales: " + String.format("$%.2f", ingresoActual) + "\n\n"
    + "Fecha anterior: " + fechaAnterior + "\n"
    + "Ingresos anteriores: " + String.format("$%.2f", ingresoAnterior) + "\n\n"
    + "Diferencia: " + String.format("$%.2f", diferencia) + "\n"
    + "Variación porcentual: " + String.format("%.2f%%", variacion) + "\n\n"
    + cambio
);
    }//GEN-LAST:event_btnCompararIngresosActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new ReporteFinancieroView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCompararIngresos;
    private javax.swing.JButton btnConsultarFecha;
    private javax.swing.JButton btnConsultarProducto;
    private javax.swing.JButton btnProductosDestacados;
    private javax.swing.JButton btnVentasBajoLimite;
    private javax.swing.JButton btnVentasSobreLimite;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblIngresosTitulos;
    private javax.swing.JLabel lblIngresosValores;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblPromedioTitulo;
    private javax.swing.JLabel lblPromedioValor;
    private javax.swing.JLabel lblUnidadesTitulo;
    private javax.swing.JLabel lblUnidadesValor;
    private javax.swing.JLabel lblVentasTitulo;
    private javax.swing.JLabel lblVentasValor;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtLimite;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}

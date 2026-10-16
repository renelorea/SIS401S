package edu.poo.gestionnegocio.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public final class View {
    private static final Color AVAILABLE_COLOR = new Color(198, 239, 206);
    private static final Color PENDING_COLOR = new Color(255, 235, 156);
    private static final Color UNAVAILABLE_COLOR = new Color(255, 199, 206);
    private static final Color CART_COLOR = new Color(189, 215, 238);
    private final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private JFrame inventoryFrame;
    private JFrame merchandiseFrame;
    private JFrame customerFrame;
    private JFrame purchaseFrame;
    private JTable inventoryTable;
    private JTable supplierTable;
    private JTable customerInventoryTable;
    private JTable cartTable;
    private JTable purchaseTable;
    private DefaultTableModel inventoryModel;
    private DefaultTableModel supplierModel;
    private DefaultTableModel customerInventoryModel;
    private DefaultTableModel cartModel;
    private DefaultTableModel purchaseModel;
    private boolean inventoryMarked;
    private Set<String> pendingProductIds = Set.of();

    public void printTerminalMenu() {
        System.out.println();
        System.out.println("=== Organizador De Pedidos ===");
        System.out.println("1. Pedido de Mercancía de la Tienda");
        System.out.println("2. Pedido Para Cliente");
        System.out.println("3. Salir");
        System.out.print("Selecciona una opción: ");
    }

    public String readTerminalChoice(Scanner scanner) {
        return scanner.nextLine();
    }

    public void printTerminalMessage(String message) {
        System.out.println(message);
    }

    public void showInventoryWindow(Runnable placeOrder, Runnable mark, Runnable unmark, Runnable back) {
        inventoryFrame = createFrame("Pedido De Mercancia - Inventario");
        inventoryModel = createProductModel();
        inventoryTable = new JTable(inventoryModel);
        inventoryTable.setFillsViewportHeight(true);
        inventoryTable.setDefaultRenderer(Object.class, new ProductRenderer());
        JPanel buttons = buttonPanel(
                button("Realizar Pedido", placeOrder),
                button("Marcar Productos", mark),
                button("Desmarcar", unmark),
                button("Atrás", back));
        inventoryFrame.add(new JScrollPane(inventoryTable), BorderLayout.CENTER);
        inventoryFrame.add(buttons, BorderLayout.SOUTH);
        inventoryFrame.setVisible(true);
    }

    public void updateInventory(List<Product> products, List<String> pendingIds) {
        pendingProductIds = new HashSet<>(pendingIds);
        if (inventoryModel == null) {
            return;
        }
        inventoryModel.setRowCount(0);
        for (Product product : products) {
            inventoryModel.addRow(new Object[]{
                    product.getName(), product.getId(), currency.format(product.getPrice()),
                    product.getQuantity()
            });
        }
        inventoryTable.repaint();
    }

    public void setInventoryMarked(boolean marked, List<String> pendingIds) {
        inventoryMarked = marked;
        pendingProductIds = new HashSet<>(pendingIds);
        if (inventoryTable != null) {
            inventoryTable.repaint();
        }
    }

    public void showMerchandiseOrderWindow(Runnable addRow, Runnable delete, Runnable confirm) {
        merchandiseFrame = createFrame("Realizar Pedido De Mercancia");
        if (inventoryFrame != null) {
            inventoryFrame.setEnabled(false);
        }
        supplierModel = new DefaultTableModel(new Object[]{"Product Name", "ID", "Quantity"}, 0);
        supplierTable = new JTable(supplierModel);
        supplierTable.setFillsViewportHeight(true);
        JPanel buttons = buttonPanel(
                button("Añadir Fila", addRow),
                button("Eliminar Fila", delete),
                button("Confirmar Pedido", confirm));
        merchandiseFrame.add(new JLabel("Ingresa el nombre del producto, ID y cantidad directamente en la tabla.",
                SwingConstants.CENTER), BorderLayout.NORTH);
        merchandiseFrame.add(new JScrollPane(supplierTable), BorderLayout.CENTER);
        merchandiseFrame.add(buttons, BorderLayout.SOUTH);
        merchandiseFrame.setVisible(true);
        addSupplierRow();
    }

    public void addSupplierRow() {
        supplierModel.addRow(new Object[]{"", "", ""});
        int row = supplierModel.getRowCount() - 1;
        supplierTable.setRowSelectionInterval(row, row);
    }

    public int[] getSelectedSupplierRows() {
        return supplierTable.getSelectedRows();
    }

    public List<String[]> getSupplierRows() {
        List<String[]> rows = new ArrayList<>();
        for (int row = 0; row < supplierModel.getRowCount(); row++) {
            rows.add(new String[]{
                    stringValue(supplierModel.getValueAt(row, 0)),
                    stringValue(supplierModel.getValueAt(row, 1)),
                    stringValue(supplierModel.getValueAt(row, 2))
            });
        }
        return rows;
    }

    public void deleteSupplierRows(int[] rows) {
        for (int index = rows.length - 1; index >= 0; index--) {
            supplierModel.removeRow(rows[index]);
        }
    }

    public void closeMerchandiseOrderWindow() {
        close(merchandiseFrame);
        merchandiseFrame = null;
        supplierModel = null;
        supplierTable = null;
        if (inventoryFrame != null) {
            inventoryFrame.setEnabled(true);
        }
    }

    public void showCustomerWindow(List<Product> products, List<OrderLine> cart,
                                   Runnable start, Runnable add, Runnable specify, Runnable back) {
        customerFrame = createFrame("Pedido Para Cliente");
        customerInventoryModel = createProductModel();
        customerInventoryTable = new JTable(customerInventoryModel);
        customerInventoryTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        customerInventoryTable.setFillsViewportHeight(true);
        cartModel = new DefaultTableModel(new Object[]{"Nombre del Producto", "ID", "Cantidad", "Precio"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        cartTable = new JTable(cartModel);
        cartTable.setFillsViewportHeight(true);
        cartTable.setDefaultRenderer(Object.class, new CartRenderer());
        JPanel split = new JPanel(new GridLayout(1, 2, 8, 0));
        split.add(section("Inventario de la Tienda", customerInventoryTable));
        split.add(section("Seleccionar Productos", cartTable));
        JButton startButton = button("Realizar Pedido", start);
        customerFrame.add(split, BorderLayout.CENTER);
        customerFrame.add(buttonPanel(startButton, button("Añadir al Carrito", add),
                button("Especificar Pedido", specify), button("Volver", back)), BorderLayout.SOUTH);
        customerFrame.setMinimumSize(new Dimension(760, 430));
        updateCustomerWindow(products, cart);
        customerInventoryTable.setEnabled(false);
        customerFrame.setVisible(true);
    }

    public void updateCustomerWindow(List<Product> products, List<OrderLine> cart) {
        if (customerInventoryModel != null) {
            customerInventoryModel.setRowCount(0);
            for (Product product : products) {
                if (product.getQuantity() == 0) {
                    continue;
                }
                customerInventoryModel.addRow(new Object[]{
                        product.getName(), product.getId(), currency.format(product.getPrice()),
                        product.getQuantity()
                });
            }
        }
        if (cartModel != null) {
            cartModel.setRowCount(0);
            for (OrderLine line : cart) {
                cartModel.addRow(new Object[]{line.getProductName(), line.getProductId(),
                        line.getQuantity(), currency.format(line.getUnitPrice())});
            }
        }
    }

    public void setCustomerSelectionEnabled(boolean enabled) {
        if (customerInventoryTable != null) {
            customerInventoryTable.setEnabled(enabled);
            if (enabled) {
                customerInventoryTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            }
        }
    }

    public int[] getSelectedInventoryRows() {
        return customerInventoryTable.getSelectedRows();
    }

    public int getSelectedCartRow() {
        return purchaseTable == null ? -1 : purchaseTable.getSelectedRow();
    }

    public int[] getSelectedCartRows() {
        return purchaseTable == null ? new int[0] : purchaseTable.getSelectedRows();
    }

    public void showPurchaseWindow(List<OrderLine> lines, Runnable change, Runnable remove,
                                   Runnable confirm, Runnable returnToCart) {
        purchaseFrame = createFrame("Especificar Pedido");
        if (customerFrame != null) {
            customerFrame.setEnabled(false);
        }
        purchaseModel = new DefaultTableModel(
                new Object[]{"Nombre del Producto", "ID", "Cantidad", "Precio"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        purchaseTable = new JTable(purchaseModel);
        purchaseTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        purchaseTable.setFillsViewportHeight(true);
        purchaseFrame.add(new JScrollPane(purchaseTable), BorderLayout.CENTER);
        purchaseFrame.add(buttonPanel(button("Cambiar Cantidad", change),
                button("Quitar Producto", remove), button("Confirmar Compra", confirm),
                button("Volver", returnToCart)), BorderLayout.SOUTH);
        updatePurchaseWindow(lines);
        purchaseFrame.setVisible(true);
    }

    public void updatePurchaseWindow(List<OrderLine> lines) {
        if (purchaseModel == null) {
            return;
        }
        purchaseModel.setRowCount(0);
        for (OrderLine line : lines) {
            purchaseModel.addRow(new Object[]{line.getProductName(), line.getProductId(),
                    line.getQuantity(), currency.format(line.getUnitPrice())});
        }
    }

    public String promptQuantity(String productName, int currentQuantity) {
        Object answer = JOptionPane.showInputDialog(purchaseFrame,
                "Quantity for " + productName + ":", "Cambiar Cantidad",
                JOptionPane.PLAIN_MESSAGE, null, null, Integer.toString(currentQuantity));
        return answer == null ? null : answer.toString();
    }

    public void closePurchaseWindow() {
        close(purchaseFrame);
        purchaseFrame = null;
        purchaseModel = null;
        purchaseTable = null;
        if (customerFrame != null) {
            customerFrame.setEnabled(true);
        }
    }

    public void closeAllWindows() {
        closePurchaseWindow();
        closeMerchandiseOrderWindow();
        close(customerFrame);
        close(inventoryFrame);
        customerFrame = null;
        inventoryFrame = null;
        customerInventoryTable = null;
        customerInventoryModel = null;
        cartTable = null;
        cartModel = null;
    }

    public void showInformation(String message) {
        JOptionPane.showMessageDialog(currentFrame(), message, "Store Orders",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(currentFrame(), message, "Invalid Order",
                JOptionPane.ERROR_MESSAGE);
    }

    private DefaultTableModel createProductModel() {
        return new DefaultTableModel(
                new Object[]{"Nombre del Producto", "ID", "Precio", "Cantidad Disponible"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    private JFrame currentFrame() {
        if (purchaseFrame != null) {
            return purchaseFrame;
        }
        if (merchandiseFrame != null) {
            return merchandiseFrame;
        }
        return customerFrame != null ? customerFrame : inventoryFrame;
    }

    private static JFrame createFrame(String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(700, 390);
        frame.setLocationByPlatform(true);
        frame.setLayout(new BorderLayout(8, 8));
        return frame;
    }

    private static JPanel section(String title, JTable table) {
        JPanel panel = new JPanel(new BorderLayout(0, 6));
        panel.setBorder(BorderFactory.createTitledBorder(title));
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

    private static JPanel buttonPanel(JButton... buttons) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        for (JButton button : buttons) {
            panel.add(button);
        }
        return panel;
    }

    private static JButton button(String label, Runnable action) {
        JButton button = new JButton(label);
        button.addActionListener(event -> action.run());
        return button;
    }

    private static String stringValue(Object value) {
        return value == null ? "" : value.toString();
    }

    private static void close(JFrame frame) {
        if (frame != null) {
            frame.dispose();
        }
    }

    private final class ProductRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected,
                                                       boolean focused, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            if (!selected && inventoryMarked) {
                String id = stringValue(table.getValueAt(row, 1));
                int quantity = Integer.parseInt(stringValue(table.getValueAt(row, 3)));
                if (quantity > 0) {
                    cell.setBackground(AVAILABLE_COLOR);
                } else if (pendingProductIds.contains(id)) {
                    cell.setBackground(PENDING_COLOR);
                } else {
                    cell.setBackground(UNAVAILABLE_COLOR);
                }
            } else if (!selected) {
                cell.setBackground(table.getBackground());
            }
            return cell;
        }
    }

    private static final class CartRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected,
                                                       boolean focused, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            if (!selected) {
                cell.setBackground(CART_COLOR);
            }
            return cell;
        }
    }
}


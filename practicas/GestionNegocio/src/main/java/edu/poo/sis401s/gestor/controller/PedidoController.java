package edu.poo.sis401s.gestor.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class Controller {
    private final Service service;
    private final View view;
    private final Map<String, OrderLine> cart = new LinkedHashMap<>();
    private Runnable returnToTerminal;
    private boolean purchaseConfirmed;

    public Controller(Service service, View view) {
        this.service = service;
        this.view = view;
    }

    public void openMerchandiseScreen(Runnable onBack) {
        returnToTerminal = onBack;
        view.showInventoryWindow(this::openSupplierOrder, this::markProducts,
                this::unmarkProducts, this::backToTerminal);
        refreshInventory();
    }

    public void openCustomerScreen(Runnable onBack) {
        returnToTerminal = onBack;
        cart.clear();
        purchaseConfirmed = false;
        view.showCustomerWindow(service.getProducts(), List.of(), this::startSelecting,
                this::addSelectedProducts, this::openPurchaseWindow, this::backToTerminal);
    }

    private void openSupplierOrder() {
        view.showMerchandiseOrderWindow(this::addSupplierRow, this::deleteSupplierRows,
                this::confirmSupplierOrder);
    }

    private void addSupplierRow() {
        view.addSupplierRow();
    }

    private void deleteSupplierRows() {
        int[] rows = view.getSelectedSupplierRows();
        if (rows.length == 0) {
            view.showError("Selecciona una o mas filas para eliminar.");
            return;
        }
        view.deleteSupplierRows(rows);
    }

    private void confirmSupplierOrder() {
        try {
            List<OrderLine> lines = new ArrayList<>();
            for (String[] row : view.getSupplierRows()) {
                if (isBlank(row)) {
                    continue;
                }
                int quantity;
                try {
                    quantity = Integer.parseInt(row[2].trim());
                } catch (NumberFormatException exception) {
                    throw new IllegalArgumentException("La cantidad debe de ser un número entero positivo.");
                }
                lines.add(new OrderLine(row[1].trim(), row[0].trim(), quantity, BigDecimal.ZERO));
            }
            service.placeSupplierOrder(lines);
            view.showInformation("Order placed successfully");
            refreshInventory();
            view.closeMerchandiseOrderWindow();
        } catch (IllegalArgumentException exception) {
            view.showError(exception.getMessage());
        }
    }

    private void markProducts() {
        view.setInventoryMarked(true, pendingOrderIds());
    }

    private void unmarkProducts() {
        view.setInventoryMarked(false, pendingOrderIds());
    }

    private List<String> pendingOrderIds() {
        return service.getProducts().stream().filter(product -> service.hasPendingOrder(product.getId()))
                .map(Product::getId).toList();
    }

    private void refreshInventory() {
        view.updateInventory(service.getProducts(), pendingOrderIds());
    }

    private void startSelecting() {
        view.setCustomerSelectionEnabled(true);
    }

    private void addSelectedProducts() {
        int[] selectedRows = view.getSelectedInventoryRows();
        if (selectedRows.length == 0) {
            view.showError("Selecciona una o mas filas primero.");
            return;
        }
        List<Product> products = service.getProducts().stream()
                .filter(product -> product.getQuantity() > 0).toList();
        Map<String, Integer> requestedQuantities = new LinkedHashMap<>();
        try {
            for (int row : selectedRows) {
                Product product = products.get(row);
                OrderLine existing = cart.get(product.getId());
                int currentQuantity = requestedQuantities.getOrDefault(product.getId(),
                        existing == null ? 0 : existing.getQuantity());
                int newQuantity = currentQuantity + 1;
                service.createCustomerLine(product.getId(), newQuantity);
                requestedQuantities.put(product.getId(), newQuantity);
            }
            for (Map.Entry<String, Integer> entry : requestedQuantities.entrySet()) {
                OrderLine existing = cart.get(entry.getKey());
                if (existing == null) {
                    cart.put(entry.getKey(), service.createCustomerLine(entry.getKey(), entry.getValue()));
                } else {
                    service.changeCustomerQuantity(existing, entry.getValue());
                }
            }
            purchaseConfirmed = false;
            refreshCustomerWindow();
        } catch (IllegalArgumentException exception) {
            view.showError(exception.getMessage());
        }
    }

    private void openPurchaseWindow() {
        if (cart.isEmpty()) {
            view.showError("Agrega al menos un producto al carrito antes de continuar.");
            return;
        }
        purchaseConfirmed = false;
        view.showPurchaseWindow(copyCart(), this::changeCustomerQuantity,
                this::removeCustomerProducts, this::confirmPurchase, this::returnFromPurchase);
    }

    private void changeCustomerQuantity() {
        int row = view.getSelectedCartRow();
        if (row < 0) {
            view.showError("Selecciona un producto para cambiar su cantidad.");
            return;
        }
        OrderLine line = cart.values().stream().toList().get(row);
        String quantityText = view.promptQuantity(line.getProductName(), line.getQuantity());
        if (quantityText == null) {
            return;
        }
        try {
            int quantity = Integer.parseInt(quantityText.trim());
            service.changeCustomerQuantity(line, quantity);
            purchaseConfirmed = false;
            refreshPurchaseWindow();
        } catch (NumberFormatException exception) {
            view.showError("La cantidad debe de ser un número entero positivo.");
        } catch (IllegalArgumentException exception) {
            view.showError(exception.getMessage());
        }
    }

    private void removeCustomerProducts() {
        int[] rows = view.getSelectedCartRows();
        if (rows.length == 0) {
            view.showError("Selecciona uno o más productos para eliminar.");
            return;
        }
        List<String> ids = cart.keySet().stream().toList();
        for (int index : rows) {
            cart.remove(ids.get(index));
        }
        purchaseConfirmed = false;
        refreshPurchaseWindow();
        if (cart.isEmpty()) {
            view.closePurchaseWindow();
        }
    }

    private void confirmPurchase() {
        try {
            BigDecimal total = service.calculateTotal(cart.values());
            purchaseConfirmed = true;
            view.showInformation("Compra completada; el total a pagar es: "
                    + total.setScale(2, java.math.RoundingMode.HALF_UP).toPlainString());
        } catch (IllegalArgumentException exception) {
            view.showError(exception.getMessage());
        }
    }

    private void returnFromPurchase() {
        if (purchaseConfirmed) {
            try {
                service.completeCustomerPurchase(cart.values());
                refreshInventory();
            } catch (IllegalArgumentException exception) {
                view.showError(exception.getMessage());
                return;
            }
        }
        cart.clear();
        purchaseConfirmed = false;
        view.closePurchaseWindow();
        refreshCustomerWindow();
    }

    private void backToTerminal() {
        cart.clear();
        view.closeAllWindows();
        if (returnToTerminal != null) {
            returnToTerminal.run();
        }
    }

    private void refreshCustomerWindow() {
        view.updateCustomerWindow(service.getProducts(), copyCart());
    }

    private void refreshPurchaseWindow() {
        view.updatePurchaseWindow(copyCart());
    }

    private List<OrderLine> copyCart() {
        return cart.values().stream()
                .map(line -> new OrderLine(line.getProductId(), line.getProductName(),
                        line.getQuantity(), line.getUnitPrice()))
                .toList();
    }

    private static boolean isBlank(String[] row) {
        return row[0].isBlank() && row[1].isBlank() && row[2].isBlank();
    }
}

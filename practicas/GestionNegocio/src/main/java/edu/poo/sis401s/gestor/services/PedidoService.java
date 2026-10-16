package edu.poo.sis401s.gestor.services;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public final class Service {
    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public boolean hasPendingOrder(String productId) {
        return repository.hasPendingOrder(productId);
    }

    public void placeSupplierOrder(List<OrderLine> lines) {
        requireNonEmpty(lines, "Add at least one product to the order.");
        for (OrderLine line : lines) {
            Product product = repository.findById(line.getProductId())
                    .orElseThrow(() -> new IllegalArgumentException(
                            "No product has ID " + line.getProductId() + "."));
            if (!product.getName().equalsIgnoreCase(line.getProductName().trim())) {
                throw new IllegalArgumentException(
                        "Product name does not match ID " + line.getProductId() + ".");
            }
            requirePositive(line.getQuantity());
        }
        repository.recordSupplierOrder(lines);
    }

    public Product getProduct(String productId) {
        return repository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Unknown product ID: " + productId));
    }

    public OrderLine createCustomerLine(String productId, int quantity) {
        Product product = getProduct(productId);
        validateAvailableQuantity(product, quantity);
        return new OrderLine(product.getId(), product.getName(), quantity, product.getPrice());
    }

    public void changeCustomerQuantity(OrderLine line, int quantity) {
        Product product = getProduct(line.getProductId());
        validateAvailableQuantity(product, quantity);
        line.setQuantity(quantity);
    }

    public BigDecimal calculateTotal(Collection<OrderLine> lines) {
        requireNonEmpty(lines, "Carrito Vacio.");
        BigDecimal total = BigDecimal.ZERO;
        for (OrderLine line : lines) {
            Product product = getProduct(line.getProductId());
            validateAvailableQuantity(product, line.getQuantity());
            total = total.add(product.getPrice().multiply(BigDecimal.valueOf(line.getQuantity())));
        }
        return total;
    }

    public void completeCustomerPurchase(Collection<OrderLine> lines) {
        calculateTotal(lines);
        repository.deductStock(lines);
    }

    private static void validateAvailableQuantity(Product product, int quantity) {
        requirePositive(quantity);
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Only " + product.getQuantity()
                    + " unit(s) of " + product.getName() + " are available.");
        }
    }

    private static void requirePositive(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser un numero entero positivo.");
        }
    }

    private static void requireNonEmpty(Collection<?> values, String message) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }
}

package edu.poo.sis401s.gestor.repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public final class Repository {
    private final Map<String, Product> products = new LinkedHashMap<>();
    private final Set<String> orderedProductIds = new LinkedHashSet<>();

    public Repository() {
        add(new Product("P100", "Cerveza", new BigDecimal("2.50"), 20));
        add(new Product("P101", "Agua", new BigDecimal("1.25"), 12));
        add(new Product("P102", "Soda", new BigDecimal("29.99"), 0));
        add(new Product("P103", "Frituras", new BigDecimal("18.50"), 5));
        add(new Product("P104", "Jugo", new BigDecimal("8.99"), 0));
    }

    public List<Product> findAll() {
        return List.copyOf(products.values());
    }

    public Optional<Product> findById(String id) {
        return Optional.ofNullable(products.get(id));
    }

    public boolean hasPendingOrder(String productId) {
        return orderedProductIds.contains(productId);
    }

    public void recordSupplierOrder(Collection<OrderLine> lines) {
        for (OrderLine line : lines) {
            orderedProductIds.add(line.getProductId());
        }
    }

    public void deductStock(Collection<OrderLine> lines) {
        for (OrderLine line : lines) {
            Product product = products.get(line.getProductId());
            product.setQuantity(product.getQuantity() - line.getQuantity());
        }
    }

    private void add(Product product) {
        products.put(product.getId(), product);
    }
}

package edu.poo.sis401s.gestor.repository;

import edu.poo.sis401s.gestor.model.PedidoOrderLine;
import edu.poo.sis401s.gestor.model.PedidoYProducto;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public final class PedidoRepository {
    private final Map<String, PedidoYProducto> products = new LinkedHashMap<>();
    private final Set<String> orderedProductIds = new LinkedHashSet<>();

    public PedidoRepository() {
        add(new PedidoYProducto("P100", "Cerveza", new BigDecimal("2.50"), 20));
        add(new PedidoYProducto("P101", "Agua", new BigDecimal("1.25"), 12));
        add(new PedidoYProducto("P102", "Soda", new BigDecimal("29.99"), 0));
        add(new PedidoYProducto("P103", "Frituras", new BigDecimal("18.50"), 5));
        add(new PedidoYProducto("P104", "Jugo", new BigDecimal("8.99"), 0));
    }

    public List<PedidoYProducto> findAll() {
        return List.copyOf(products.values());
    }

    public Optional<PedidoYProducto> findById(String id) {
        return Optional.ofNullable(products.get(id));
    }

    public boolean hasPendingOrder(String productId) {
        return orderedProductIds.contains(productId);
    }

    public void recordSupplierOrder(Collection<PedidoOrderLine> lines) {
        for (PedidoOrderLine line : lines) {
            orderedProductIds.add(line.getProductId());
        }
    }

    public void deductStock(Collection<PedidoOrderLine> lines) {
        for (PedidoOrderLine line : lines) {
            PedidoYProducto product = products.get(line.getProductId());
            //product.setQuantity(product.getQuantity() - line.getQuantity());
        }
    }

    private void add(PedidoYProducto product) {
        products.put(product.getId(), product);
    }
}

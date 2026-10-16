package edu.poo.sis401s.gestor.services;

import java.math.BigDecimal;
import java.util.Objects;

public final class OrderLine {
    private final String productId;
    private final String productName;
    private final BigDecimal unitPrice;
    private int quantity;

    public OrderLine(String productId, String productName, int quantity, BigDecimal unitPrice) {
        this.productId = Objects.requireNonNull(productId);
        this.productName = Objects.requireNonNull(productName);
        this.unitPrice = Objects.requireNonNull(unitPrice);
        setQuantity(quantity);
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public BigDecimal getLineTotal() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero.");
        }
        this.quantity = quantity;
    }
}

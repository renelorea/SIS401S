package edu.poo.sis401s.gestor.services;

import java.math.BigDecimal;
import java.util.Objects;

public final class Product {
    private final String id;
    private final String name;
    private final BigDecimal price;
    private int quantity;

    public Product(String id, String name, BigDecimal price, int quantity) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.price = Objects.requireNonNull(price);
        if (quantity < 0) {
            throw new IllegalArgumentException("La cantidad no debe de ser nula o negativa.");
        }
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("La cantidad no debe de ser nula o negativa.");
        }
        this.quantity = quantity;
    }
}

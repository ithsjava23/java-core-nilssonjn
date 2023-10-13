package org.example.warehouse;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductRecord {

    private final UUID uuid;
    private final String name;
    private BigDecimal price;
    private final Category category;

    public ProductRecord(UUID uuid, String name, BigDecimal price, Category category) {
        this.name = name;
        this.price = price;
        this.uuid = uuid;
        this.category = category;

    }

    public Category category() {
        return this.category;
    }

    public BigDecimal price() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public UUID uuid() {
        return this.uuid;
    }
}
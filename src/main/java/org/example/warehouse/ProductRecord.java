package org.example.warehouse;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductRecord {

    UUID uuid;
    String name;
    BigDecimal price;
    Category category;
    boolean changed;

    public ProductRecord(UUID uuid, String name, BigDecimal price, Category category) {
        this.name = name;
        this.price = price;
        this.uuid = uuid;
        this.category = category;

    }

    public Category getCategory() {
        return this.category;
    }

    public Category add(Category meat) {
        return this.category;
    }

    public UUID productUUID() {
        return this.productUUID();
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

    public UUID getUUID() {
        return this.uuid;
    }

    public boolean isChanged() {
        return changed;
    }

    public UUID markAsChanged() {
        return this.uuid;
    }

    public UUID uuid() {
        return this.uuid;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getProductPrice() {
        return price;
    }
}

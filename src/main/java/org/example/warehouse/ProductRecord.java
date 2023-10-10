package org.example.warehouse;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductRecord {

    UUID productUUID;
    String productName;
    BigDecimal productPrice;
    Category productCategory;
    boolean changed;

    public ProductRecord(UUID productUUID, String productName, BigDecimal productPrice, Category productCategory) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productUUID = productUUID;
        this.productCategory = productCategory;

    }

    public Category add(Category meat) {
        return this.productCategory;
    }

    public UUID productUUID() {
        return this.productUUID();
    }

    public Category category() {
        return this.productCategory;
    }

    public BigDecimal price() {
        return this.productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public UUID getUUID() {
        return this.productUUID;
    }

    public boolean isChanged() {
        return changed;
    }

    public UUID markAsChanged() {
        return this.productUUID;
    }

    public UUID uuid() {
        return this.productUUID;
    }
}

package org.example.warehouse;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductRecord {

    UUID productUUID;
    String productName;
    BigDecimal productPrice;
    Category productCategory;

    public ProductRecord(UUID productUUID, String productName, BigDecimal productPrice, Category productCategory) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productUUID = productUUID;
        this.productCategory = productCategory;

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
}

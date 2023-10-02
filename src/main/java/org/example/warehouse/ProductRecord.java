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

    public Object uuid() {
        return null;
    }

    public Category category() {
        return null;
    }

    public boolean price() {
        return false;
    }

}

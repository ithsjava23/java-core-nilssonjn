package org.example.warehouse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Warehouse {
    List<ProductRecord> listWithProducts = new ArrayList<>();


    public static Warehouse getInstance() {
        return null;
    }

    public static Warehouse getInstance(String myStore) {
        return null;
    }

    public ProductRecord addProduct(UUID id, String name, Category category, BigDecimal price) {
        ProductRecord newItem = new ProductRecord(id, name, price, category);
        listWithProducts.add(newItem);
        return newItem;
    }

    public boolean isEmpty() {
        return false;
    }

    public List<ProductRecord> getProducts() {
        return List.copyOf(this.listWithProducts);
    }
    public Optional<ProductRecord> getProductById(UUID productUUID) {
        return null;

    }

    public void updateProductPrice(UUID productUUID, BigDecimal productPrice) {
    }

    public boolean getChangedProducts() {
        return false;
    }

    public boolean getProductsGroupedByCategories() {
        return false;
    }

    public boolean getProductsBy(Category meat) {
        return false;
    }
}

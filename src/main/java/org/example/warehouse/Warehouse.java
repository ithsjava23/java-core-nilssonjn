package org.example.warehouse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Warehouse {
    List<ProductRecord> listOfProducts = new ArrayList<>();



    public static Warehouse getInstance() {
        return null;
    }

    public static Warehouse getInstance(String myStore) {
        return null;
    }

    public ProductRecord addProduct(UUID id, String name, Category category, BigDecimal price) {
        ProductRecord newItem = new ProductRecord(id, name, price, category);
        listOfProducts.add(newItem);
        return newItem;
    }

    public boolean isEmpty() {
        return false;

    }

    public boolean getProducts() {
        return isEmpty();

    }

    public boolean getProductById(Object uuid) {
        return false;

    }

    public void updateProductPrice(Object uuid, BigDecimal bigDecimal) {
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

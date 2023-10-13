package org.example.warehouse;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Warehouse {
    private String name;
    private List<ProductRecord> listWithProducts = new ArrayList<>();
    private static final List<ProductRecord> changedProducts = new ArrayList<>();

    private Warehouse(String name) {
        this.name = name;
        this.listWithProducts = new ArrayList<>();
    }

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return new Warehouse();
    }

    public static Warehouse getInstance(String name) {
        return new Warehouse(name);
    }

    public ProductRecord addProduct(UUID uuid, String productName, Category category, BigDecimal price) {
        if (productName == null || productName.isEmpty())
            throw new IllegalArgumentException("Product name can't be null or empty.");
        if (category == null)
            throw new IllegalArgumentException("Category can't be null.");
        if (listWithProducts.stream().anyMatch(newItem -> newItem.uuid().equals(uuid)))
            throw new IllegalArgumentException("Product with that id already exists, use updateProduct for updates.");
        if (price == null) {
            price = BigDecimal.ZERO;
        }
        UUID newId = (uuid == null) ? UUID.randomUUID() : uuid;
        ProductRecord newItem = new ProductRecord(newId, productName, price, category);
        listWithProducts.add(newItem);
        return newItem;
    }

    public boolean isEmpty() {
        return listWithProducts.isEmpty();
    }

    public List<ProductRecord> getProducts() {
        return List.copyOf(this.listWithProducts);
    }

    public Optional<ProductRecord> getProductById(UUID uuid) {
        return listWithProducts.stream()
                .filter(product -> product.uuid().equals(uuid))
                .findFirst();
    }
    public void updateProductPrice(UUID uuid, BigDecimal price) {
        getProductById(uuid)
                .map(product -> {
                    product.setPrice(price);
                    changedProducts.add(product);
                    return product;
                })
                .orElseThrow(() -> new IllegalArgumentException("Product with that id doesn't exist."));
    }

    public List<ProductRecord> getChangedProducts() {
        return List.copyOf(changedProducts);
    }

    public Map<Category, List<ProductRecord>> getProductsGroupedByCategories() {
        return listWithProducts.stream()
                .collect(Collectors.groupingBy(ProductRecord::category));
    }

    public List<ProductRecord> getProductsBy(Category category) {
        return listWithProducts.stream()
                .filter(product -> product.category().equals(category))
                .collect(Collectors.toList());
    }
}

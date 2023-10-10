package org.example.warehouse;

import java.beans.beancontext.BeanContextServiceProviderBeanInfo;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Warehouse {
    private final String name;
    private final List<ProductRecord> listWithProducts = new ArrayList<>();
    private final List<ProductRecord> changedProducts = new ArrayList<>();

    private Warehouse(String name) {
        this.name = name;
    }

    public static Warehouse getInstance() {
        return new Warehouse("Default");
    }

    public static Warehouse getInstance(String name) {
        return new Warehouse(name);
    }

    public ProductRecord addProduct(UUID productUUID, String productName, Category productCategory, BigDecimal productPrice) {
        if (productName == null || productName.isEmpty())
            throw new IllegalArgumentException("Product name can't be null or empty.");
        if (productCategory == null)
            throw new IllegalArgumentException("Category can't be null.");
        if (listWithProducts.stream().anyMatch(newItem -> newItem.getUUID().equals(productUUID)))
            throw new IllegalArgumentException("Product with that id already exists, use updateProduct for updates.");
        if (productPrice == null) {
            productPrice = BigDecimal.ZERO;
        }
        UUID newId = (productUUID == null) ? UUID.randomUUID() : productUUID;
        ProductRecord newItem = new ProductRecord(newId, productName, productPrice, productCategory);
        listWithProducts.add(newItem);
        return newItem;
    }

    public boolean isEmpty() {
        return listWithProducts.isEmpty();
    }

    public List<ProductRecord> getProducts() {
        return List.copyOf(this.listWithProducts);
    }

    public Optional<ProductRecord> getProductById(UUID productUUID) {
        return listWithProducts.stream()
                .filter(product -> product.getUUID().equals(productUUID))
                .findFirst();
//        for (ProductRecord meat : listWithProducts) {
//            if (meat.getUUID().equals(productUUID))
//                return Optional.of(meat);
//        }
        //return Optional.empty();
    }


    public void updateProductPrice(UUID productUUID, BigDecimal productPrice) {
        Optional<ProductRecord> optionalProduct = getProductById(productUUID);

        optionalProduct.ifPresent(product -> {
            product.setPrice(productPrice);
            changedProducts.add(product);
        });
        if (optionalProduct.isEmpty())
            throw new IllegalArgumentException("Product with that id doesn't exist.");
    }


//        ProductRecord productToUpdate = listWithProducts.stream()
//                .filter(product -> product.getUUID().equals(productUUID))
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("Product with that id doesn't exist."));
//        productToUpdate.setProductPrice(productPrice);
//        if (!changedProducts.contains(productToUpdate)) {
//            changedProducts.add(productToUpdate);
//        }


    public List<ProductRecord> getChangedProducts() {
        return List.copyOf(changedProducts);
    }

    public Map<Category, List<ProductRecord>> getProductsGroupedByCategories() {
        return listWithProducts.stream()
                .collect(Collectors.groupingBy(ProductRecord::getCategory));
    }

    public List<ProductRecord> getProductsBy(Category meat) {
        if (meat == null) {
            throw new IllegalArgumentException("Category can't be null.");
        }
//        for (ProductRecord productRecord : listWithProducts) {
//            if (productRecord.productCategory.equals(meat)) productRecord.add(meat);
//        }
        return listWithProducts.stream()
                .filter(product -> product.getCategory().equals(meat))
                .collect(Collectors.toList());
    }
}

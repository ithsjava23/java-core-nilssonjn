package org.example.warehouse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Warehouse {
    List<ProductRecord> listWithProducts = new ArrayList<>();
    List<ProductRecord> changedProducts = new ArrayList<>();


    public static Warehouse getInstance() {
        return null;
    }

    public static Warehouse getInstance(String myStore) {
        return null;
    }

    public ProductRecord addProduct(UUID productUUID, String productName, Category productCategory, BigDecimal productPrice) {
        UUID newId = (productUUID == null) ? UUID.randomUUID() : productUUID;
        ProductRecord newItem = new ProductRecord(newId, productName, productPrice, productCategory);
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
        for (ProductRecord productRecord : listWithProducts) {
            if (productRecord.getUUID().equals(productUUID))
                return Optional.of(productRecord);
        }
        return Optional.empty();
    }


    public void updateProductPrice(UUID productUUID, BigDecimal productPrice) {
        ProductRecord productRecord = getProductById(productUUID).orElse(null);
        if ( productRecord != null){
            productRecord.setProductPrice(productPrice);
            productRecord.markAsChanged();
        }
    }

    public List<ProductRecord> getChangedProducts() {
        for (ProductRecord productRecord : listWithProducts) {
            if ( productRecord.isChanged())
                changedProducts.add(productRecord);
        }
            return changedProducts;
        }

        public boolean getProductsGroupedByCategories () {
            return false;
        }

        public List<ProductRecord> getProductsBy (Category meat){
            for (ProductRecord productRecord : listWithProducts) {
                if (productRecord.productCategory.equals(meat)) productRecord.add(meat);
            }
            return listWithProducts;
        }
    }

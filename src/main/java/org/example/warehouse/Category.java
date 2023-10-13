package org.example.warehouse;

import java.util.HashMap;
import java.util.Map;

public class Category {
    private static final Map<String, Category> categoryMap = new HashMap<>();
    private final String name;


    private Category(String name) {
        this.name = name;
    }

    public static Category of(String name) {
        if (name == null)
            throw new IllegalArgumentException("Category name can't be null");
        String capitalized = name.substring(0, 1).toUpperCase() + name.substring(1);
        categoryMap.putIfAbsent(capitalized, new Category(capitalized));
        return categoryMap.get(capitalized);
    }

    public String getName() {
        return name;
    }
}

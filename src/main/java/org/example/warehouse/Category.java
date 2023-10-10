package org.example.warehouse;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Category {
    private static final Map<String, Category> categoryMap = new HashMap<>();
    private String name;


    private Category(String name) {
        this.name = name;
    }

    public static Category of(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Category name can't be null");
        }
        String capitalized = name.substring(0, 1).toUpperCase() + name.substring(1);
        categoryMap.putIfAbsent(capitalized, new Category(capitalized));
        //Category category = new Category(name);
        //category.name = name;
        return categoryMap.get(capitalized);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }
}

package org.example.warehouse;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Category {
    private static Map<String,Category> categoryMap = new HashMap<>();
    private String name;


    private Category(String name) {
        this.name = name.substring(0,1).toUpperCase() + name.substring(1);
    }

    public static Category of(String name) {
        Category category = new Category(name);
        category.name = name;
        return category;
    }

    public String getName() {
        return name;
    }


    //@Override
    //public int compareTo(Object o) {
    //    return 0;
    //}

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

package com.hiwijaya.javabasic;

import lombok.*;

import java.util.Objects;

@Data
@NoArgsConstructor
public class Product implements Comparable<Product> {

    private int id;
    private String name;

    private Manufacture manufacture;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Product other) {
        return this.name.compareTo(other.name);  // sorted asc
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Manufacture {

    private String country;

}
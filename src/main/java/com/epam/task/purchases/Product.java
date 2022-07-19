package com.epam.task.purchases;

public class Product {
    private final String name;
    private final Euro price;

    public Product(String name, Euro price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ';' + price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Product)) {
            return false;
        }

        Product other = (Product) obj;

        return this.price.equals(other.price) && this.name.equals(other.name);
    }

    public Euro getPrice() {
        return price;
    }
}

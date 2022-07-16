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
        return name + ';' + price.toString();
    }

    public Euro getPrice() {
        return price;
    }
}

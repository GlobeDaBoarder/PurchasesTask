package com.epam.mjc.stage0;

public class Product {
    private String name;
    private Euro price;

    public Product(String name, Euro price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ';' + price;
    }

    public String getName() {
        return name;
    }


    public Euro getPrice() {
        return price;
    }
}

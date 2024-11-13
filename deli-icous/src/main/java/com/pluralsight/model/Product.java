package com.pluralsight.model;

public class Product {

    String name;
    double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

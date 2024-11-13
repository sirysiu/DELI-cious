package com.pluralsight.model.enums;

public enum Cheese {
    AMERICAN(0.75),
    SWISS(0.75),
    PROVOLONE(0.75),
    CHEDDAR(0.75);

    private final double price;

    Cheese(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

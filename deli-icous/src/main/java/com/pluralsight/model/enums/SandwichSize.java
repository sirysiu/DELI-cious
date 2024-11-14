package com.pluralsight.model.enums;

public enum SandwichSize {
    SMALL(4.00),
    MEDIUM(8.00),
    LARGE(12.00);

    private final double price;

    SandwichSize(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

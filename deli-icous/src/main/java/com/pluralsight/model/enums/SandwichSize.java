package com.pluralsight.model.enums;

public enum SandwichSize {
    SMALL(4),
    MEDIUM(8),
    LARGE(12);

    private final double price;

    SandwichSize(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

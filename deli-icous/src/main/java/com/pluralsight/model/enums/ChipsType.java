package com.pluralsight.model.enums;

public enum ChipsType {
    LAYS(1.50),
    DORITOS(1.50),
    PRINGLES(1.50);

    private final double price;

    ChipsType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

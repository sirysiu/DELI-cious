package com.pluralsight.model;

import com.pluralsight.model.enums.DrinkSize;

public class Drink {
    private DrinkSize drink;

    public void setDrink(DrinkSize drink) {
        this.drink = drink;
    }

    public DrinkSize getDrinkType() {
        return drink;
    }

    public double getDrinkPrice() {
        double total = drink.getPrice();
        return total;
    }
}

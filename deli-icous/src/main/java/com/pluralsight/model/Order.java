package com.pluralsight.model;

import com.pluralsight.model.enums.DrinkSize;


public class Order {
    private Sandwich sandwich;
    private Drink drink;
    private Chips chips;
    private DrinkSize drinkSize;


    public Chips getChips() {
        return chips;
    }

    public Drink getDrink() {
        return drink;
    }


    public void setChips(Chips chips) {
        this.chips = chips;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }


    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public Order() {
        this.sandwich = sandwich;
        this.drinkSize = drinkSize;

    }

    // Method to calculate total price of the order

    public double getOrderTotalPrice() {
        double total = 0;

        // Add the price of the sandwich to the total
        if (sandwich != null) {
            total += sandwich.getTotalPriceSandwich(sandwich);
        }

        // Add the price of the drink based on the size
        if (drink != null) {
            total += drink.getDrinkPrice();
        }

        // Add the price of chips
        if (chips != null) {
            total += chips.getChipsPrice();
        }

        return total;
    }

    public Sandwich getSandwich() {
        return sandwich;
    }

    public DrinkSize getDrinkSize() {
        return drinkSize;
    }



}

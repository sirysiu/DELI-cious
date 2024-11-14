package com.pluralsight.model;

import com.pluralsight.model.enums.ChipsType;
import com.pluralsight.model.enums.DrinkSize;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Sandwich sandwich;
    private Drink drink;
    private Chips chips;
    private DrinkSize drinkSize;
   // private ChipsType chipsType;






    public Chips getChips() {
        return chips;
    }

    public Drink getDrink() {
        return drink;
    }


    public void setChips(Chips crisp) {
        this.chips = chips;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public void setDrinkSize(DrinkSize drinkSize) {
        this.drinkSize = drinkSize;
    }




//    public void setChipsType(ChipsType chipsType) {
//        this.chipsType = chipsType;
//    }

    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public Order() {
        this.sandwich = sandwich;
        this.drinkSize = drinkSize;
      //  this.chipsType = chipsType;
       // this.chips = new ArrayList<>();
    }

    // Method to calculate total price of the order

    public double getOrderTotalPrice() {
        double total = 0;

        // Add the price of the sandwich to the total
        if (sandwich != null) {
            total += sandwich.getTotalPriceSandwich();
        }

        // Add the price of the drink based on the size
        if (drinkSize != null) {
            total += drinkSize.getPrice();
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

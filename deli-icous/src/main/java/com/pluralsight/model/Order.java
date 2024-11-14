package com.pluralsight.model;

import com.pluralsight.model.enums.ChipsType;
import com.pluralsight.model.enums.DrinkSize;

public class Order {
    //  private List<Product> products;
    private Sandwich sandwich;
    private Drink drink;
    private Chips chips;

    public void setChips(Chips chips) {
        this.chips = chips;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public void setDrinkSize(DrinkSize drinkSize) {
        this.drinkSize = drinkSize;
    }

    private DrinkSize drinkSize;

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    private ChipsType chipsType;
    private String customerName;
    private String orderNumber;

    public void setChipsType(ChipsType chipsType) {
        this.chipsType = chipsType;
    }

    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public Order() {
        this.sandwich = sandwich;
        this.drinkSize = drinkSize;
        this.chipsType = chipsType;
        this.customerName = customerName;
        this.orderNumber = orderNumber;
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
        if (chipsType != null) {
            total += chipsType.getPrice();
        }

        return total;
    }

    public Sandwich getSandwich() {
        return sandwich;
    }

    public DrinkSize getDrinkSize() {
        return drinkSize;
    }

    public ChipsType getChipsType() {
        return chipsType;
    }



//    public List<Product> getProducts() {
//        return products;
//    }

    public String getCustomerName() {
        return customerName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }



    @Override
    public String toString() {
        return "Order{" +
                "sandwich=" + sandwich +
                ", drinkSize=" + drinkSize +
                ", chipsType=" + chipsType +
                ", customerName='" + customerName + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                '}';
    }
//    public Order(List<Product> products, String customerName, String orderNumber) {
//        this.products = products;
//        this.customerName = customerName;
//        this.orderNumber = orderNumber;
//    }
}

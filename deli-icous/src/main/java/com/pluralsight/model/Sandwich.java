package com.pluralsight.model;

import com.pluralsight.model.enums.*;

public class Sandwich extends Product{
    SandwichSize size;
     Toppings toppings;
     BreadType bread;
    Meat meats;
    Cheese cheese;
    boolean isToasted;


    public SandwichSize getSize() {
        return size;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public Toppings getToppings() {
        return toppings;
    }

    public BreadType getBread() {
        return bread;
    }

    public Meat getMeats() {
        return meats;
    }

    public Cheese getCheese() {
        return cheese;
    }

    public Sandwich(String name, double price, SandwichSize size, Toppings toppings, BreadType bread, Meat meats, Cheese cheese, boolean isToasted) {
        super(name, price);
        this.size = size;
        this.toppings = toppings;
        this.bread = bread;
        this.meats = meats;
        this.cheese = cheese;
        this.isToasted = isToasted;

        if (size == SandwichSize.SMALL) {
            this.price = 5.50;
        } else if(size == SandwichSize.MEDIUM) {
            this.price = 7.00;
        } else if(size == SandwichSize.LARGE) {
            this.price = 8.50;
        }
    }

    @Override
    public String toString() {
        return
                "on " + bread +
                        " with " + toppings +
                " " + meats +
                " " + cheese +
                        " and " + isToasted
                ;
    }
}

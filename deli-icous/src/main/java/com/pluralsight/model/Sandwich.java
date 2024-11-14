package com.pluralsight.model;

import com.pluralsight.model.enums.*;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private SandwichSize size;
    private List<Toppings> toppings;
    private BreadType bread;
    private  List<Meat> meats;
    private List<Cheese> cheeses;
    private List<Sauces> sauces;
    private  boolean isToasted;

    public List<Sauces> getSauces() {
        return sauces;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public Sandwich() {
        super();
        // Initialize the lists
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.toppings = new ArrayList<>();  // Initialize toppings list
        this.sauces = new ArrayList<>();
        this.isToasted = false;
    }

    public double getTotalPriceSandwich() {
        double total = size.getPrice();

        for (Meat meat : meats) {
            total += meat.getPrice();
        }

        for (Cheese cheese : cheeses) {
            total += cheese.getPrice();
        }

        return total;
    }

    public void setSauces(List<Sauces> sauces) {
        this.sauces = sauces;
    }

    public boolean isToasted() {
        return isToasted;  // Get the toasted state
    }
    public void setSize(SandwichSize size) {
        this.size = size;
    }

    public void setToppings(List<Toppings> toppings) {
        this.toppings = toppings;
    }

    public void setBread(BreadType bread) {
        this.bread = bread;
    }

    public void addMeat(Meat meat) {
       this.meats.add(meat);
    }

    public void addCheese(Cheese cheese) {
        cheeses.add(cheese);
    }

    public SandwichSize getSize() {
        return size;
    }



    public List<Toppings> getToppings() {
        return toppings;
    }

    public BreadType getBread() {
        return bread;
    }

    public List<Meat> getMeats() {
        return meats;
    }

    public List<Cheese> getCheeses() {
        return cheeses;
    }


}

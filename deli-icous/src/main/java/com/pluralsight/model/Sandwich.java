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
        this.size = size;
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.toppings = new ArrayList<>();  // Initialize toppings list
        this.sauces = new ArrayList<>();
        this.isToasted = false;
    }

    public double getTotalPriceSandwich(Sandwich sandwich) {
        double total = size.getPrice();
        boolean firstMeat = true;
        boolean firstCheese = true;

        for (Meat meat : meats) { //meat price depends on the sandwich size
            if (firstMeat) {

                if (size == SandwichSize.SMALL) {
                    total += 1.00;
                } else if (size == SandwichSize.MEDIUM) {
                    total += 2.00;
                } else if (size == SandwichSize.LARGE) {
                    total += 3.00;
                }
                firstMeat = false;
            }  else { // if anymore meat add it will be charged extra
                    if (size == SandwichSize.SMALL) {
                        total += 0.50;
                    } else if (size == SandwichSize.MEDIUM) {
                        total += 1.00;
                    } else if (size == SandwichSize.LARGE) {
                        total += 1.50;
                    }
                }

            }


        for (Cheese cheese : cheeses) {
            if (firstCheese) {
            if (size == SandwichSize.SMALL) {
                total += 0.75;
            } else if (size == SandwichSize.MEDIUM){
                total += 1.50;
            } else if (size == SandwichSize.LARGE) {
                total += 2.25;
            }
            firstCheese = false;
            }
            else { // if anymore cheese add it will be charged extra
                if (size == SandwichSize.SMALL) {
                    total += 0.30;
                } else if (size == SandwichSize.MEDIUM) {
                    total += 0.60;
                } else if (size == SandwichSize.LARGE) {
                    total += 0.90;
                }
            }

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

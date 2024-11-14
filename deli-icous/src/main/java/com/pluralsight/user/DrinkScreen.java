package com.pluralsight.user;

import com.pluralsight.model.Drink;
import com.pluralsight.model.Order;
import com.pluralsight.model.enums.DrinkSize;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DrinkScreen {
     static List<Drink> drink = new ArrayList<>();

    public DrinkScreen(Order order) {
        Scanner scanner = new Scanner(System.in);
        Drink soda = new Drink();


        System.out.println("What size drink would you like? ");
        System.out.println("(SMALL MEDIUM LARGE)");
        try {
            DrinkSize d = DrinkSize.valueOf(scanner.nextLine().toUpperCase());
            soda.setDrink(d);
        } catch (IllegalArgumentException e) {
            System.out.println("\nInvalid sauce selection. Please try again.");
        }
        order.setDrink(soda);

        System.out.println("\nYou have selected a Drink...\n");
    }
}

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


        System.out.println("What size drink would you like? SMALL MEDIUM LARGE");
        DrinkSize d = DrinkSize.valueOf(scanner.nextLine().toUpperCase());
        soda.setDrink(d);

      //  drink.add(soda);

        order.setDrink(soda);
        //order.setSandwich(sandwichOrder); // Add the sandwich to the order


    }
}

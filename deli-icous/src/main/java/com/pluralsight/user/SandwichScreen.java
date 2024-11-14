package com.pluralsight.user;

import com.pluralsight.model.Order;
import com.pluralsight.model.Sandwich;
import com.pluralsight.model.enums.*;

import java.util.Collections;

import java.util.Scanner;

public class SandwichScreen {
    private Order order;

    public SandwichScreen(Order order) {
        this.order = order;
        Scanner scanner = new Scanner(System.in);
        Sandwich sandwichOrder = new Sandwich();


        System.out.println("What size Sandwich would you like?");
        System.out.println("(SMALL, MEDIUM, LARGE)");
        SandwichSize size = SandwichSize.valueOf(scanner.nextLine().toUpperCase());
        sandwichOrder.setSize(size);

        System.out.println("\nWhat kind of bread would you like? ");
        System.out.println("(WHITE, WHEAT, RYE, WRAP) ");
        BreadType breadInput = BreadType.valueOf(scanner.nextLine().toUpperCase());
        sandwichOrder.setBread(breadInput);

        System.out.println("\nSelect meats (STEAK, HAM, SALAMI, ROAST_BEEF, CHICKEN, BACON). Type 'done' to stop adding.");
        while (true) {
            String meatChoice = scanner.nextLine().toUpperCase();
            if (meatChoice.equals("DONE")) break;
            Meat meat = Meat.valueOf(meatChoice);
            sandwichOrder.addMeat(meat);
        }

        System.out.println("\nSelect cheese (AMERICAN, PROVOLONE, CHEDDAR, SWISS). Type 'done' to stop adding.");
        while (true) {
            String cheeseChoice = scanner.nextLine().toUpperCase();
            if (cheeseChoice.equals("DONE")) break;
            Cheese cheese = Cheese.valueOf(cheeseChoice);
            sandwichOrder.addCheese(cheese);
        }
        System.out.println("\nSelect toppings (LETTUCE, PEPPERS, ONIONS, TOMATOES, JALAPENOS, CUCUMBERS, PICKLES, GUACAMOLE, MUSHROOMS). Type 'done' to stop adding.");
        while (true) {
            String toppingChoice = scanner.nextLine().toUpperCase();
            if (toppingChoice.equals("DONE")) break;
            Toppings topping = Toppings.valueOf(toppingChoice);
            sandwichOrder.setToppings(Collections.singletonList(topping));
        }
        System.out.println("\nSelect sauces (MAYO, MUSTARD, KETCHUP, RANCH, THOUSAND_ISLANDS, VINAIGRETTE). Type 'done' to stop adding.");
        while (true) {
            String sauceChoice = scanner.nextLine().toUpperCase();
            if (sauceChoice.equals("DONE")) break;
            Sauces sauces = Sauces.valueOf(sauceChoice);
            sandwichOrder.setSauces(Collections.singletonList(sauces));
        }

        System.out.println("\nWould you like it toasted? (yes/no) ");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            sandwichOrder.setToasted(true);
        }



        order.setSandwich(sandwichOrder); // Add the sandwich to the order

        System.out.println("\nSandwich order Finished");
        }

    }


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


        System.out.println("What size Sandwich would you like? (SMALL, MEDIUM, LARGE)");
        SandwichSize size = SandwichSize.valueOf(scanner.nextLine().toUpperCase());
        sandwichOrder.setSize(size);

        System.out.println("What kind of bread would you like? (WHITE, WHEAT, RYE, WRAP) ");
        BreadType breadInput = BreadType.valueOf(scanner.nextLine().toUpperCase());
        sandwichOrder.setBread(breadInput);

        System.out.println("Select meats (STEAK, HAM, SALAMI, ROAST_BEEF, CHICKEN, BACON). Type 'done' to stop adding.");
        while (true) {
            String meatChoice = scanner.nextLine().toUpperCase();
            if (meatChoice.equals("DONE")) break;
            Meat meat = Meat.valueOf(meatChoice);
            sandwichOrder.addMeat(meat);
        }

        System.out.println("Select cheese (AMERICAN, PROVOLONE, CHEDDAR, SWISS). Type 'done' to stop adding.");
        while (true) {
            String cheeseChoice = scanner.nextLine().toUpperCase();
            if (cheeseChoice.equals("DONE")) break;
            Cheese cheese = Cheese.valueOf(cheeseChoice);
            sandwichOrder.addCheese(cheese);
        }
        System.out.println("Select toppings (LETTUCE, PEPPERS, ONIONS, TOMATOES, JALAPENOS, CUCUMBERS, PICKLES, GUACAMOLE, MUSHROOMS). Type 'done' to stop adding.");
        while (true) {
            String toppingChoice = scanner.nextLine().toUpperCase();
            if (toppingChoice.equals("DONE")) break;
            Toppings topping = Toppings.valueOf(toppingChoice);
            sandwichOrder.setToppings(Collections.singletonList(topping));
        }
        System.out.println("Select sauces (MAYO, MUSTARD, KETCHUP, RANCH, THOUSAND_ISLANDS, VINAIGRETTE). Type 'done' to stop adding.");
        while (true) {
            String sauceChoice = scanner.nextLine().toUpperCase();
            if (sauceChoice.equals("DONE")) break;
            Sauces sauces = Sauces.valueOf(sauceChoice);
            sandwichOrder.setSauces(Collections.singletonList(sauces));
        }

        System.out.println("Would you like it toasted? (yes/no) ");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            sandwichOrder.setToasted(true);
        }



        order.setSandwich(sandwichOrder); // Add the sandwich to the order

        System.out.println(sandwichOrder);
        System.out.println(sandwichOrder.getTotalPriceSandwich());
        }

    }


package com.pluralsight.user;

import com.pluralsight.model.Order;
import java.util.Scanner;

public class OrderScreen {
    private Order order;

    public OrderScreen() {
        order = new Order();
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("""
                    ╔════════════════════════╗
                    ║          ORDER         ║
                    ║                        ║
                    ║ [1] Add Sandwich       ║
                    ║ [2] Add Drink          ║
                    ║ [3] Add Chips          ║
                    ║ [4] Checkout           ║
                    ║ [0] Cancel Order       ║
                    ║                        ║
                    ╚════════════════════════╝
                    """);


            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();

        switch (input) {
            case 1:
                new SandwichScreen(order);
                break;
            case 2:
                new DrinkScreen(order);
                break;
            case 3:
                new ChipScreen(order);
                break;
            case 4:
                System.out.println("Checking out.. ");
               isRunning = false;
               new Checkout(order);
                break;
            case 0:
                System.out.println("Order Cancelled...");
                isRunning = false;
                break;
            default:
                System.out.println("Please enter the number above");
        }

        }
    }


}

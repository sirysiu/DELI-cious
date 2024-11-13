package com.pluralsight.user;

import java.util.Scanner;

public class OrderScreen {
    public OrderScreen() {
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
                new SandwichScreen();
                break;
            case 2:
                new DrinkScreen();
                break;
            case 3:
                new ChipScreen();
                break;
            case 4:
                System.out.println("Checking out.. ");
                isRunning = false;
                break;
            case 0:
                System.out.println("Order Cancelled...");
                isRunning = false;
                break;
        }

        }
    }


}

package com.pluralsight.user;

import com.pluralsight.model.Order;
import java.util.Scanner;

public class OrderScreen {
    private Order order;

    public OrderScreen() {
        order = new Order();
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

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

            int input = -1;  // Initialize to invalid value

            // Loop until a valid input is received
            while (input < 0 || input > 4) {
                try {
                    input = scanner.nextInt();  // Read the user input

                    if (input < 0 || input > 4) {
                        System.out.println("Invalid input! Please enter a number between 0 and 4.");
                    }
                } catch (Exception e) {
                    // Handle non-integer inputs and prompt user to try again
                    System.out.println("Invalid input! Please enter a valid number.");
                    scanner.nextLine();  // Consume the invalid input to avoid infinite loop
                }
            }

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
                    System.out.println("Checking out...");
                    isRunning = false;
                    new Checkout(order);
                    break;
                case 0:
                    System.out.println("Order Cancelled...");
                    isRunning = false;
                    break;
                default:
                    // This block is redundant due to the input validation above.
                    break;
            }
        }
    }
}

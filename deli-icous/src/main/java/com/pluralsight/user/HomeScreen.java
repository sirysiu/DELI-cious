package com.pluralsight.user;

import java.util.Scanner;

public class HomeScreen {
    private Scanner scanner = new Scanner(System.in);

    public HomeScreen() {
        int input = -1;

        // Continuously ask for input until valid input (0 or 1) is entered
        while (input != 0 && input != 1) {
            System.out.println("""
                    ╔════════════════════════╗
                    ║          HOME          ║
                    ║                        ║      
                    ║    [1] NEW ORDER       ║
                    ║    [0] EXIT            ║
                    ║                        ║                
                    ╚════════════════════════╝
                    """);

            try {
                // Try to get user input
                input = scanner.nextInt();

                // Process the valid options
                switch (input) {
                    case 1:
                        new OrderScreen();  // Proceed to OrderScreen if the user chooses "New Order"
                        break;
                    case 0:
                        System.out.println("Exiting...");  // Exit if the user chooses "Exit"
                        break;
                    default:
                        // If the input is not 0 or 1, prompt the user again
                        System.out.println("Invalid choice. Please choose a valid option (0 or 1).");
                        input = -1;  // Reset input to -1 to re-enter the loop
                        break;
                }
            } catch (Exception e) {
                // Catch any input mismatch exception and prompt the user to try again
                System.out.println("\n");
                scanner.nextLine();  // Consume the invalid input to prevent infinite loop
                input = -1;  // Reset input to -1 to re-enter the loop
            }
        }
    }
}

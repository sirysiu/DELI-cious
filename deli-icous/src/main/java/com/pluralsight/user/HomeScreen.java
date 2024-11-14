package com.pluralsight.user;

import java.util.Scanner;

public class HomeScreen {
    Scanner scanner = new Scanner(System.in);

    public HomeScreen() {
        int input = -1;


        while (input != 0 && input != 1) { // while loop to be able to catch error
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
                input = scanner.nextInt();

                switch (input) {
                    case 1:
                        new OrderScreen();
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Choose option above");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input, try again");
                scanner.nextLine();  // Consume the invalid input to prevent infinite loop
            }
        }
    }
}

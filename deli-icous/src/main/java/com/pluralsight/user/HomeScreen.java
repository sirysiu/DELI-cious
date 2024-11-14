package com.pluralsight.user;

import java.util.Scanner;

public class HomeScreen {
    Scanner scanner = new Scanner(System.in);
    public HomeScreen() {
            System.out.println("""
                    ╔════════════════════════╗
                    ║          HOME          ║
                    ║                        ║      
                    ║    [1] NEW ORDER       ║
                    ║    [0] EXIT            ║
                    ║                        ║                
                    ╚════════════════════════╝
                    """);
            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    new OrderScreen();
                    break;
                case 0:
                    System.out.println("Exiting...");
                default:
                    System.out.println("Choose option above");
            }

    }
    }


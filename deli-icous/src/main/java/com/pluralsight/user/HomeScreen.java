package com.pluralsight.user;

import java.util.Scanner;

public class HomeScreen {
    Scanner scanner = new Scanner(System.in);
    public HomeScreen() {
        boolean isRunning = true;
        //while (isRunning) {
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

            if (input == 1) {
                new OrderScreen();
            } else {
                System.out.println("Exiting...");
              //  isRunning = false;
            }
      //  }
    }
}

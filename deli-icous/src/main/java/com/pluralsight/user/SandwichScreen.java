package com.pluralsight.user;

import com.pluralsight.model.Order;
import com.pluralsight.model.Sandwich;
import com.pluralsight.model.enums.*;
import com.pluralsight.styles.ColorCodes;


import java.util.Scanner;

public class SandwichScreen {
    private Order order;
    Scanner scanner = new Scanner(System.in);

    public SandwichScreen(Order order) {
        this.order = order;
        Sandwich sandwichOrder = new Sandwich();

        selectSize(sandwichOrder);
        selectBreadType(sandwichOrder);
        selectMeat(sandwichOrder);
        selectCheese(sandwichOrder);
        selectToppings(sandwichOrder);
        selectSauce(sandwichOrder);
        toastedOrNah(sandwichOrder);


        order.setSandwich(sandwichOrder); // Add the sandwich to the order

        System.out.println("\nSandwich order Finished");

    }


    private void selectSize(Sandwich sandwichOrder) {
        System.out.println("\nWhat size Sandwich would you like?");
        System.out.println("""
                ╔════════════════════════════════╗
                ║        SANDWICH SIZE           ║
                ║                                ║
                ║    [1] SMALL                   ║
                ║    [2] MEDIUM                  ║
                ║    [3] LARGE                   ║
                ║                                ║
                ╚════════════════════════════════╝
                """);

        System.out.print("Enter the number of your choice (1-3): ");
        String sizeChoice = scanner.nextLine().toUpperCase();

        try {
            // Parse the numeric input to get the sandwich size
            int choice = Integer.parseInt(sizeChoice);

            SandwichSize sizeInput = null;
            switch (choice) {
                case 1:
                    sizeInput = SandwichSize.SMALL;
                    break;
                case 2:
                    sizeInput = SandwichSize.MEDIUM;
                    break;
                case 3:
                    sizeInput = SandwichSize.LARGE;
                    break;
                default:
                    System.out.println("\nInvalid choice. Please select a valid number (1-3).");

            }
            sandwichOrder.setSize(sizeInput);

        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    private void selectBreadType(Sandwich sandwichOrder) {
        System.out.println("\n\nWhat kind of bread would you like? ");
        System.out.println("""
                ╔════════════════════════╗
                ║          MENU          ║
                ║                        ║
                ║    [1] WHITE           ║
                ║    [2] WHEAT           ║
                ║    [3] RYE             ║
                ║    [4] WRAP            ║
                ║                        ║
                ╚════════════════════════╝
                """);
        System.out.print("Enter the number of your choice (1-4): ");

        try {
            int breadChoice = scanner.nextInt();
            BreadType breadInput = null;
            switch (breadChoice) {
                case 1:
                    breadInput = BreadType.WHITE;
                    break;
                case 2:
                    breadInput = BreadType.WHEAT;
                    break;
                case 3:
                    breadInput = BreadType.RYE;
                    break;
                case 4:
                    breadInput = BreadType.WRAP;
                    break;
                default:
                    System.out.println("\nInvalid choice. Please select a valid option (1-4).");
                    return; // Exit the method if the choice is invalid
            }

            sandwichOrder.setBread(breadInput);
        } catch (NumberFormatException e) {
            System.out.println("\nInvalid choice selection. Please try again.");
        }

    }

    private void selectMeat(Sandwich sandwichOrder) {
        // Display the meat selection menu
        System.out.println("""
                ╔════════════════════════════════╗
                ║          MEAT MENU             ║
                ║                                ║
                ║    [1] STEAK                   ║
                ║    [2] HAM                     ║
                ║    [3] SALAMI                  ║
                ║    [4] ROAST_BEEF              ║
                ║    [5] CHICKEN                 ║
                ║    [6] BACON                   ║
                ║                                ║
                ╚════════════════════════════════╝
                """);

        System.out.println("Enter the number (1 - 6) of the meat you want, to add extra press ENTER (or type 'done' to stop): ");
        System.out.println(ColorCodes.RED + "*Will be charged EXTRA for Additional Meat*" + ColorCodes.RESET);
        scanner.nextLine(); // This consumes the leftover newline from nextInt()
        System.out.print("Enter the number of your choice (1-6): ");


// Loop to keep asking for valid input
        while (true) {
            // Read the input from user and trim whitespace
            String meatChoice = scanner.nextLine().trim().toUpperCase();

            // Check if the user wants to stop
            if (meatChoice.equals("DONE")) {
                break;  // Exit the loop if the user types 'done'
            }

            try {
                // Try parsing the numeric input
                int choice = Integer.parseInt(meatChoice); // This will throw an exception if the input is not a valid number

                // Map the numeric input to the corresponding Meat enum
                Meat selectedMeat = null;
                switch (choice) {
                    case 1:
                        selectedMeat = Meat.STEAK;
                        break;
                    case 2:
                        selectedMeat = Meat.HAM;
                        break;
                    case 3:
                        selectedMeat = Meat.SALAMI;
                        break;
                    case 4:
                        selectedMeat = Meat.ROAST_BEEF;
                        break;
                    case 5:
                        selectedMeat = Meat.CHICKEN;
                        break;
                    case 6:
                        selectedMeat = Meat.BACON;
                        break;
                    default:
                        System.out.println("\nInvalid choice. Please select a valid number (1-6).");
                        continue; // If the number is not valid, prompt again
                }

                // Add selected meat to sandwich order
                sandwichOrder.addMeat(selectedMeat);

            } catch (NumberFormatException e) {
                // Catch invalid numeric input (non-integer values or other invalid input)
                System.out.println("\nInvalid input. Please enter a valid number (1-6) or 'done' to stop.");
            }
        }
    }

    private void selectCheese(Sandwich sandwichOrder) {
        // Display the cheese selection menu
        System.out.println("""
                ╔════════════════════════════════╗
                ║          CHEESE MENU           ║
                ║                                ║
                ║    [1] AMERICAN                ║
                ║    [2] PROVOLONE               ║
                ║    [3] CHEDDAR                 ║
                ║    [4] SWISS                   ║
                ║                                ║
                ╚════════════════════════════════╝
                """);

        System.out.println("Enter the number (1 - 4) of the cheese you want, to add extra press ENTER (or type 'done' to stop): ");
        System.out.println(ColorCodes.RED + "*Will be charged EXTRA for Additional Cheese*" + ColorCodes.RESET);

        System.out.print("Enter the number of your choice (1-4): ");
// Loop to keep asking for valid input
        while (true) {

            String cheeseChoice = scanner.nextLine().trim().toUpperCase();

            // Check if the user wants to stop
            if (cheeseChoice.equals("DONE")) {
                break;  // Exit the loop if the user types 'done'
            }

            try {
                // Try parsing the numeric input
                int choice = Integer.parseInt(cheeseChoice); // This will throw an exception if the input is not a valid number

                // Map the numeric input to the corresponding Cheese enum
                Cheese selectedCheese = null;
                switch (choice) {
                    case 1:
                        selectedCheese = Cheese.AMERICAN;
                        break;
                    case 2:
                        selectedCheese = Cheese.PROVOLONE;
                        break;
                    case 3:
                        selectedCheese = Cheese.CHEDDAR;
                        break;
                    case 4:
                        selectedCheese = Cheese.SWISS;
                        break;
                    default:
                        System.out.println("\nInvalid choice. Please select a valid number (1-4).");
                        continue; // If the number is not valid, prompt again
                }

                // Add selected cheese to sandwich order
                sandwichOrder.addCheese(selectedCheese);

            } catch (NumberFormatException e) {
                // Catch invalid numeric input (non-integer values or other invalid input)
                System.out.println("\nInvalid input. Please enter a valid number (1-4) or 'done' to stop.");
            }
        }
    }

    private void selectToppings(Sandwich sandwichOrder) {
        // Display the topping selection menu
        System.out.println("""
                ╔════════════════════════════════╗
                ║          TOPPING MENU          ║
                ║                                ║
                ║    [1] LETTUCE                 ║
                ║    [2] PEPPERS                 ║
                ║    [3] ONIONS                  ║
                ║    [4] TOMATOES                ║
                ║    [5] JALAPENOS               ║
                ║    [6] CUCUMBERS               ║
                ║    [7] PICKLES                 ║
                ║    [8] GUACAMOLE               ║
                ║    [9] MUSHROOMS               ║
                ║                                ║
                ╚════════════════════════════════╝
                """);

        System.out.println("Enter the number (1 - 9) of the topping you want, or type 'done' to stop adding.");
        System.out.print("Enter the number of your choice (1-9): ");

// Loop to keep asking for valid input
        while (true) {

            String toppingChoice = scanner.nextLine().trim().toUpperCase();

            // Check if the user wants to stop
            if (toppingChoice.equals("DONE")) {
                break;  // Exit the loop if the user types 'done'
            }

            try {
                // Try parsing the numeric input
                int choice = Integer.parseInt(toppingChoice); // This will throw an exception if the input is not a valid number

                // Map the numeric input to the corresponding Topping enum
                Toppings selectedTopping = null;
                switch (choice) {
                    case 1:
                        selectedTopping = Toppings.LETTUCE;
                        break;
                    case 2:
                        selectedTopping = Toppings.PEPPERS;
                        break;
                    case 3:
                        selectedTopping = Toppings.ONIONS;
                        break;
                    case 4:
                        selectedTopping = Toppings.TOMATOES;
                        break;
                    case 5:
                        selectedTopping = Toppings.JALAPENO;
                        break;
                    case 6:
                        selectedTopping = Toppings.CUCUMBERS;
                        break;
                    case 7:
                        selectedTopping = Toppings.PICKLES;
                        break;
                    case 8:
                        selectedTopping = Toppings.GUACAMOLE;
                        break;
                    case 9:
                        selectedTopping = Toppings.MUSHROOM;
                        break;
                    default:
                        System.out.println("\nInvalid choice. Please select a valid number (1-9).");
                        continue; // If the number is not valid, prompt again
                }

                // Add selected topping to sandwich order
                sandwichOrder.getToppings().add(selectedTopping);

            } catch (NumberFormatException e) {
                // Catch invalid numeric input (non-integer values or other invalid input)
                System.out.println("\nInvalid input. Please enter a valid number (1-9) or 'done' to stop.");
            }
        }

    }

    private void selectSauce(Sandwich sandwichOrder) {
        // Display the sauce selection menu
        System.out.println("""
                ╔════════════════════════════════╗
                ║          SAUCE MENU            ║
                ║                                ║
                ║    [1] MAYO                    ║
                ║    [2] MUSTARD                 ║
                ║    [3] KETCHUP                 ║
                ║    [4] RANCH                   ║
                ║    [5] THOUSAND_ISLANDS        ║
                ║    [6] VINAIGRETTE             ║
                ║                                ║
                ╚════════════════════════════════╝
                """);

        System.out.println("Enter the number (1 - 6) of the sauce you want, or type 'done' to stop adding.");
        System.out.print("Enter the number of your choice (1-6): ");

// Loop to keep asking for valid input
        while (true) {

            String sauceChoice = scanner.nextLine().trim().toUpperCase();

            // Check if the user wants to stop
            if (sauceChoice.equals("DONE")) {
                break;  // Exit the loop if the user types 'done'
            }

            try {
                // Try parsing the numeric input
                int choice = Integer.parseInt(sauceChoice); // This will throw an exception if the input is not a valid number

                // Map the numeric input to the corresponding Sauce enum
                Sauces selectedSauce = null;
                switch (choice) {
                    case 1:
                        selectedSauce = Sauces.MAYO;
                        break;
                    case 2:
                        selectedSauce = Sauces.MUSTARD;
                        break;
                    case 3:
                        selectedSauce = Sauces.KETCHUP;
                        break;
                    case 4:
                        selectedSauce = Sauces.RANCH;
                        break;
                    case 5:
                        selectedSauce = Sauces.THOUSAND_ISLANDS;
                        break;
                    case 6:
                        selectedSauce = Sauces.VINAIGRETTE;
                        break;
                    default:
                        System.out.println("\nInvalid choice. Please select a valid number (1-6).");
                        continue; // If the number is not valid, prompt again
                }

                // Add selected sauce to sandwich order
                sandwichOrder.getSauces().add(selectedSauce);

            } catch (NumberFormatException e) {
                // Catch invalid numeric input (non-integer values or other invalid input)
                System.out.println("\nInvalid input. Please enter a valid number (1-6) or 'done' to stop.");
            }
        }

    }

    private void toastedOrNah(Sandwich sandwichOrder) {

        System.out.println("\nWould you like it toasted? (yes/no): ");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            sandwichOrder.setToasted(true);
        }

    }
}



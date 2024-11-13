package com.pluralsight.user;

import com.pluralsight.model.enums.SandwichSize;
import com.pluralsight.model.enums.Toppings;
import com.pluralsight.model.enums.BreadType;

import java.util.Scanner;

public class SandwichScreen {
    public SandwichScreen() {
        Scanner scanner = new Scanner(System.in);
        boolean moreToppings = true;

        System.out.println("What size Sandwich would you like? ");
        SandwichSize size = SandwichSize.valueOf(scanner.nextLine().toUpperCase());

        System.out.println("Okay you chose " + size );
        System.out.println("What kind of bread would you like? ");
        BreadType breadInput = BreadType.valueOf(scanner.nextLine().toUpperCase());

        System.out.println("You selected: " + breadInput);
        while (moreToppings) {
            System.out.println("Choice of meat? ");
            Toppings meat = Toppings.valueOf(scanner.nextLine().toUpperCase());

            System.out.println("Would you like extra (yes/no)? ");

            System.out.println();
            System.out.println("What Toppings would you like? ");
            Toppings toppings = Toppings.valueOf(scanner.nextLine().toUpperCase());

            System.out.println("You added: " + toppings);

            System.out.println("Would you like anything else? (yes/no)");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("no")) {
                System.out.println("Sandwich is in ..");
                moreToppings = false;
            }


        }




    }
}

package com.pluralsight.user;

import com.pluralsight.model.Chips;
import com.pluralsight.model.Order;
import com.pluralsight.model.enums.ChipsType;
import com.pluralsight.model.enums.DrinkSize;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChipScreen {

    static List<Chips> chips = new ArrayList<>();


    public ChipScreen(Order order) {
            Scanner scanner = new Scanner(System.in);
            Chips crisp = new Chips();

            System.out.println("What Chips would you like?");
        System.out.println(" (Lays, Doritos, Pringles) ");
            ChipsType chip = ChipsType.valueOf(scanner.nextLine().toUpperCase());
            crisp.setChips(chip);



           order.setChips(crisp);

        System.out.println("\nYou have selected a chip..\n");
    }
}

package com.pluralsight.user;

import com.pluralsight.model.Chips;
import com.pluralsight.model.Order;
import com.pluralsight.model.enums.ChipsType;
import com.pluralsight.model.enums.DrinkSize;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChipScreen {

    static List<Chips> chips = new ArrayList<>();
    private Order order;

    public ChipScreen(Order order) {
        this.order = order;
            Scanner scanner = new Scanner(System.in);
            Chips crisp = new Chips();

            System.out.println("What Chips would you like? (Lays, Doritos, Pringles ");
            ChipsType chip = ChipsType.valueOf(scanner.nextLine().toUpperCase());
            crisp.setChips(chip);

            chips.add(crisp);
    }
}

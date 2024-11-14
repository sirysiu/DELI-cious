package com.pluralsight.controller;

import com.pluralsight.model.Chips;
import com.pluralsight.model.Drink;
import com.pluralsight.model.Order;
import com.pluralsight.model.Sandwich;
import com.pluralsight.model.enums.Meat;
import com.pluralsight.model.enums.Toppings;   // Ensure correct import for Toppings
import com.pluralsight.model.enums.Sauces;     // Ensure correct import for Sauces


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;


public class ReceiptGenerator {
    private static final String RECEIPT_DIRECTORY = "/Users/sirisew/pluralsight/DELI-icous/deli-icous/src/main/resources/receipts"; // file path to create a receipt

    public static void generateReceipt(Order order) {
        File directory = new File(RECEIPT_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdirs(); // Create the directory if it doesn't exist
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "Receipt_" + timeStamp + ".txt";
        String receiptID = "REC-" + timeStamp;
        File receiptFile = new File(directory, fileName);

        try (FileWriter writer = new FileWriter(receiptFile)) {
            writer.write("********** RECEIPT **********\n");
            writer.write("Receipt ID: " + receiptID + "\n");  // Add Receipt ID here

            writer.write("Order Date: " + new Date() + "\n\n"); // create the receipts header with time and id

// Write Sandwich details
            Sandwich sandwich = order.getSandwich();  //  getSandwich() method in Order
            if (sandwich != null) {
                writer.write("Sandwich:\n");
                writer.write("Size: " + sandwich.getSize() + "\n");
                writer.write("Bread: " + sandwich.getBread() + "\n");
            }

            if (sandwich.getMeats().isEmpty()) {
                writer.write("Meats: None\n");
            } else {
                writer.write("Meats: " + String.join(", ", sandwich.getMeats().stream()
                        .map(Meat::name)// retrieves list of meats use stream to map each name
                        .collect(Collectors.toList())) + "\n");
            }

            if (sandwich.getMeats().isEmpty()){
                writer.write("Cheese: None\n");
            } else {
                writer.write("Cheeses: " + String.join(", ", sandwich.getCheeses().stream()
                        .map(cheese -> cheese.name())  // Convert each Cheese enum to its name (String)
                        .collect(Collectors.toList())) + "\n");
            }
                // Write toppings
                if (sandwich.getToppings().isEmpty()) {
                    writer.write("Toppings: None\n");
                } else {
                    writer.write("Toppings: " + String.join(", ", sandwich.getToppings().stream()
                            .map(Toppings::name)
                            .collect(Collectors.toList())) + "\n");
                }

                // Write sauces
            if (sandwich.getSauces().isEmpty()) {
                writer.write("Sauces: None\n");
            } else {
                writer.write("Sauces: " + (sandwich.getSauces().isEmpty() ? "None" : String.join(", ", sandwich.getSauces().stream()
                        .map(Sauces::name)  // Convert Sauces enum to String
                        .collect(Collectors.toList()))) + "\n");
            }
                // Write whether it's toasted
                writer.write("Toasted: " + (sandwich.isToasted() ? "Yes" : "No") + "\n");

                writer.write("Sandwich Price: $" + String.format("%.2f", sandwich.getTotalPriceSandwich(sandwich)) + "\n");



            Drink drink = order.getDrink();
            if (drink != null) {
                writer.write("Drink Size: " + drink.getDrinkType() + "\n");

                writer.write("Drink Price: $" + String.format("%.2f", drink.getDrinkPrice()) + "\n");

            }


            // Write Chips details
            Chips chips = order.getChips();
            if (chips != null) {
                writer.write("Chip Type: " + chips.getChipsType() + "\n");
                writer.write("Chip Price: $" + String.format("%.2f", chips.getChipsPrice()) + "\n\n");

            }

            double totalPrice = calculateTotalPrice(order);
            writer.write("********** TOTAL PRICE **********\n");
            writer.write("Total: " + totalPrice + "\n");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static double calculateTotalPrice(Order order) {
        double total = 0.0;

        Sandwich sandwich = order.getSandwich();
        if (sandwich != null) {
            total += sandwich.getTotalPriceSandwich(sandwich);
        }

        Drink drink = order.getDrink();
        if (drink != null) {
            total += drink.getDrinkPrice();
        }

        Chips chips = order.getChips();
        if (chips != null) {
            total += chips.getChipsPrice();
        }
        return total;

    }
}

package com.pluralsight.controller;

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
    private static final String RECEIPT_DIRECTORY = "src/main/resources/receipts";

    public static void generateReceipt(Order order) {
        File directory = new File(RECEIPT_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdir(); // Create the directory if it doesn't exist
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "Receipt_" + timeStamp + ".txt";
        File receiptFile = new File(directory, fileName);

        try (FileWriter writer = new FileWriter(receiptFile)) {
            writer.write("********** RECEIPT **********\n");
            writer.write("Order Date: " + new Date() + "\n\n");

// Write Sandwich details
            Sandwich sandwich = order.getSandwich();  // Assuming you have getSandwich() method in Order
            if (sandwich != null) {
                writer.write("Sandwich:\n");
                writer.write("Size: " + sandwich.getSize() + "\n");
                writer.write("Bread: " + sandwich.getBread() + "\n");

                writer.write("Meats: " + String.join(", ", sandwich.getMeats().stream()
                        .map(Meat::name)
                        .collect(Collectors.toList())) + "n");

                writer.write("Cheeses: " + String.join(", ", sandwich.getCheeses().stream()
                        .map(cheese -> cheese.name())  // Convert each Cheese enum to its name (String)
                        .collect(Collectors.toList())) + "\n");

                // Write toppings
                if (sandwich.getToppings().isEmpty()) {
                    writer.write("Toppings: None\n");
                } else {
                    writer.write("Toppings: " + String.join(", ", sandwich.getToppings().stream()
                            .map(Toppings::name)
                            .collect(Collectors.toList())) + "\n");
                }

                // Write sauces
                writer.write("Sauces: " + (sandwich.getSauces().isEmpty() ? "None" : String.join(", ", sandwich.getSauces().stream()
                        .map(Sauces::name)  // Convert Sauces enum to String
                        .collect(Collectors.toList()))) + "\n");

                // Write whether it's toasted
                writer.write("Toasted: " + (sandwich.isToasted() ? "Yes" : "No") + "\n");

                writer.write("Total Price: $" + String.format("%.2f", sandwich.getTotalPriceSandwich()) + "\n");


            }
            if (order.getDrinkSize() != null) {
                writer.write("Drink Size: " + order.getDrinkSize() + "\n");
            }

            if (order.getChipsType() != null) {
                writer.write("Chips Type: " + order.getChipsType() + "\n");
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

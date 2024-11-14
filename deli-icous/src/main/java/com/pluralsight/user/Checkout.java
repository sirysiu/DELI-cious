package com.pluralsight.user;
import com.pluralsight.controller.ReceiptGenerator;
import com.pluralsight.model.Chips;
import com.pluralsight.model.Drink;
import com.pluralsight.model.Order;
import com.pluralsight.model.Sandwich;

import java.util.List;
import java.util.stream.Collectors;

public class Checkout {

  private Order order;

  public Checkout(Order order) {
     this.order = order;
     printCheckoutSummary();
      ReceiptGenerator.generateReceipt(order);

  }

  private void printCheckoutSummary() {
      System.out.println("************ ORDER SUMMARY ****************");
      Sandwich sandwich = order.getSandwich();
      if (sandwich != null) {
          System.out.println("\nSandwich:");
          System.out.println("Bread: " + sandwich.getBread());
          System.out.println("Size: " + sandwich.getSize());
          System.out.println("Meats: " + joinEnumList(sandwich.getMeats()));
          System.out.println("Cheeses: " + joinEnumList(sandwich.getCheeses()));
          System.out.println("Toppings: " + (sandwich.getToppings().isEmpty() ? "None" : joinEnumList(sandwich.getToppings())));
          System.out.println("Sauces: " + (sandwich.getSauces().isEmpty() ? "None" : joinEnumList(sandwich.getSauces())));
          System.out.println("Toasted: " + (sandwich.isToasted() ? "Yes" : "No"));
          System.out.println("Sandwich Price: $" + String.format("%.2f", sandwich.getTotalPriceSandwich()));
      }
      Drink drink = order.getDrink();
      if (drink != null) {
          System.out.println("\nDrink:");
         System.out.println("Drink Type: " + drink.getDrinkType());  // Assuming you have getDrinkType() method in Drink class
          System.out.println("Drink Size: " + drink.getDrink());  // Assuming Drink has a size
          System.out.println("Drink Price: $" + String.format("%.2f", drink.getDrinkPrice()));
      }

      Chips chips = order.getChips();
      if (chips != null) {
          System.out.println("\nChips:");
          System.out.println("Chips Type: " + chips.getChipsType());
          System.out.println("Chips Price: $" + String.format("%.2f", chips.getChipsPrice()));
      }
      // Print the total price
      System.out.println("\nTotal Price: $" + String.format("%.2f", order.getOrderTotalPrice()));
      System.out.println("************************************");
  }

    // Utility method to join enum lists (for meats, cheeses, toppings, sauces)
    private String joinEnumList(List<? extends Enum<?>> list) {
        return list.stream()
                .map(Enum::name) // Convert each enum to its name (String representation)
                .collect(Collectors.joining(", "));  // Join them with commas
    }
  }




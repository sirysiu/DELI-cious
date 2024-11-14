package com.pluralsight.user;
import com.pluralsight.controller.ReceiptGenerator;
import com.pluralsight.model.Chips;
import com.pluralsight.model.Drink;
import com.pluralsight.model.Order;
import com.pluralsight.model.Sandwich;

public class Checkout {

  private Order order;

  public Checkout(Order order) {
     this.order = order;
 // SandwichCheckout();
//    DrinkCheckout();
//   ChipsCheckout();
      ReceiptGenerator.generateReceipt(order);

  }

//  private void ChipsCheckout() {
//      for (Chips c : ChipScreen.chips){
//          System.out.println("Chips is: " + c.getChipsPrice());
//      }
//  }
//  private void DrinkCheckout() {
//    for (Drink d : DrinkScreen.drink) {
//        System.out.println("Your Drink: " + d.getDrinkPrice());
//    }
//  }

//  private void SandwichCheckout() {
//    for (Sandwich sandwich : SandwichScreen.sandwichOrderList) {
//
//      System.out.println("********ORDER SUMMARY************");
//      System.out.println("Sandwich: ");
//      System.out.println("Bread: " + sandwich.getBread());
//      System.out.println("Size: " + sandwich.getSize());
//      System.out.println("Meats: " + sandwich.getMeats());
//      System.out.println("Cheeses: " + sandwich.getCheeses());
//      System.out.println("Toppings: " + sandwich.getToppings());
//      System.out.println("Sauces: " + sandwich.getSauces());
//      System.out.println("Toasted: " + (sandwich.isToasted() ? "Yes" : "No"));
//
//      System.out.println("Total Price: " + sandwich.getTotalPriceSandwich());
//    }
//  }

}

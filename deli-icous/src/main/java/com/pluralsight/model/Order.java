package com.pluralsight.model;

import java.util.List;

public class Order {
    private List<Product> products;
    private String customerName;
    private String orderNumber;

    public List<Product> getProducts() {
        return products;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public Order(List<Product> products, String customerName, String orderNumber) {
        this.products = products;
        this.customerName = customerName;
        this.orderNumber = orderNumber;
    }
}

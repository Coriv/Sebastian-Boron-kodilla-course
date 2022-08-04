package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.Map;

public class OrderProcessing {

    void processOrder(Supplier supplier, String product, int quantity) {
        Map<String, Integer> map = supplier.getAvailableProducts();
        boolean order = supplier.checkProductAvailability(map, product);
        if(order) {
            if(quantity <= supplier.checkQuantity(map, product)) {
                supplier.process();
            } else {
                System.out.println("We do not have enough goods, do you want to re-order?");
            }
        } else {
            System.out.println("Our supplier does not have " + product);
        }
    }
}

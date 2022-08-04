package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.Map;

public interface Supplier {
    void process();
    Map<String, Integer> getAvailableProducts();
    default boolean checkProductAvailability(Map<String, Integer> availableProducts, String product) {
        return availableProducts.containsKey(product);
    }
    default int checkQuantity(Map<String, Integer> availableProducts, String product) {
        return availableProducts.get(product);
    }
}

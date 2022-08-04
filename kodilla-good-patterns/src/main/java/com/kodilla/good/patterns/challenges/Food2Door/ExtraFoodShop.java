package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.Map;

public class ExtraFoodShop implements Supplier {

    final private String supplier = "Extra Food Shop";
    private Map<String, Integer> availableProducts;

    public ExtraFoodShop(Map<String, Integer> availableProducts) {
        this.availableProducts = availableProducts;
    }

    @Override
    public void process() {
        System.out.println("Shop " + getSupplier() + " is preparing your order");
        System.out.println("OUR PRODUCTS ARE THE FRESHEST!\n");
    }
    public String getSupplier() {
        return supplier;
    }
    @Override
    public Map<String, Integer> getAvailableProducts() {
        return availableProducts;
    }
}

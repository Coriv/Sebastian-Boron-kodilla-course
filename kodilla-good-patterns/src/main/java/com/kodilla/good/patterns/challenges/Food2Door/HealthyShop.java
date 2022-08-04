package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.Map;

public class HealthyShop implements Supplier{

    private final String supplier = "HealthyShop";
    private Map<String, Integer> availableProducts;

    public HealthyShop(Map<String, Integer> availableProducts) {
        this.availableProducts = availableProducts;
    }
    @Override
    public void process() {
        System.out.println("Shop " + getSupplier() + " is preparing your order");
        System.out.println("WE KNOW HOW TO CARE ABOUT YOUR HEALTH!\n");
    }
    public String getSupplier() {
        return supplier;
    }
    @Override
    public Map<String, Integer> getAvailableProducts() {
        return availableProducts;
    }
}

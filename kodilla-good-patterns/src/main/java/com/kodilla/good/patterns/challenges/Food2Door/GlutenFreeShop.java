package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.Map;

public class GlutenFreeShop implements Supplier{

    private final String supplier = "Gluten Free Shop";
    private Map<String, Integer> availableProducts;

    public GlutenFreeShop(Map<String, Integer> availableProducts) {
        this.availableProducts = availableProducts;
    }

    public String getSupplier() {
        return supplier;
    }

    @Override
    public void process() {
        System.out.println("Shop " + getSupplier() + " is preparing your order");
        System.out.println("OUR SHOP IS THE BEST!\n");
    }
    @Override
    public Map<String, Integer> getAvailableProducts() {
        return availableProducts;
    }
}

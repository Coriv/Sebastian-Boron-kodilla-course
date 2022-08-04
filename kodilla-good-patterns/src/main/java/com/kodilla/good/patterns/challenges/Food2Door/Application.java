package com.kodilla.good.patterns.challenges.Food2Door;

public class Application {
    public static void main(String[] args) {

        OrderProcessing orderProcessing = new OrderProcessing();
        Supplier supplier1 = new ExtraFoodShop(MapGenerator.mapGenerator());
        Supplier supplier2 = new HealthyShop(MapGenerator.mapGenerator());
        Supplier supplier3 = new GlutenFreeShop(MapGenerator.mapGenerator());

        orderProcessing.processOrder(supplier1, "Tomato", 30);
        orderProcessing.processOrder(supplier2, "Beer", 456);
        orderProcessing.processOrder(supplier3, "Bread", 52);
    }
}

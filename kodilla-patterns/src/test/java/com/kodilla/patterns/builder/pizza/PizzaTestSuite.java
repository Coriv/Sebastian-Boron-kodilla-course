package com.kodilla.patterns.builder.pizza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PizzaTestSuite {

    @Test
    void testPizzaNew() {
        Pizza pizza = new Pizza.PizzaBuilder()
                .ingredients("Onion")
                .bottom("Thin")
                .sauce("Spicy")
                .ingredients("Ham")
                .ingredients("Mushroom")
                .build();
        System.out.println(pizza);

        int howManyIngredients = pizza.getIngredients().size();

        assertEquals(3, howManyIngredients);
    }
}

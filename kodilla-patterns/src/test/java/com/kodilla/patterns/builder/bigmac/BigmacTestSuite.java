package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    void testBigmacBuilder() {

        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("With sesame seeds")
                .burgers(3)
                .sauce("Garlic")
                .ingredient("Cheese")
                .ingredient("Onion")
                .ingredient("Cucumber")
                .ingredient("Tomato")
                .build();

        int numberOfBurgers = bigmac.getBurgers();
        String typeOfBun = bigmac.getBun();
        String typeOfSauce = bigmac.getSauce();
        int numbersOfIngredients = bigmac.getIngredients().size();

        assertEquals(3, numberOfBurgers);
        assertEquals("With sesame seeds", typeOfBun);
        assertEquals("Garlic", typeOfSauce);
        assertEquals(4, numbersOfIngredients);
    }
}

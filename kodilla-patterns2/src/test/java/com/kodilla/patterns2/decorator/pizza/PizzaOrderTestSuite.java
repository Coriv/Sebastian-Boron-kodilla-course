package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


class PizzaOrderTestSuite {

    @Test
    public void pizzaWithExtraCheeseAndGarlicSauce() {
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new GarlicSauceDecorator(theOrder);

        BigDecimal theCost = theOrder.getCost();
        String desc = theOrder.getDescription();

        System.out.println(theOrder.getDescription());

        assertEquals(new BigDecimal(14), theCost);
        assertEquals("Your order: Italy pizza with tomato sauce, extra cheese, garlic sauce", desc);
    }

    @Test
    public void pizzaWithExtraCheeseTunaSalamiAndChiliSauce() {
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new TunaDecorator(theOrder);
        theOrder = new SalamiDecorator(theOrder);
        theOrder = new ChiliSauceDecorator(theOrder);

        BigDecimal theCost = theOrder.getCost();
        String desc = theOrder.getDescription();

        assertEquals(new BigDecimal(20), theCost);
        assertEquals("Your order: Italy pizza with tomato sauce, extra cheese, tuna, salami, chili", desc);
    }

    @Test
    public void pizzaWithMushroomDoubleSalamiAndDoubleSauce() {
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new MushroomDecorator(theOrder);
        theOrder = new SalamiDecorator(theOrder);
        theOrder = new SalamiDecorator(theOrder);
        theOrder = new GarlicSauceDecorator(theOrder);
        theOrder = new ChiliSauceDecorator(theOrder);

        BigDecimal theCost = theOrder.getCost();
        String desc = theOrder.getDescription();

        assertEquals(new BigDecimal(20), theCost);
        assertEquals("Your order: Italy pizza with tomato sauce, mushroom, salami, salami, garlic sauce, chili", desc);
    }
}
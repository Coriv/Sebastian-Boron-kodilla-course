package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class AbstractBasicPizzaDecorator implements PizzaOrder{

    private final PizzaOrder pizzaOrder;

    protected AbstractBasicPizzaDecorator(PizzaOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    @Override
    public BigDecimal getCost() {
        return pizzaOrder.getCost();
    }

    @Override
    public String getDescription() {
        return pizzaOrder.getDescription();
    }
}

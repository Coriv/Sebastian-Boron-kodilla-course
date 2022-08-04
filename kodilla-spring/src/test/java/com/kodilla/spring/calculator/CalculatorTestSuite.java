package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;
    private double a = 3.0;
    private double b = 7.0;

    @Test
    void testCalculations() {
        assertEquals(calculator.add(a,b), 10.0);
        assertEquals(calculator.sub(a, b), -4.0);
        assertEquals(calculator.mul(a,b), 21.0);
        assertEquals(calculator.div(a,b), 0.4285, 0.0001);
    }
}

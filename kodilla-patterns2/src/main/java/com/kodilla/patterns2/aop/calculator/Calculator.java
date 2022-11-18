package com.kodilla.patterns2.aop.calculator;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@EnableAspectJAutoProxy
public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }
    public double sub(double a, double b) {
        return a - b;
    }
    public double multiply(double a, double b) {
        return a * b;
    }
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Divide by 0");
        }
        return a/b;
    }

    public BigDecimal factorial(BigDecimal n) {
        if (n.compareTo(BigDecimal.ONE) > 0) {
            return n.multiply(factorial(n.subtract(BigDecimal.ONE)));
        } else if (n.equals(BigDecimal.ONE) || n.equals(BigDecimal.ZERO)) {
            return BigDecimal.ONE;
        } else {
            throw new ArithmeticException("Factorial argument is negative");
        }
    }
}


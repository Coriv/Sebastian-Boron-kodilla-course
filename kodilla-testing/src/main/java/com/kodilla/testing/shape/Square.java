package com.kodilla.testing.shape;

public class Square implements Shape{

    private String name;
    private double filed;

    public Square(String name, double a) {
        this.name = name;
        this.filed = a*a;
    }

    @Override
    public String getShapeName() {
        return this.name;
    }

    @Override
    public double getField() {
        return this.filed;
    }
}

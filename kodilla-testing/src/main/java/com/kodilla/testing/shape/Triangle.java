package com.kodilla.testing.shape;

public class Triangle implements Shape{
    private String name;
    private double filed;

    public Triangle(String name, double a, double h) {
        this.name = name;
        this.filed = (a*h)/2;
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


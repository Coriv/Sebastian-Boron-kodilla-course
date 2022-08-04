package com.kodilla.testing.shape;

public class Circle implements Shape{
    private String name;
    private double filed;

    public Circle(String name, double range){
        this.name = name;
        this.filed = range*range*Math.PI;
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
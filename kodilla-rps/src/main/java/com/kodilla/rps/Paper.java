package com.kodilla.rps;

public class Paper implements Move{
    final String name = "Paper";
    final int value = 1;

    public String getName() {
        return name;
    }
    @Override
    public int getValue() {
        return value;
    }
}

package com.kodilla.rps;

public class Lizard implements Move{
    final String name = "Lizard";
    final int value = 4;

    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return value;
    }
}
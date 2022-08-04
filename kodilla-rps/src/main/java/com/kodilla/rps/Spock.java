package com.kodilla.rps;

public class Spock implements Move {

    final String name = "Spock";
    final int value = 4;

    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return value;
    }
}
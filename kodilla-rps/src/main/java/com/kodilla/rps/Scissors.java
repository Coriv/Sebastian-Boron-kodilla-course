package com.kodilla.rps;

public class Scissors implements Move{

   final String name = "Scisscors";
    final int value = 2;

    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return value;
    }
}

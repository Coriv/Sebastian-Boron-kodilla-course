package com.kodilla.stream.world;

import java.util.HashSet;
import java.util.Set;

public final class Continent {

    private final Set<Country> listOfCountry = new HashSet<>();
    private final String name;

    public Continent(final String name) {
        this.name = name;
    }

    public Set<Country> getListOfCountry() {
        return listOfCountry;
    }

    public void addCountry(Country country) {
        listOfCountry.add(country);
    }
}

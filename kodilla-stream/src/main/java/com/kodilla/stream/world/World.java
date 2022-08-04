package com.kodilla.stream.world;


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public final class World {

    private final Set<Continent> listOfContinent = new HashSet<>();

    public BigDecimal getPeopleQuantity() {
        BigDecimal peopleQuantity = listOfContinent.stream()
                .flatMap(continent -> continent.getListOfCountry().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
        return peopleQuantity;
    }

    public void addContinent(Continent continent) {
        listOfContinent.add(continent);
    }

}

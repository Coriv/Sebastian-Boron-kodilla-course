package com.kodilla.stream.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class WorldTestSuite {

    @DisplayName("World Test Suite")
    @Test
    void testGetPeopleQuantity() {


        Country poland = new Country(new BigDecimal("3800000000"), "Poland");
        Country netherland = new Country(new BigDecimal("3800000000"), "Netherland");
        Country germany = new Country(new BigDecimal("78000000"), "Germany");
        Country france = new Country(new BigDecimal("540000000"), "France");
        Country italy = new Country(new BigDecimal("3445550000"), "Italy");
        Country spain = new Country(new BigDecimal("345213455"), "Spain");

        Continent europe = new Continent("Europe");
        europe.addCountry(poland);
        europe.addCountry(netherland);
        europe.addCountry(germany);
        europe.addCountry(france);
        europe.addCountry(italy);
        europe.addCountry(spain);

        Country nigeria = new Country(new BigDecimal("344423455"), "Nigeria");
        Country ethiopia = new Country(new BigDecimal("436562244"), "Ethiopia");
        Country egypy = new Country(new BigDecimal("565323441"), "Egypt");
        Country congo = new Country(new BigDecimal("785643352"), "congo");

        Continent africa = new Continent("Africa");
        africa.addCountry(nigeria);
        africa.addCountry(egypy);
        africa.addCountry(ethiopia);;
        africa.addCountry(congo);

        World world = new World();
        world.addContinent(europe);
        world.addContinent(africa);

        BigDecimal worldPeopleQuantity = world.getPeopleQuantity();

        Assertions.assertEquals(new BigDecimal("14140715947") , worldPeopleQuantity);


    }
}

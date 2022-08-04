package com.kodilla.good.patterns.challenges.FlightSearchEngine;

import javax.xml.crypto.Data;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        DataGenerator.generateDate();
        SearchFlightEngine engine = new SearchFlightEngine();

        Airport airport = DataGenerator.listOfAirport.get(new Random().nextInt(DataGenerator.listOfAirport.size()));

        engine.findAllFlightsFromTheAirport(airport);
        engine.finnAllAirportsWithFlightTo(airport);
        engine.findConnectingFlights(airport, airport);
    }
}

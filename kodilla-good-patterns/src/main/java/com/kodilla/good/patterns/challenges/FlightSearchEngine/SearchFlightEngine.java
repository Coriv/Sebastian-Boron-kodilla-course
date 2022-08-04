package com.kodilla.good.patterns.challenges.FlightSearchEngine;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SearchFlightEngine {
    Database database = Database.getInstance();

    Set<Airport> prepareSetFrom(Airport airport) {
        Set<Airport> setFrom = database.getMapOfFlights().entrySet().stream()
                .filter(n -> n.getKey().equals(airport))
                .map(n -> n.getValue())
                .flatMap(n -> n.stream())
                .collect(Collectors.toSet());

        return setFrom;
    }

    Set<Airport> prepareSetTo(Airport airport) {
        Set<Airport> setTo = database.getMapOfFlights().entrySet().stream()
                .filter(n -> n.getValue().contains(airport))
                .map(n -> n.getKey())
                .collect(Collectors.toSet());

        return setTo;
    }
    public void findAllFlightsFromTheAirport(Airport airport) {
        System.out.println("Find all flights from the airport: " + airport);

        prepareSetFrom(airport).stream()
                .forEach(System.out::println);
    }

    public void finnAllAirportsWithFlightTo(Airport airport) {
        System.out.println("Find all airports with flight to: " + airport);

        prepareSetTo(airport).stream()
                .forEach(System.out::println);
    }

    public void findConnectingFlights(Airport airport, Airport airport2){
        Set<Airport> connectingFlightFrom = new HashSet<>(prepareSetFrom(airport));
        Set<Airport> connectingFlightTo = new HashSet<>(prepareSetTo(airport2));
        connectingFlightFrom.retainAll(connectingFlightTo);

        System.out.println("To flight from: " + airport + " to: " + airport2 + " you can flight via airports: " + connectingFlightFrom);
    }
}

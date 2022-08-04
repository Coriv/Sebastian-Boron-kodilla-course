package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearchEngine {
    public void findFilght(Flight flight) throws RouteNotFoundException{
        Map<String, Boolean> mapOfFlights = new HashMap<>();

        Flight flight1 = new Flight("Tokio", "Berlin");
        Flight flight2 = new Flight("Amsetredam", "Warsaw");

        mapOfFlights.put(flight1.getArrivalAirport(), true);
        mapOfFlights.put(flight2.getArrivalAirport(), true);
        mapOfFlights.put(flight1.getDepartureAirport(),false );
        mapOfFlights.put(flight2.getDepartureAirport(), false);

        if(mapOfFlights.get(flight.getArrivalAirport()) != null)
        System.out.println("Flight found. From: " + mapOfFlights.get(flight.getDepartureAirport()) + " to: " + mapOfFlights.get(flight.getArrivalAirport()));
        else throw new RouteNotFoundException();
    }
}

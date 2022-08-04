package com.kodilla.good.patterns.challenges.FlightSearchEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Database {
    private static Database database;
    private static Map<Airport, Set<Airport>> mapOfFlights = new HashMap<>();
    private Database(){}
    public static Database getInstance() {
        if(Database.database == null) {
            database = new Database();
        }
        return database;
    }
    public void addAirportConnections(Airport airport) {
        mapOfFlights.put(airport, airport.getNetworkConnections());
    }

    public Map<Airport, Set<Airport>> getMapOfFlights() {
        return mapOfFlights;
    }
}

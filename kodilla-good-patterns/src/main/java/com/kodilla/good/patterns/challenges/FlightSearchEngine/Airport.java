package com.kodilla.good.patterns.challenges.FlightSearchEngine;

import java.util.HashSet;
import java.util.Set;

public class Airport {
    private String name;
    private Set<Airport> networkConnections = new HashSet<>();
    public Airport(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public Set<Airport> getNetworkConnections() {
        return networkConnections;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;

        Airport airport = (Airport) o;

        return name.equals(airport.name);
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }
    @Override
    public String toString() {
        return this.name;
    }

    public void setNetworkConnections(Set<Airport> networkConnections) {
        this.networkConnections = networkConnections;
    }
}

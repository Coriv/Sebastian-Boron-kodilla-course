package com.kodilla.exception.test;

public class FlightRunner {
    public static void main(String[] args) {
        Flight flight = new Flight("Tokio", "Helsinki");
        Flight flight2 = new Flight("Amsterdam", "Berlin");
        Flight flight3 = new Flight("Warsaw", "Paris");

        FlightSearchEngine flightSearchEngine = new FlightSearchEngine();


        try {
            flightSearchEngine.findFilght(flight);
        } catch (RouteNotFoundException ex) {
            System.out.println("Flight you are looking for does not exist");
        }

        try {
            flightSearchEngine.findFilght(flight2);
        } catch (RouteNotFoundException ex) {
            System.out.println("Flight you are looking for does not exist");
        }
        try {
            flightSearchEngine.findFilght(flight3);
        } catch (RouteNotFoundException ex) {
            System.out.println("Flight you are looking for does not exist");
        }
    }
}

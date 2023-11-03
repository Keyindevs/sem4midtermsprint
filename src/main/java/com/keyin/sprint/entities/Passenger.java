package com.keyin.sprint.entities;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    // need attributes of firstname last name hometown and an id
    private final String firstName;
    private final String lastName;
    private final String homeTown;
    private List<Flight> flights;

    public Passenger(String firstName, String lastName, String homeTown) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeTown = homeTown;
    }

    public Passenger(String firstName, String lastName, String homeTown, List<Flight> flights) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeTown = homeTown;
        this.flights = flights;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public List<String> getAircraftFromFlights() {
        List<String> aircraft = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight != null) {
                aircraft.add(flight.getAircraft());
            }
        }
        return aircraft;
    }

    public void setFlight(Flight flight) {
        this.flights.add(flight);
    }

    public List<Flight> getFlights() {
    	return flights;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", firstName, lastName, homeTown, getFlights().toString());
    }

}

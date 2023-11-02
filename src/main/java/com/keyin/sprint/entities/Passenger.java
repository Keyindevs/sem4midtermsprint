package com.keyin.sprint.entities;

import java.util.List;

public class Passenger {
    // need attributes of firstname last name hometown and an id
    private final String firstName;
    private final String lastName;
    private String homeTown;

    private List<Flight> flights;

    public Passenger(String firstName, String lastName, String homeTown) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeTown = homeTown;

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

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public void setFlight(Flight flight) {
    	this.flights.add(flight);
    }

    public List<Flight> getFlights() {
    	return flights;
    }

}

package com.keyin.sprint.entities;

import com.keyin.sprint.APIRoutes;
import com.keyin.sprint.DataLayer;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    // need attributes of firstname last name hometown and an id
    private final String firstName;
    private final String lastName;
    private final String homeTown;
    private List<String> flights;
    private List<String> aircraft = new ArrayList<>();

    public Passenger(String firstName, String lastName, String homeTown) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeTown = homeTown;
        this.flights = new ArrayList<>();
    }

    public Passenger(String firstName, String lastName, String homeTown, List<String> flights) {
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
        for (String flight : flights) {
            if (APIRoutes.getFlightById(flight) != null) {
                aircraft.add(APIRoutes.getFlightById(flight).getAircraft());
            }
        }
        return aircraft;
    }

    public void setFlight(String flight) {
        this.flights.add(flight);
    }

    public List<String> getFlights() {
    	return flights;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", firstName, lastName, homeTown, getFlights().toString());
    }

    public void setFlight(Flight flight) {
        this.flights.add(flight.getId());
    }
}

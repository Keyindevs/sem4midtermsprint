package com.keyin.sprint.entities;


import java.util.ArrayList;
import java.util.List;

public class Airport {
    private String name;
    private String code;
    private final String city;
    private final List<Aircraft> onPremisePlanes = new ArrayList<>();;
    private List<Passenger> onPremisePassengers = new ArrayList<>();
    private final List<Flight> flightsIn = new ArrayList<>();
    private final List<Flight> flightsOut = new ArrayList<>();

    public Airport(String name, String code, String City) {
        this.name = name;
        this.code = code;
        this.city = City;
    }

    // Getters and setters for the fields

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Aircraft> getOnPremisePlanes() {
        return onPremisePlanes;
    }

    public void setOnPremisePlanes(Aircraft aircraft) {
        this.onPremisePlanes.add(aircraft);
    }

    public List<Passenger> getOnPremisePassengers() {
        return onPremisePassengers;
    }

    public void setOnPremisePassengers(List<Passenger> onPremisePassengers) {
        this.onPremisePassengers = onPremisePassengers;
    }

    public String getCity() {
        return city;
    }

    public void addFlightIn(Flight flight) {
        this.flightsIn.add(flight);
    }

    public List<Flight> getFlightsIn() {
        return flightsIn;
    }

    public void addFlightOut(Flight flight) {
        this.flightsOut.add(flight);
    }

    public List<Flight> getFlightsOut() {
        return flightsOut;
    }

}

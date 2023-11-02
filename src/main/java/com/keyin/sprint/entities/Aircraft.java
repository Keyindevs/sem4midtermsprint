package com.keyin.sprint.entities;

import java.util.ArrayList;
import java.util.List;

public class Aircraft {
    private String id;
    private String type;
    private String airlineName;
    private final List<Passenger> BoardedPassengers = new ArrayList<>();
    private int numberOfPassengers;

    private String airport;

    public Aircraft(String id,String type, String airlineName, int numberOfPassengers, String airport) {
        this.id = id;
        this.type = type;
        this.airlineName = airlineName;
        this.numberOfPassengers = numberOfPassengers;
        this.airport = airport;
    }

    public Aircraft(String id, String type, String airlineName, int numberOfPassengers) {
        this.id = id;
        this.type = type;
        this.airlineName = airlineName;
        this.numberOfPassengers = numberOfPassengers;
        this.airport = null;
    }


    // Getters and setters for the fields

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public void addPassenger(Passenger passenger) {
        this.BoardedPassengers.add(passenger);
    }

    public List<Passenger> getBoardedPassengers() {
        return BoardedPassengers;
    }

    public void setAirport(String airport) {
    	this.airport = airport;
    }

    public String getAirport() {
    	return airport;
    }
}

package com.keyin.sprint.entities;

import java.util.ArrayList;
import java.util.List;

public class Aircraft {
    private int id;
    private String type;
    private String airlineName;
    private final List<Passenger> BoardedPassengers = new ArrayList<>();
    private int numberOfPassengers;

    public Aircraft(int id, String type, String airlineName, int numberOfPassengers) {
        this.id = id;
        this.type = type;
        this.airlineName = airlineName;
        this.numberOfPassengers = numberOfPassengers;
    }



    // Getters and setters for the fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}

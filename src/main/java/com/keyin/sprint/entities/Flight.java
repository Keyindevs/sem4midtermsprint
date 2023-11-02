package com.keyin.sprint.entities;

public class Flight {

    private final String id;
    private final String origin;
    private final String destination;
    private final String aircraft;

    public Flight(String origin,String destination,String aircraft,String id) {
        this.origin = origin;
        this.aircraft = aircraft;
        this.destination = destination;
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public String getAircraft() {
        return aircraft;
    }

    public String getDestination() {
        return destination;
    }

    public String getId() {
        return id;
    }
}

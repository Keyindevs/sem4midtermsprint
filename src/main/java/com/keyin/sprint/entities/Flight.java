package com.keyin.sprint.entities;

public class Flight {

    private String id;
    private Airport origin;

    private  Airport destination;
    private Aircraft aircraft;

    public Flight(Airport origin,Airport destination,Aircraft aircraft,String id) {
        this.origin = origin;
        this.aircraft = aircraft;
        this.destination = destination;
        this.id = id;
    }

    public Airport getOrigin() {
        return origin;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public Airport getDestination() {
        return destination;
    }

    public String getId() {
        return id;
    }
}

package com.keyin.sprint.entities;


import java.util.List;

public class Airport {
    private int id;
    private String name;
    private String code;
    private List<Aircraft> onPremisePlanes;
    private List<Passenger> onPremisePassengers;
    private List<Passenger> exPassengers;

    public Airport(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    // Getters and setters for the fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public void setOnPremisePlanes(List<Aircraft> onPremisePlanes) {
        this.onPremisePlanes = onPremisePlanes;
    }

    public List<Passenger> getOnPremisePassengers() {
        return onPremisePassengers;
    }

    public void setOnPremisePassengers(List<Passenger> onPremisePassengers) {
        this.onPremisePassengers = onPremisePassengers;
    }

    public List<Passenger> getExPassengers() {
        return exPassengers;
    }

    public void setExPassengers(List<Passenger> exPassengers) {
        this.exPassengers = exPassengers;
    }
}

package com.keyin.sprint.entities;


import java.util.ArrayList;
import java.util.List;

public class Airport {
    private int id;
    private String name;
    private String code;
    private String city;
    private final List<Aircraft> onPremisePlanes = new ArrayList<>();;
    private List<Passenger> onPremisePassengers = new ArrayList<>();
    private List<Passenger> exPassengers = new ArrayList<>();;

    public Airport(int id, String name, String code, String City) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.city = City;
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

    public void setOnPremisePlanes(Aircraft aircraft) {
        this.onPremisePlanes.add(aircraft);
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

    public String getCity() {
        return city;
    }

    public void setCity(String City) {
        this.city = City;
    }

}

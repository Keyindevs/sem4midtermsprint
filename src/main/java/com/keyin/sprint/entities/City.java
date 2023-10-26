package com.keyin.sprint.entities;

import java.util.ArrayList;

public class City {
    private int id;
    private String name;
    private String state;
    private int population;

    private final ArrayList<Airport> airports;

    public City(int id, String name, String state, int population, ArrayList<Airport> airports) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.population = population;
        this.airports = airports;
    }

    public City(int id, String name, String state, int population) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.population = population;
        this.airports = new ArrayList<>();
    }

    // Getters and setters for the fields

    public void setAirport(Airport airport) {
        this.airports.add(airport);
    }

    public ArrayList<Airport> getAirports() {
        return airports;
    }

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}

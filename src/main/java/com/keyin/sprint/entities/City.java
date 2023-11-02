package com.keyin.sprint.entities;

import java.util.ArrayList;

public class City {
    private int id;
    private String name;
    private String state;
    private int population;
    public ArrayList<Airport> airports;
    private final ArrayList<Passenger> habitants = new ArrayList<>();

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

    public String display() {
        return String.format("%s, ID: %d, State: %s, Population: %d", this.name, this.id, this.state, this.population);
    }

    // Getters and setters for the fields

    public ArrayList<Passenger> getHabitants() {
        return habitants;
    }

    public void addHabitant(Passenger passenger) {
        this.habitants.add(passenger);
    }

    public void addAirport(Airport airport) {
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

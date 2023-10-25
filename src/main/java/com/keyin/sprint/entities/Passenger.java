package com.keyin.sprint.entities;

public class Passenger {
    // need attributes of firstname last name hometown and an id
    private String firstName;
    private String lastName;
    private String homeTown;
    private int id;

    public Passenger(String firstName, String lastName, String homeTown, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeTown = homeTown;
        this.id = id;
    }
}

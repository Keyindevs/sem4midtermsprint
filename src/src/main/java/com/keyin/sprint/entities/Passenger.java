package com.keyin.sprint.entities;

public class Passenger {
    // need attributes of firstname last name hometown and an id
    private final String firstName;
    private final String lastName;
    private final String homeTown;
    private final int id;

    public Passenger(String firstName, String lastName, String homeTown, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeTown = homeTown;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public int getId() {
        return id;
    }
}

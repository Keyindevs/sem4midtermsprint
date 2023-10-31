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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

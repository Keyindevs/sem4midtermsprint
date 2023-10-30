package com.keyin.sprint;

import com.keyin.sprint.entities.Airport;
import com.keyin.sprint.entities.Aircraft;
import com.keyin.sprint.entities.Passenger;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AirportTest {

    private Airport airport;

    @Before
    public void setUp() {
        airport = new Airport(1, "International Airport", "ITP");
    }

    @Test
    public void testAirportId() {
        assertEquals(1, airport.getId());
    }

    @Test
    public void testAirportName() {
        assertEquals("International Airport", airport.getName());
    }

    @Test
    public void testAirportCode() {
        assertEquals("ITP", airport.getCode());
    }

    @Test
    public void testOnPremisePlanes() {
        airport.setOnPremisePlanes(new Aircraft(0, "Default", "test", 0));
        assertEquals("test", airport.getOnPremisePlanes().get(0).getAirlineName());
    }

    @Test
    public void testOnPremisePassengers() {
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger("John", "Doe", "New York", 1));
        passengers.add(new Passenger("Jane", "Smith", "Los Angeles", 2));
        airport.setOnPremisePassengers(passengers);
        assertEquals(2, airport.getOnPremisePassengers().size());
    }

    @Test
    public void testExPassengers() {
        List<Passenger> exPassengers = new ArrayList<>();
        exPassengers.add(new Passenger("Alice", "Johnson", "Chicago", 3));
        exPassengers.add(new Passenger("Bob", "Anderson", "Houston", 4));
        airport.setExPassengers(exPassengers);
        assertEquals(2, airport.getExPassengers().size());
    }
}




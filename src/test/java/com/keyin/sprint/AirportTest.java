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
        airport = new Airport("Test", "TST","TestTST");
    }

    @Test
    public void testAirportName() {
        assertEquals("Test", airport.getName());
    }

    @Test
    public void testAirportCode() {
        assertEquals("TST", airport.getCode());
    }

    @Test
    public void testOnPremisePlanes() {
        airport.setOnPremisePlanes(new Aircraft("AK234", "Default", "test", 0));
        assertEquals("test", airport.getOnPremisePlanes().get(0).getAirlineName());
    }
}




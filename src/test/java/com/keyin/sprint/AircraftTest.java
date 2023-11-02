package com.keyin.sprint;

import com.keyin.sprint.entities.Aircraft;
import org.junit.Test;
import static org.junit.Assert.*;

public class AircraftTest {
    @Test
    public void testAircraftConstructorAndGetters() {
        Aircraft aircraft = new Aircraft("3KL9Y", "Boeing 747", "Emirates", 400);

        assertEquals("3KL9Y", aircraft.getId());
        assertEquals("Boeing 747", aircraft.getType());
        assertEquals("Emirates", aircraft.getAirlineName());
        assertEquals(400, aircraft.getNumberOfPassengers());
    }

    @Test
    public void testAircraftSetters() {
        Aircraft aircraft = new Aircraft("AK234", "Airbus A380", "Lufthansa", 500);

        aircraft.setId("AK234");
        aircraft.setType("Boeing 777");
        aircraft.setAirlineName("Delta");
        aircraft.setNumberOfPassengers(300);

        assertEquals("3KL9Y", aircraft.getId());
        assertEquals("Boeing 777", aircraft.getType());
        assertEquals("Delta", aircraft.getAirlineName());
        assertEquals(300, aircraft.getNumberOfPassengers());
    }
}


package com.keyin.sprint;

import com.keyin.sprint.entities.Passenger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassengerTest {
    @Test
    public void testPassengerAttributes() {
        Passenger passenger = new Passenger("John", "Doe", "New York");

        assertEquals("John", passenger.getFirstName());
        assertEquals("Doe", passenger.getLastName());
        assertEquals("New York", passenger.getHomeTown());
    }
}

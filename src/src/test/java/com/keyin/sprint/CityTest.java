package com.keyin.sprint;

import com.keyin.sprint.entities.City;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CityTest {
    @Test
    public void testCityProperties() {
        City city = new City(1, "New York", "New York State", 8623000);

        assertEquals(1, city.getId());
        assertEquals("New York", city.getName());
        assertEquals("New York State", city.getState());
        assertEquals(8623000, city.getPopulation());
    }

    @Test
    public void testCitySetters() {
        City city = new City(1, "Los Angeles", "California", 3990456);

        city.setId(2);
        city.setName("San Francisco");
        city.setState("California");
        city.setPopulation(883305);

        assertEquals(2, city.getId());
        assertEquals("San Francisco", city.getName());
        assertEquals("California", city.getState());
        assertEquals(883305, city.getPopulation());
    }
}

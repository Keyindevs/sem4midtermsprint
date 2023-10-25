package com.keyin.sprint;

import com.keyin.sprint.entities.City;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class CityTest {

    @Spy
    @InjectMocks
    private City city;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCityId() {
        city.setId(1L);
        assertEquals(1L, city.getId().longValue());
    }

    @Test
    public void testCityName() {
        city.setName("New York");
        assertEquals("New York", city.getName());
    }

    @Test
    public void testCityState() {
        city.setState("NY");
        assertEquals("NY", city.getState());
    }

    @Test
    public void testCityPopulation() {
        city.setPopulation(1000000);
        assertEquals(1000000, city.getPopulation().intValue());
    }

    @Test
    public void testCityEmptyValues() {
        assertNull(city.getId());
        assertNull(city.getName());
        assertNull(city.getState());
        assertNull(city.getPopulation());
    }
}

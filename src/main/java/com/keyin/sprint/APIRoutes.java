package com.keyin.sprint;

import com.keyin.sprint.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
public class APIRoutes {

	 private static  List<Airport> airports;
	 private static List<City> cities;
	 private static  List<Passenger> passengers;
	 private static  List<Aircraft> aircraft;
	 private static List<Flight> flights;

	public static List<Airport> getAirports() {
		return airports;
	}

	public static List<Passenger> getPassengers() {
		return passengers;
	}

	public static List<Aircraft> getAircraft() {
		return aircraft;
	}

	public static List<Flight> getFlights() {
		return flights;
	}

	private static void init() {
		passengers = DataLayer.ReadPassengers();
		aircraft = DataLayer.ReadAircraft();
		flights = DataLayer.ReadFlights();
		airports = DataLayer.ReadAirports();
		cities = DataLayer.ReadCities();
	}

	public static void main(String[] args){
		init();
		SpringApplication.run(APIRoutes.class, args);
	}

/**
 * This is our map to the springboot API.
 * 		The default value for a query request is 0, if we do not provide a value for the id parameter
 * 		it will default to 0.
 * 	    We will leave the item with id 0 as a placeholder for the item that does not exist.
 **/
	@GetMapping("/cities")
	public List<City> cities() {
		return cities;
    }

	@GetMapping("/flights")
	public List<Flight> flights() {
		return flights;
	}

	@GetMapping("/city")
	public City city(@RequestParam(value = "id", defaultValue = "0") int id) {
		return cities.get(id);
	}

	@GetMapping("/city/airports")
	public ArrayList<Airport> airports(@RequestParam(value = "id", defaultValue = "0") int id) {
		return cities.get(id).getAirports();
	}

	@GetMapping("/airports")
	public List<Airport> airports() {
		return airports;
	}

	@GetMapping("/airport/aircraft")
	public List<Aircraft> airport(@RequestParam(value = "id", defaultValue = "0") int id) {
		return airports.get(id).getOnPremisePlanes();
	}

	@GetMapping("/passengers")
	public List<Passenger> passengers() {
		return passengers;
	}

	@GetMapping("/passenger")
	public Passenger passenger(@RequestParam(value = "id", defaultValue = "0") int id) {
		return passengers.get(id);
	}

	@GetMapping("/")
	public String home() {
		return null;
	}

}


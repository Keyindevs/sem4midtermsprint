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
	/**
	 * In order to store values in memory, we need to create a list of each entity.
	 **/
	 private static List<Airport> airports = new ArrayList<>();
	 private static List<City> cities = new ArrayList<>();
//	 private static List<Passenger> passengers = new ArrayList<>();
	 private static List<Aircraft> aircraft = new ArrayList<>();


	public static void main(String[] args) {
		/**
		 * Now we must add values to each list of entities.
		 **/
		cities.add(new City(0, "Default", "null", 0));
		cities.add(new City(1, "New York", "NY", 8623000));
		cities.add(new City(2, "Los Angeles", "CA", 3999759));
		cities.add(new City(3, "St. John's", "NL", 108860));
		cities.add(new City(4, "Toronto", "ON", 2731571));
		cities.add(new City(5, "Montreal", "QC", 1704694));
		cities.add(new City(6, "Vancouver", "BC", 631486));

		//AirPorts
		airports.add(new Airport(0, "Default", "null"));
		airports.add(new Airport(1, "John F. Kennedy International Airport", "JFK"));
		cities.get(1).addAirport(airports.get(1));
		airports.add(new Airport(2, "Los Angeles International Airport", "LAX"));
		cities.get(2).addAirport(airports.get(2));
		airports.add(new Airport(3, "St. John's International Airport", "YYT"));
		cities.get(3).addAirport(airports.get(3));
		airports.add(new Airport(4, "Toronto Pearson International Airport", "YYZ"));
		cities.get(4).addAirport(airports.get(4));
		airports.add(new Airport(5, "Montreal-Pierre Elliott Trudeau International Airport", "YUL"));
		cities.get(5).addAirport(airports.get(5));
		airports.add(new Airport(6, "Vancouver International Airport", "YVR"));
		cities.get(6).addAirport(airports.get(6));


		//Aircraft
		aircraft.add(new Aircraft(0, "Default", "null", 0));
		aircraft.add(new Aircraft(1, "Boeing 747", "PAL", 416));
		airports.get(3).setOnPremisePlanes(aircraft.get(1));

		aircraft.add(new Aircraft(2, "Airbus A380", "PAL", 853));
		airports.get(3).setOnPremisePlanes(aircraft.get(2));
		aircraft.add(new Aircraft(3, "Boeing 737", "PAL", 215));
		airports.get(1).setOnPremisePlanes(aircraft.get(3));
		aircraft.add(new Aircraft(4, "Airbus A330", "PAL", 335));
		airports.get(4).setOnPremisePlanes(aircraft.get(4));
		aircraft.add(new Aircraft(5, "Boeing 777", "PAL", 550));
		airports.get(1).setOnPremisePlanes(aircraft.get(5));
		aircraft.add(new Aircraft(6, "Airbus A350", "PAL", 366));
		airports.get(1).setOnPremisePlanes(aircraft.get(6));

		//Passengers


		SpringApplication.run(APIRoutes.class, args);
	}

/**
  * This is a basic call to our springboot API.
  * 	This is a GET request to the /hello endpoint.
  * 	The @RequestParam annotation is used to extract query parameters from the request.
  * 	The @RequestParam annotation has two attributes:
  * 		1. value: the name of the request parameter
  * 		2. defaultValue: the default value to use as a fallback when the request parameter is not provided
 * 	Furthermore:
 * 		The default value for a query request is 0, if we do not provide a value for the id parameter
 * 		it will default to 0.
 * 	    We will leave the item with id 0 as a placeholder for the item that does not exist.
 **/
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/cities")
	public List<City> cities() {
		return cities;
    }

	@GetMapping("/city")
	public City city(@RequestParam(value = "id", defaultValue = "0") int id) {
		return cities.get(id);
	}

	@GetMapping("/city/airports")
	public ArrayList<Airport> airports(@RequestParam(value = "id", defaultValue = "0") int id) {
		return cities.get(id).getAirports();
	}

	@GetMapping("/airport/aircraft")
	public List<Aircraft> airport(@RequestParam(value = "id", defaultValue = "0") int id) {
		return airports.get(id).getOnPremisePlanes();
	}

	@GetMapping("/passengers")
	public String passengers() {
		return "This is a list of passengers!";
	}

	@GetMapping("/passenger")
	public String passenger(@RequestParam(value = "id", defaultValue = "0") String id) {
		return String.format("This is passenger %s!", id);
	}

	@GetMapping("/")
	public String home() {
		return "Welcome to the Sprint API!";
	}

}


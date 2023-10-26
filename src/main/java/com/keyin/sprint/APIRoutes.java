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
//	 private static List<Aircraft> aircraft = new ArrayList<>();


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
		cities.get(1).setAirport(airports.get(1));

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

	@GetMapping("/passengers")
	public String passengers() {
		return "This is a list of passengers!";
	}

	@GetMapping("/passenger")
	public String passenger(@RequestParam(value = "id", defaultValue = "0") String id) {
		return String.format("This is passenger %s!", id);
	}

	@GetMapping("/cities")
	public String cities() {
		StringBuilder tmp = new StringBuilder();
		for (City city : cities) {
			tmp.append(city.getName()).append("\n");
		}
		return tmp.toString();
    }

	@GetMapping("/city")
	public String city(@RequestParam(value = "id", defaultValue = "0") int id) {
		return cities.get(id).getName();
	}

	@GetMapping("/city/airports")
	public ArrayList<Airport> airports(@RequestParam(value = "id", defaultValue = "0") int id) {
		return cities.get(id).getAirports();
	}

	@GetMapping("/airport")
	public String airport(@RequestParam(value = "id", defaultValue = "0") String id) {
		return airports.get(Integer.parseInt(id)).getName();
	}

	@GetMapping("/aircrafts")
	public String aircraft() {
		return "This is a list of aircraft!";
	}

	@GetMapping("/aircraft")
	public String aircraft(@RequestParam(value = "id", defaultValue = "0") String id) {
		return String.format("This is aircraft %s!", id);
	}

	@GetMapping("/")
	public String home() {
		return "Welcome to the Sprint API!";
	}

}


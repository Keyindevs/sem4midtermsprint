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
	 private static final List<Airport> airports = new ArrayList<>();
	 private static final List<City> cities = new ArrayList<>();
	 private static final List<Passenger> passengers = new ArrayList<>();
	 private static final List<Aircraft> aircraft = new ArrayList<>();


	public static void main(String[] args) {
        // cities
		cities.add(new City(getNextId(cities), "Default", "null", 0));
		cities.add(new City(getNextId(cities), "New York", "NY", 8623000));
		cities.add(new City(getNextId(cities), "Los Angeles", "CA", 3999759));
		cities.add(new City(getNextId(cities), "St. John's", "NL", 108860));
		cities.add(new City(getNextId(cities), "Toronto", "ON", 2731571));
		cities.add(new City(getNextId(cities), "Montreal", "QC", 1704694));
		cities.add(new City(getNextId(cities), "Vancouver", "BC", 631486));


		//AirPorts
		airports.add(new Airport(getNextId(airports), "Default", "null"));
		cities.get(0).addAirport(airports.get(0));

		airports.add(new Airport(getNextId(airports), "John F. Kennedy International Airport", "JFK"));
		cities.get(1).addAirport(airports.get(1));

		airports.add(new Airport(getNextId(airports), "Los Angeles International Airport", "LAX"));
		cities.get(2).addAirport(airports.get(2));

		airports.add(new Airport(getNextId(airports), "St. John's International Airport", "YYT"));
		cities.get(3).addAirport(airports.get(3));

		airports.add(new Airport(getNextId(airports), "Toronto Pearson International Airport", "YYZ"));
		cities.get(4).addAirport(airports.get(4));

		airports.add(new Airport(getNextId(airports), "Montreal-Pierre Elliott Trudeau International Airport", "YUL"));
		cities.get(5).addAirport(airports.get(5));

		airports.add(new Airport(getNextId(airports), "Vancouver International Airport", "YVR"));
		cities.get(6).addAirport(airports.get(6));


		//Aircraft
		aircraft.add(new Aircraft(getNextId(aircraft), "Default", "null", 0));
		airports.get(0).setOnPremisePlanes(aircraft.get(0));

		aircraft.add(new Aircraft(getNextId(aircraft), "Boeing 747", "PAL", 416));
		airports.get(3).setOnPremisePlanes(aircraft.get(1));

		aircraft.add(new Aircraft(getNextId(aircraft), "Airbus A380", "PAL", 853));
		airports.get(3).setOnPremisePlanes(aircraft.get(2));

		aircraft.add(new Aircraft(getNextId(aircraft), "Boeing 737", "PAL", 215));
		airports.get(1).setOnPremisePlanes(aircraft.get(3));

		aircraft.add(new Aircraft(getNextId(aircraft), "Airbus A330", "PAL", 335));
		airports.get(4).setOnPremisePlanes(aircraft.get(4));

		aircraft.add(new Aircraft(getNextId(aircraft), "Boeing 777", "PAL", 550));
		airports.get(1).setOnPremisePlanes(aircraft.get(5));

		aircraft.add(new Aircraft(getNextId(aircraft), "Airbus A350", "PAL", 366));
		airports.get(1).setOnPremisePlanes(aircraft.get(6));


		//Passengers
		passengers.add(new Passenger("Example", "Default", "null", getNextId(passengers)));
		aircraft.get(0).addPassenger(passengers.get(0));
		cities.get(0).addHabitant(passengers.get(0));

		passengers.add(new Passenger("John", "Smith", "St. Johns", getNextId(passengers)));
		airports.get(3).getOnPremisePassengers().add(passengers.get(1));
		cities.get(3).addHabitant(passengers.get(1));

		passengers.add(new Passenger("Jane", "Doe", "Toronto", getNextId(passengers)));
		airports.get(4).getOnPremisePassengers().add(passengers.get(2));
		cities.get(4).addHabitant(passengers.get(2));

		passengers.add(new Passenger("John", "Doe", "Montreal", getNextId(passengers)));
		airports.get(5).getOnPremisePassengers().add(passengers.get(3));
		cities.get(5).addHabitant(passengers.get(3));

		passengers.add(new Passenger("Jane", "Smith", "Vancouver", getNextId(passengers)));
		airports.get(6).getOnPremisePassengers().add(passengers.get(4));
		cities.get(6).addHabitant(passengers.get(4));


		// Call our routes to actually run the API.
		SpringApplication.run(APIRoutes.class, args);
	}

	public static int getNextId(List<?> list) {
		return list.size();
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

	// nothing but API mappings past this point.
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
		return """
Welcome to the Sprint API!
Use the following endpoints to access the data:
	/cities
	/city?id=(int)
	/city/airports?id=(int)
	/airport/aircraft?id=(int)
	/passengers
	/passenger?id=(int)
	/
""";
	}

}


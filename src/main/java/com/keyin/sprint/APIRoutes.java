package com.keyin.sprint;

import com.keyin.sprint.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
public class APIRoutes {
	 private static final List<Airport> airports = new ArrayList<>();
	 private static final List<City> cities = new ArrayList<>();
	 private static final List<Passenger> passengers = new ArrayList<>();
	 static final List<Aircraft> aircraft = new ArrayList<>();


	public static void main(String[] args) {
        // cities
		cities.add(new City(getNextId(cities), "Default", "null", 0));
		cities.add(new City(getNextId(cities), "New York", "NY", 8623000));
		cities.add(new City(getNextId(cities), "St. John's", "NL", 108860));


		//AirPorts
		airports.add(new Airport(getNextId(airports), "Default", "null"));
		cities.get(0).addAirport(airports.get(0));

		airports.add(new Airport(getNextId(airports), "John F. Kennedy International Airport", "JFK"));
		cities.get(1).addAirport(airports.get(1));

		airports.add(new Airport(getNextId(airports), "St. John's International Airport", "YYT"));
		cities.get(2).addAirport(airports.get(2));



		//Aircraft
		aircraft.add(new Aircraft(getNextId(aircraft), "Default", "null", 0));
		airports.get(0).setOnPremisePlanes(aircraft.get(0));

		aircraft.add(new Aircraft(getNextId(aircraft), "Boeing 747", "PAL", 416));
		airports.get(2).setOnPremisePlanes(aircraft.get(1));

		aircraft.add(new Aircraft(getNextId(aircraft), "Airbus A380", "PAL", 853));
		airports.get(2).setOnPremisePlanes(aircraft.get(2));

		aircraft.add(new Aircraft(getNextId(aircraft), "Boeing 737", "PAL", 215));
		airports.get(1).setOnPremisePlanes(aircraft.get(3));

		aircraft.add(new Aircraft(getNextId(aircraft), "Airbus A330", "PAL", 335));
		airports.get(1).setOnPremisePlanes(aircraft.get(4));

		aircraft.add(new Aircraft(getNextId(aircraft), "Boeing 777", "PAL", 550));
		airports.get(1).setOnPremisePlanes(aircraft.get(5));

		aircraft.add(new Aircraft(getNextId(aircraft), "Airbus A350", "PAL", 366));
		airports.get(1).setOnPremisePlanes(aircraft.get(6));


		//Passengers
		passengers.add(new Passenger("Example", "Default", "null", getNextId(passengers)));
		aircraft.get(0).addPassenger(passengers.get(0));
		cities.get(0).addHabitant(passengers.get(0));

		passengers.add(new Passenger("John", "Doe", "St. Johns", getNextId(passengers)));
		airports.get(2).getOnPremisePassengers().add(passengers.get(1));
		cities.get(2).addHabitant(passengers.get(1));

		passengers.add(new Passenger("Jane", "Doe", "New York", getNextId(passengers)));
		airports.get(1).getOnPremisePassengers().add(passengers.get(2));
		cities.get(1).addHabitant(passengers.get(2));


		SpringApplication.run(APIRoutes.class, args);
	}

	public static int getNextId(List<?> list) {
		return list.size();
	}

/**
  * This is a basic call to our springboot API.
 * 		The default value for a query request is 0, if we do not provide a value for the id parameter
 * 		it will default to 0.
 * 	    We will leave the item with id 0 as a placeholder for the item that does not exist.
 **/
	@GetMapping("/cities")
	public List<City> cities() {
		return cities;
    }

	@GetMapping("/city")
	public City city(@RequestParam(value = "id", defaultValue = "0") int id) {
		return cities.get(id);
	}

	@PostMapping("/city")
	public void addCity(@RequestParam(value = "name", defaultValue = "Default") String name,
						@RequestParam(value = "code", defaultValue = "null") String code,
						@RequestParam(value = "population", defaultValue = "0") int population) {
		cities.add(new City(getNextId(cities), name, code, population));
	}

	@GetMapping("/city/airports")
	public ArrayList<Airport> airports(@RequestParam(value = "id", defaultValue = "0") int id) {
		return cities.get(id).getAirports();
	}

	@PostMapping("/city/airports")
	public void addAirport(@RequestParam(value = "name", defaultValue = "Default") String name,
						   @RequestParam(value = "code", defaultValue = "null") String code) {
		airports.add(new Airport(getNextId(airports), name, code));
	}

	@GetMapping("/airport/aircraft")
	public List<Aircraft> airport(@RequestParam(value = "id", defaultValue = "0") int id) {
		return airports.get(id).getOnPremisePlanes();
	}

	@PostMapping("/airport/aircraft")
	public void addAircraft(@RequestParam(value = "name", defaultValue = "Default") String name,
							@RequestParam(value = "code", defaultValue = "null") String code,
							@RequestParam(value = "capacity", defaultValue = "null") int capacity) {
		aircraft.add(new Aircraft(getNextId(aircraft), name, code, capacity));
	}

	@GetMapping("/passengers")
	public List<Passenger> passengers() {
		return passengers;
	}

	@GetMapping("/passenger")
	public Passenger passenger(@RequestParam(value = "id", defaultValue = "0") int id) {
		return passengers.get(id);
	}

	@PostMapping("/passenger")
	public void addPassenger(@RequestParam(value = "firstName", defaultValue = "John") String firstName,
							 @RequestParam(value = "lastName", defaultValue = "Doe") String lastName,
							 @RequestParam(value = "homeTown", defaultValue = "default") String homeTown) {
		passengers.add(new Passenger(firstName, lastName, homeTown, getNextId(passengers)));
	}


	@GetMapping("/")
	public String home() {
		return """
Welcome to the Sprint API!
Use the following endpoints to access the data:
GET /cities
GET /city?id={id}
POST /city?name={name}&code={code}&population={population}
GET /city/airports?id={id}
POST /city/airports?name={name}&code={code}
GET /airport/aircraft?id={id}
POST /airport/aircraft?name={name}&code={code}&capacity={capacity}
GET /passengers
GET /passenger?id={id}
POST /passenger?firstName={firstName}&lastName={lastName}&homeTown={homeTown}
GET /
""";
	}

}


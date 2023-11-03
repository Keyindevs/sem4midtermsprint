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
import java.util.UUID;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
public class APIRoutes {

	 private static  List<Airport> airports;
	 private static List<City> cities;
	 private static  List<Passenger> passengers;
	 private static  List<Aircraft> aircraft;
	 private static List<Flight> flights = new ArrayList<>();

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

	public static City getCityByName(String name){
		City tmp = null;
		for (City city : cities){
			if (city.getName().equals(name)){
				tmp = city;
			}
		}
		return tmp;
	}

	public static Airport getAirportByCode(String code){
		Airport tmp = null;
		for (Airport airport : airports){
			if (airport.getCode().equals(code)){
				tmp = airport;
			}
		}
		return tmp;
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

	@GetMapping("/city")
	public City city(@RequestParam(value = "name", defaultValue = "Default") String name) {
		return getCityByName(name);
	}

	@PostMapping("/city")
	public void city(@RequestParam(value = "name", defaultValue = "null") String name,
					 @RequestParam(value = "state", defaultValue = "null") String state,
					 @RequestParam(value = "population", defaultValue = "0") int population) {
		cities.add(new City(cities.size(), name, state, population));
		DataLayer.saveCity(name, state, population);
		init();
	}

	@GetMapping("/city/airports")
	public ArrayList<Airport> airports(@RequestParam(value = "name", defaultValue = "Default") String name) {
		return getCityByName(name).getAirports();
	}

	@PostMapping("/airport")
	public void airport(@RequestParam(value = "name", defaultValue = "null") String name,
						@RequestParam(value = "city", defaultValue = "null") String city,
						@RequestParam(value = "code", defaultValue = "null") String code) {
		airports.add(new Airport(name, code, city));
		DataLayer.saveAirport(name, code, city);
		init();
	}

	@GetMapping("/airports")
	public List<Airport> airports() {
		return airports;
	}

	@GetMapping("/airport/aircraft")
	public List<Aircraft> airport(@RequestParam(value = "code", defaultValue = "null") String code) {
		return getAirportByCode(code).getOnPremisePlanes();
	}

	@GetMapping("/aircraft")
	public List<Aircraft> aircraft() {
		return aircraft;
	}

	@PostMapping("/aircraft")
	public void aircraft(@RequestParam(value = "type", defaultValue = "null") String type,
						 @RequestParam(value = "airlineName", defaultValue = "null") String airlineName,
						 @RequestParam(value = "numberOfPassengers", defaultValue = "0") int numberOfPassengers,
						 @RequestParam(value = "airport", defaultValue = "null") String airport,@RequestParam(value = "id", defaultValue = "null") String id) {
		aircraft.add(new Aircraft(id, type, airlineName, numberOfPassengers, airport));
		DataLayer.saveAircraft(type,airlineName,numberOfPassengers,airport,id);
		init();
	}

	@GetMapping("/flights")
	public List<Flight> flights() {
		return flights;
	}

	@PostMapping("/flight")
	public void flight(@RequestParam(value = "origin", defaultValue = "null") String origin,
					   @RequestParam(value = "destination", defaultValue = "null") String destination,
					   @RequestParam(value = "aircraft", defaultValue = "null") String aircraft) {
		String id = new UUID(0,0).toString();
		flights.add(new Flight(origin, destination, aircraft, id));
		DataLayer.saveFlight(origin, destination, aircraft, id);
		init();
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
	public void passenger(@RequestParam(value = "firstName", defaultValue = "null") String firstName,
						  @RequestParam(value = "lastName", defaultValue = "null") String lastName,
						  @RequestParam(value = "homeTown", defaultValue = "null") String homeTown) {
		passengers.add(new Passenger(firstName, lastName, homeTown));
		DataLayer.savePassenger(firstName, lastName, homeTown);
		init();
	}

	@GetMapping("/")
	public String home() {
		return """
    GET /cities
    GET /city?name={name}
    POST /city?name={name}&state={state}&population={population}
    GET /city/airports?name={name}
    POST /airport?name={name}&city={city}&code={code}
    GET /airports
    GET /airport/aircraft?code={code}
    POST /aircraft?type={type}&airlineName={airlineName}&numberOfPassengers={numberOfPassengers}&airport={airport}&id={id}
    GET /flights
    GET /passengers
    GET /passenger?id={id}
    POST /passenger?firstName={firstName}&lastName={lastName}&homeTown={homeTown}
    GET /
				""";
	}

}


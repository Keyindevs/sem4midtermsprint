package com.keyin.sprint;

import com.keyin.sprint.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.io.IOException;
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


	public static void main(String[] args){
		init();
		SpringApplication.run(APIRoutes.class, args);
	}

	public static int getNextId(List<?> list) {
		return list.size();
	}

	public static Airport getAirportByCode(String code) {
		Airport airport = null;
		for (Airport tmpAirport:airports){
			if (tmpAirport.getCode().equals(code)){
				airport = tmpAirport;
			}
		}
		return airport;
	}

	public static Aircraft getAircraftByID(String id) {
		Aircraft tmpCraft = null;
		for (Aircraft tmpAircraft:aircraft){
			if (tmpAircraft.getId().equals(id)){
				tmpCraft= tmpAircraft;
			}
		}
		return tmpCraft;
	}


	public static List<Airport> getAirports() {
		return airports;
	}

	public static List<Passenger> getPassengers() {
		return passengers;
	}

	private static void init() {
		passengers = DataLayer.ReadPassengers();
		aircraft = DataLayer.ReadAircraft();
		airports = DataLayer.ReadAirports();
		cities = DataLayer.ReadCities();
		flights = DataLayer.ReadFlights();
	}

	public static List<Aircraft> getAircraft() {
		return aircraft;
	}

	public static List<Flight> getFlights() {
		return flights;
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

//	@PostMapping("/city")
//	public void addCity(@RequestParam(value = "name", defaultValue = "Default") String name,
//						@RequestParam(value = "code", defaultValue = "null") String code,
//						@RequestParam(value = "population", defaultValue = "0") int population) {
//		cities.add(new City(getNextId(cities), name, code, population));
//	}

	@GetMapping("/city/airports")
	public ArrayList<Airport> airports(@RequestParam(value = "id", defaultValue = "0") int id) {
		return cities.get(id).getAirports();
	}

//	@PostMapping("/city/airports")
//	public void addAirport(@RequestParam(value = "name", defaultValue = "Default") String name,
//						   @RequestParam(value = "code", defaultValue = "null") String code) {
//		airports.add(new Airport(getNextId(airports), name, code));
//	}

	@GetMapping("/airports")
	public List<Airport> airports() {
		return airports;
	}

	@GetMapping("/airport/aircraft")
	public List<Aircraft> airport(@RequestParam(value = "id", defaultValue = "0") int id) {
		return airports.get(id).getOnPremisePlanes();
	}

//	@PostMapping("/airport/aircraft")
//	public void addAircraft(@RequestParam(value = "name", defaultValue = "Default") String name,
//							@RequestParam(value = "code", defaultValue = "null") String code,
//							@RequestParam(value = "capacity", defaultValue = "null") int capacity) {
//		aircraft.add(new Aircraft(getNextId(aircraft), name, code, capacity));
//	}

	@GetMapping("/passengers")
	public List<Passenger> passengers() {
		return passengers;
	}

	@GetMapping("/passenger")
	public Passenger passenger(@RequestParam(value = "id", defaultValue = "0") int id) {
		return passengers.get(id);
	}

//	@PostMapping("/passenger")
//	public void addPassenger(@RequestParam(value = "firstName", defaultValue = "John") String firstName,
//							 @RequestParam(value = "lastName", defaultValue = "Doe") String lastName,
//							 @RequestParam(value = "homeTown", defaultValue = "default") String homeTown) {
//		passengers.add(new Passenger(firstName, lastName, homeTown, getNextId(passengers)));
//	}


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


package com.keyin.sprint;

import com.keyin.sprint.entities.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataLayer {

    public static void saveAirport(String name, String code, String city) {
        try {
            FileWriter writer = new FileWriter("src/main/resources/Airports.txt", true);
            writer.write(name + "," + code + "," + city + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveCity(String name, String state, int population){
        try {
            FileWriter writer = new FileWriter("src/main/resources/Cities.txt", true);
            writer.write(name + "," + state + "," + population + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveAircraft(String type,String airline, int numberOfPassengers, String airport, String id){
        try {
            FileWriter writer = new FileWriter("src/main/resources/Aircraft.txt", true);
            writer.write(type + "," + airline + "," + numberOfPassengers + "," + airport + "," + id + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void savePassenger(String firstName, String lastName, String homeTown){
        try {
            FileWriter writer = new FileWriter("src/main/resources/Passengers.txt", true);
            writer.write(firstName + "," + lastName + "," + homeTown + "," + "null" + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveFlight(String origin, String destination, String aircraft, String id) {
        try {
            FileWriter writer = new FileWriter("src/main/resources/Flights.txt", true);
            writer.write(origin + "," + destination + "," + aircraft + "," + id + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String ReadFile(String fileName) throws IOException {
        StringBuilder tmp = new StringBuilder();
        FileReader reader = new FileReader("src/main/resources/" + fileName);
        int character;
        while ((character = reader.read()) != -1) {
            tmp.append((char) character);
        }
        reader.close();
        return tmp.toString().replace("\r", "");
    }
    // ReadData Methods
    public static List<City> ReadCities() {
        List<City> cities = new ArrayList<>();
        try {
            // collect data from file
            String[] lines = ReadFile("Cities.txt").split("\n");

            // for each line split the values by commas
            for (int i = 0; i < lines.length; i++) {
                String[] data = lines[i].split(",");
                cities.add(new City(i, data[0], data[1], Integer.parseInt(data[2])));

                // get each airport from the list of airports
                for (Airport airport :APIRoutes.getAirports()) {
                    // if the airport city matches the city in the file append airport
                    if (airport.getCity().equals(data[0])) {
                        cities.get(i).addAirport(airport);
                    }
                }

                // get each individual from the Passenger list
                for (Passenger passenger:APIRoutes.getPassengers()) {
                    // if the passenger city matches the city in the file append passenger
                    if (passenger.getHomeTown().equals(data[0])) {
                        cities.get(i).addHabitant(passenger);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return cities;
    }
    public static List<Airport> ReadAirports() {
        List<Airport> airports = new ArrayList<>();
        try {
            String[] lines = ReadFile("Airports.txt").split("\n");
            for (int i = 0; i < lines.length; i++) {
                String[] data = lines[i].split(",");
                airports.add(new Airport(data[0], data[1], data[2]));

                // get each aircraft from the list of aircraft
                for (Aircraft aircraft :APIRoutes.getAircraft()) {
                    // if the airport matches the airport in the file append aircraft
                    if (aircraft.getAirport().equals(data[1])) {
                        airports.get(i).setOnPremisePlanes(aircraft);
                    }
                }

                for (Flight flight :APIRoutes.getFlights()) {
                   if (flight.getOrigin().equals(data[1])) {
                       airports.get(i).addFlightOut(flight);
                   }
                   if (flight.getDestination().equals(data[1])) {
                       airports.get(i).addFlightIn(flight);
                   }
                }
            }
        }   catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return airports;
    }
    public static List<Passenger> ReadPassengers(){
        List<Passenger> passengers = new ArrayList<>();
        try {
            String[] lines = ReadFile("Passengers.txt").split("\n");
            // split into lines
            for (String line : lines) {
                // split data by commas
                String[] data = line.split(",");
                // if the passenger has flights
                if (data[3] != null) {
                       String[] flightData = data[3].split("/");


                }
                passengers.add(new Passenger(data[0], data[1], data[2]));
            }
        }   catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return passengers;
    }
    public static List<Aircraft> ReadAircraft() {
        List<Aircraft> aircraft = new ArrayList<>();
        try {
            String[] lines = ReadFile("Aircraft.txt").split("\n");
            for (String line : lines) {
                String[] data = line.split(",");
                aircraft.add(new Aircraft(data[4], data[0], data[1], Integer.parseInt(data[2]), data[3]));
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return aircraft;
    }
    public static List<Flight> ReadFlights() {
        List<Flight> flights = new ArrayList<>();
        try {
            String[] lines = ReadFile("Flights.txt").split("\n");
            for (String line : lines) {
                String[] data = line.split(",");
                flights.add(new Flight(data[0], data[1], data[2], data[3]));
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return flights;
    }


}

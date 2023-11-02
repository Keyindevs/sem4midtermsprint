package com.keyin.sprint;

import com.keyin.sprint.entities.Airport;
import com.keyin.sprint.entities.City;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataLayer {

    private static String ReadFile(String fileName) throws IOException {
        StringBuilder tmp = new StringBuilder();
        FileReader reader = new FileReader("src/main/resources/"+fileName);
        int character;
        while ((character = reader.read()) != -1) {
            tmp.append((char) character);
        }
        reader.close();

        return tmp.toString();
    }

    private static void WriteFile(String fileName, String data) {
        try {
            FileWriter writer = new FileWriter("src/main/resources/"+fileName);
            writer.write(data);
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<City> ReadCities() throws IOException {
        List<City> cities = new ArrayList<>();
        String[] lines = ReadFile("cities.txt").split("\n");
        for (int i = 0; i <= lines.length ; i++) {
            String[] data = lines[i].split(",");
            cities.add(new City(i, data[0], data[1], Integer.parseInt(data[2])));
        }
        return cities;
    }


}

package main.f9.nb27;

import java.io.*;
import java.util.*;

public class CarSort {
    public static void main(String[] args) throws IOException {
        List<Car> cars = readFromFile("src/main/f9/nb27/cars.txt");

        // Sort with java Collection.
        Collections.sort(cars);
        System.out.println(cars.toString());
        writeToFile(cars, "src/main/f9/nb27/cars_sorted_API.txt");

        // Sort with CompareCar.
        cars.sort(new Car.CompareCar());
        writeToFile(cars, "src/main/f9/nb27/cars_sorted_by_year.txt");
    }

    public static List<Car> readFromFile(String fileName) {
        List<Car> cars = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length == 3) {
                    cars.add(new Car(tokens[0].trim(), Integer.parseInt(tokens[1].trim()), Integer.parseInt(tokens[2].trim())));                }
            }
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        return cars;
    }

    public static void writeToFile(List<Car> cars, String fileName) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Car car : cars) {
                bw.write(car.getBrand() + "," + car.getYear() + "," + car.getMileage());
                bw.newLine();
            }
        }catch (IOException e) {
            System.out.println("Could not write to file" + e.getMessage());
        }
    }
}

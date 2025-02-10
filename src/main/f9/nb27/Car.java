package main.f9.nb27;

import java.util.Comparator;

public class Car implements Comparable<Car>{
    private String brand;
    private int year;
    private int mileage;

    public Car(String brand, int year, int mileage) {
        this.brand = brand;
        this.year = year;
        this.mileage = mileage;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand +
                ", year=" + year +
                ", mileage=" + mileage +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        return brand.compareTo(o.brand);
    }

    public static class CompareCar implements Comparator<Car> {
        @Override
        public int compare(Car o1, Car o2) {
            return Integer.compare(o1.getYear(), o2.getYear());
        }
    }
}

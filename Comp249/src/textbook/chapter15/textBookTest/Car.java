package chapter15.textBookTest;

import java.util.Objects;

public class Car {
    private double price;
    private int numberOfDoors;
    private String color;

    public Car(){}
    public Car(double price, int numberOfDoors, String color) {
        this.price = price;
        this.numberOfDoors = numberOfDoors;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", numberOfDoors=" + numberOfDoors +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 &&
                numberOfDoors == car.numberOfDoors &&
                Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {

        return Objects.hash(price, numberOfDoors, color);
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

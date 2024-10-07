package model;

public class Car implements Vehicle {
    String color;

    public Car(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getModel() {
        return "Car";
    }

    @Override
    public String toString() {
        return "Car {color='" + color + "'}";
    }
}

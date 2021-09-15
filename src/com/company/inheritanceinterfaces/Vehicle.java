package com.company.inheritanceinterfaces;

public class Vehicle {
    String color;

    public Vehicle() {}

    public Vehicle(String color) {
        this.color = color;
    }

    public void goTo(String destination) {
        System.out.println("Färdas till " + destination);
    }

    public static void main(String[] args) {
        Vehicle boat = new Boat("sky-blue");
        Vehicle sail = new Sail("white");
        Vehicle motorboat = new Motorboat("gray");
        Vehicle bicycle = new Bicycle("blue");
        Vehicle car = new Car("red");

        boat.goTo("Vrångö");
        sail.goTo("Brännö");
        motorboat.goTo("Sicily");
        bicycle.goTo("Delsjön");
        car.goTo("Stockholm");
    }

}

class Boat extends Vehicle {
    public Boat() {
    }

    public Boat(String color) {
        super(color);
    }

    @Override
    public void goTo(String destination) {
        System.out.println("Färdas med båt till " + destination);
    }
}

class Motorboat extends Boat {
    public Motorboat() {
    }

    public Motorboat(String color) {
        super(color);
    }

    @Override
    public void goTo(String destination) {
        System.out.println("Färdas med motorbåt till " + destination);
    }
}

class Sail extends Boat {
    public Sail() {}

    public Sail(String color) {
        super(color);
    }

    @Override
    public void goTo(String destination) {
        System.out.println("Färdas med segelbåt till " + destination);
    }
}

class Bicycle extends Vehicle {
    int numberOfWheels;

    public Bicycle() {
    }

    public Bicycle(String color) {
        super(color);
    }

    public Bicycle(String color, int numberOfWheels) {
        super(color);
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public void goTo(String destination) {
        System.out.println("Färdas med cykel till " + destination);
    }
}

class Car extends Vehicle {
    public Car() {}

    public Car(String color) {
        super(color);
    }

    @Override
    public void goTo(String destination) {
        System.out.println("Färdas med bil till " + destination);
    }
}

abstract class ElectricVehicle {

    public ElectricVehicle() {

    }

    abstract public String chargingMethod();

}

class ElectricScooter extends ElectricVehicle {

    public ElectricScooter() {
    }

    @Override
    public String chargingMethod() {
        return "electricity";
    }
}

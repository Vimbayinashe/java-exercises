package com.company.inheritanceinterfaces;

abstract public class Vehicle {
    String color;

    public Vehicle() {}

    public Vehicle(String color) {
        this.color = color;
    }

    public void goTo(String destination) {
        System.out.println("Färdas till" + destination);
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
}

class Motorboat extends Boat {
    public Motorboat() {
    }

    public Motorboat(String color) {
        super(color);
    }
}

class Sail extends Boat {
    public Sail() {}

    public Sail(String color) {
        super(color);
    }
}

class Bicycle extends Vehicle {
    public Bicycle() {
    }

    public Bicycle(String color) {
        super(color);
    }
}

class Car extends Vehicle {
    public Car() {}

    public Car(String color) {
        super(color);
    }
}

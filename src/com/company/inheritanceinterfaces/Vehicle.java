package com.company.inheritanceinterfaces;

abstract public class Vehicle {
    String color;

    public Vehicle() {}

    public Vehicle(String color) {
        this.color = color;
    }

    public void goTo(String destination) {
        System.out.println("Färdas till " + destination);
    }

    public String color() {
        return color;
    }


    public void color(String color) {
        this.color = color;
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

//        instanceof -> Type casting a super class to a subclass type       ((Car)car).burnOut(10);

        castInstanceOf(car);
        castInstanceOf(bicycle);
        castInstanceOf(motorboat);
        castInstanceOf(sail);
    }

    static void castInstanceOf(Vehicle vehicle) {
//        if (vehicle instanceof Car)
//            ((Car) vehicle).burnOut(10);
        if (vehicle instanceof Car car)     //clean code -> pattern matching for 'instanceof'
            car.burnOut(10);                //variable car is only available within if block
        else if(vehicle instanceof Bicycle bicycle)
            bicycle.ringBell();
        else if(vehicle instanceof Boat boat)
            boat.startBoat();
        else if (vehicle instanceof  Motorboat motorboat)
            motorboat.startEngine();
        else if(vehicle instanceof Sail sail)
            sail.sailing();
    }



//    pattern matching in switch - JDK 17
//    static void switchInstanceOf(Vehicle vehicle) {
//        switch (vehicle) {
//            case Car car -> car.burnOut(10);
//        }
//    }

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

    public void startBoat() {
        System.out.println("Vroom... boat starting!");
    }
}

class Motorboat extends Vehicle {
    public Motorboat() {
    }

    public Motorboat(String color) {
        super(color);
    }

    @Override
    public void goTo(String destination) {
        System.out.println("Färdas med motorbåt till " + destination);
    }

    public void startEngine() {
        System.out.println("starting motorboat...");
    }
}

class Sail extends Vehicle {
    public Sail() {}

    public Sail(String color) {
        super(color);
    }

    @Override
    public void goTo(String destination) {
        System.out.println("Färdas med segelbåt till " + destination);
    }

    public void sailing() {
        System.out.println("Sailing in the sun!");
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

    public void ringBell() {
        System.out.println("Ring ring");
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

    public void burnOut(int seconds){
        System.out.println("Spinning the wheels for " + seconds + " seconds.");
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

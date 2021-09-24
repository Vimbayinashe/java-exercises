package com.company.oopminiproject;

import java.util.Random;

public abstract class Vehicle {
    private int weight;
    private int price;
    private Person owner;


    public Vehicle(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public Vehicle(int weight, int price, Person owner) {
        this.weight = weight;
        this.price = price;
        this.owner = owner;
    }

    public int weight() {
        return weight;
    }

    public void weight(int weight) {
        this.weight = weight;
    }

    public int price() {
        return price;
    }

    public void price (int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" +
                "weight=" + weight +
                ", price=" + price +
                ", owner=" + owner +
                '}';
    }

    public Person getOwner() {
        return owner;
    }

    public void addOwner(Person owner) {    //changeOwner
        this.owner = owner;
    }

}


// Vehicle derived classes
public class RoadVehicle extends Vehicle {
    private int mileage;


    public RoadVehicle(int weight, int price, int mileage) {
        super(weight, price);
        this.mileage = mileage;
    }

    public RoadVehicle(int weight, int price, int mileage, Person person) {
        super(weight, price, person);
        this.mileage = mileage;
    }

    public void drive(int km) {
        mileage += km;
    }

    public int mileage() {
        return mileage;
    }


    @Override   //Do I need to override a method with same fxn as super's?
    public void addOwner(Person owner) {
        super.addOwner(owner);
    }
}


class WaterVessel extends Vehicle {
    private GpsPosition gps;    //better to create own data type / Class for info represented by to data points eg.
                                // (x, y) co-ordinates

    public WaterVessel(int weight, int price) {
        super(weight, price);
        gps = new GpsPosition();
    }

    public WaterVessel(int weight, int price, Person person) {
        super(weight, price, person);
    }

    public void go() {
       gps.updatePosition();
    }

    //GpsPosition's updatePosition method is public -> giving someone the reference to our actual gps position means
    // they can also update and change that position. Create and five a copy of actual object (same data but diff ref)
    public GpsPosition gps() {
        return new GpsPosition(gps);
    }

}

class GpsPosition {
    private double latitude;
    private double longitude;
    private final Random random;

    public GpsPosition() {
        //default GPS co-ordinates for Gothenburg
        latitude = 57.7072326;
        longitude = 11.9670171;
        random = new Random();
    }

    //copy constructor (deliberately chose to re-implement new Random() )
    public GpsPosition(GpsPosition original) {
        this();                                 //run default constructor
        this.latitude = original.latitude;      //update with original's co-ordinates
        this.longitude = original.longitude;
    }

    public void updatePosition() {
        latitude += random.nextDouble() * 180 - 90 ;  //latitude range: -85.05112878 to 85.05112878 (rounded to 85)
        longitude += random.nextDouble() * 360 - 180;    //longitude range: -180 and 180
    }

    public double latitude() {
        return latitude;
    }

    public double longitude() {
        return longitude;
    }
}


public class Aircraft extends Vehicle {
    private int altitude;
    private final Random random;

    public Aircraft(int weight, int price) {
        super(weight, price);
        altitude = 0;
        random = new Random();
    }

    public Aircraft(int weight, int price, Person person) {
        super(weight, price, person);
        altitude = 0;
        random = new Random();
    }

    public void fly(boolean isFlying) {
        if(isFlying)
            altitude = random.nextInt(15000);
        else
            altitude = 0;
    }

    //better to have two separate methods: a method that handles true isFlying and a method without parameter for
    // landing

    public int altitude() {
        return altitude;
    }
}


//Vehicles
class Car extends RoadVehicle {

    public Car(int weight, int price, int mileage) {
        super(weight, price, mileage);
    }

    public Car(int weight, int price, int mileage, Person person) {
        super(weight, price, mileage, person);
    }
}

class Motorcycle extends RoadVehicle {

    public Motorcycle(int weight, int price, int mileage) {
        super(weight, price, mileage);
    }

    public Motorcycle(int weight, int price, int mileage, Person person) {
        super(weight, price, mileage, person);
    }
}

class Boat extends WaterVessel {

    public Boat(int weight, int price) {
        super(weight, price);
    }

    public Boat(int weight, int price, Person person) {
        super(weight, price, person);
    }

}

class Airplane extends Aircraft {

    public Airplane(int weight, int price) {
        super(weight, price);
    }

    public Airplane(int weight, int price, Person person) {
        super(weight, price, person);
    }
}

class Helicopter extends Aircraft {

    public Helicopter(int weight, int price) {
        super(weight, price);
    }

    public Helicopter(int weight, int price, Person person) {
        super(weight, price, person);
    }
}

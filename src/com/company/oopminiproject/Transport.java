package com.company.oopminiproject;

import java.util.Random;

abstract public class Transport {
    private int weight;
    private int price;


    public Transport(int weight, int price) {
        this.weight = weight;
        this.price = price;
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
        return "Transport{" +
                "weight=" + weight +
                ", price=" + price +
                '}';
    }

}


// Transport derived classes
class RoadVehicle extends Transport implements Driving {
    private int mileage;


    public RoadVehicle(int weight, int price, int mileage) {
        super(weight, price);
        this.mileage = mileage;
    }

    @Override
    public void drive(int km) {
        mileage += km;
    }

    public int mileage() {
        return mileage;
    }
}


class WaterVessel extends Transport implements GPS {
    private double latitude;
    private double longitude;
    Random random;

    public WaterVessel(int weight, int price) {
        super(weight, price);
        random = new Random();

        //default GPS co-ordinates for Gothenburg
        latitude = 57.7072326;
        longitude = 11.9670171;
    }

    public WaterVessel(int weight, int price, double latitude, double longitude) {
        super(weight, price);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public void go() {
        latitude += random.nextDouble() * 171 - 85 ;  //latitude range: -85.05112878 to 85.05112878 (rounded to 85)
        longitude += random.nextDouble() * 360 - 180;    //longitude range: -180 and 180
    }
}


class Aircraft extends Transport implements Flying {
    private int altitude;
    private final Random random;

    public Aircraft(int weight, int price) {
        super(weight, price);
        altitude = 0;
        random = new Random();
    }

    @Override
    public void fly(boolean isFlying) {
        if(isFlying)
            altitude = random.nextInt(15000);
        else
            altitude = 0;
    }

    public int altitude() {
        return altitude;
    }
}


//Vehicles
class Car extends RoadVehicle {

    public Car(int weight, int price, int mileage) {
        super(weight, price, mileage);
    }
}

class Motorcycle extends RoadVehicle {

    public Motorcycle(int weight, int price, int mileage) {
        super(weight, price, mileage);
    }
}

class Boat extends WaterVessel {

    public Boat(int weight, int price) {
        super(weight, price);
    }

    public Boat(int weight, int price, double latitude, double longitude) {
        super(weight, price, latitude, longitude);
    }
}

class Airplane extends Aircraft {

    public Airplane(int weight, int price) {
        super(weight, price);
    }
}

class Helicopter extends Aircraft {

    public Helicopter(int weight, int price) {
        super(weight, price);
    }
}

package com.company.oopminiproject;

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

package com.company.oopminiproject;

import java.util.Random;

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
        if (isFlying)
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

package com.company.generics;

import java.util.Random;

public class RandomNumbers {
    // Skapa ett program som lägger till 10 slumptal av datatypen double i en lista. Loopa igenom listan med foreach och skriv ut värdet på slumptalen.
    private double[] list = new double[10];
    private static Random random = new Random();

    public RandomNumbers() {
        for (int i = 0; i < 10; i++) {
            list[i] = (random.nextDouble());
        }
    }


    public void printValues() {
        for(double item : list) {
            System.out.println(item);
        }
    }


    public static void main(String[] args) {
        RandomNumbers rand = new RandomNumbers();

        rand.printValues();
    }

}

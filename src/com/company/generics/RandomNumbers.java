package com.company.generics;

import java.util.ArrayList;
import java.util.List;
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


    //imperative foreach
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

class RandomDoubleValues {
    public static void main(String[] args) {
        List<Double> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add(Math.random() * 100);
        }

        //inbuilt foreach - declarative
        numbers.forEach((v )-> System.out.printf("%.2f%n", v));     //%.2f - 2 float points, %n - /n newline
        numbers.forEach(System.out::println);
    }


}

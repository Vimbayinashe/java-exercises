package com.company.oop;

public class Counter {
    private int counter;    //initialises to 0 if nothing is assigned;
    private String name;    //default value of null -> complex datatypes

    public void increase() {
        counter++;
    }

    public void decrease() {
        counter--;
    }

    public int value() {
        return counter;
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        counter.increase();
        counter.increase();

        System.out.println(counter.value());
    }
}

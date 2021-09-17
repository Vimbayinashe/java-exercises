package com.company.oop;

public class Counter {
    private int counter;    //initialises to 0 if nothing is assigned;
    private String name;    //default value of null -> complex datatypes

    private static int noOfObjects;

    public Counter() {
        noOfObjects++;      //count number of Counter objects that have been created (static variable)
    }

//    Alt 2: a constructor for static variables - static initialisation block
//    static {
//        counterObjects ++;
//    }

    public void increase() {
        counter++;
    }

    public void decrease() {
        counter--;
    }

    public int value() {
        return counter;
    }

    public void printCounterObjects() {
        System.out.println(noOfObjects);
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        counter.increase();
        counter.increase();

        System.out.println(counter.value());

        counter.printCounterObjects();
    }


    //Using this Counter object to be a counter => works for non-static variables
//    private static Counter numberOfObjects;
//
//    static {
//        numberOfObjects = new Counter(null);
//    }
//
//    // private constructor to initialise Counter so we can use our Counter object as a counter
//    private Counter(Object object) {
//
//    }
}

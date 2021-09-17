package com.company.oop;

public class Semaphore {
    private static final Counter counter = new Counter();
    private static final int MAX_OBJECT = 5;

    private Semaphore(){

    }

    //factory class - a method that creates an instance of an object
    //static - method can be used as Semaphore.request() without an actual Semaphore object
     public static Semaphore request() {
         if (counter.value() >= MAX_OBJECT)
             return null;

         counter.increase();
         return new Semaphore();
     }

     public void release() {
        counter.decrease();
     }

     //we cannot set Semaphore = null in release() method -> the argument is only a local variable within the method
     // this must be done manually in Semaphore demo by the user as below
         // semaphore5.release();
         // semaphore5 = null

    // Semaphore can be used to limit access to say a game that has maxantal players
    // when a player leaves the game (& releases a place), a new player can join
}

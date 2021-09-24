package com.company.inheritanceinterfaces.animals;

import com.company.inheritanceinterfaces.Animal;

public class Fish extends Animal {

    private boolean isPet;

    public Fish() {
    }

    public Fish(String color, boolean isPet) {
        super(color);
        this.isPet = isPet;
    }

    public Fish(Fish fish) {
        super(fish.color());
        this.isPet = fish.isPet;
    }

    @Override
    public void diet() {
        super.diet();
        System.out.println("I like eating seaweed!");
    }

//    @Override
//    public String toString() {
//        return super.toString();
//    }


    @Override
    public String toString() {
        return "Fish{" +
                "isPet=" + isPet +
                ", color=" + color() +
                '}';
    }
}


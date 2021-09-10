package com.company.oop;

public class PancakeRecipe {

    private int flour;
    private int milk;
    private int egg;
    private int salt;
    private int butter;
    private static final int REQUIRED_FLOUR_AMOUNT = 500;
    private static final int REQUIRED_MILK_AMOUNT = 500;
    private static final int REQUIRED_EGG_AMOUNT = 4;
    private static final int REQUIRED_SALT_AMOUNT = 1;
    private static final int REQUIRED_BUTTER_AMOUNT = 200;


    public PancakeRecipe() {
        this.flour = REQUIRED_FLOUR_AMOUNT;
        this.milk = REQUIRED_MILK_AMOUNT;
        this.egg = REQUIRED_EGG_AMOUNT;
        this.salt = REQUIRED_SALT_AMOUNT;
        this.butter = REQUIRED_BUTTER_AMOUNT;
    }

    public PancakeRecipe(int flour, int milk, int egg, int salt, int butter) {
        this.flour = flour;
        this.milk = milk;
        this.egg = egg;
        this.salt = salt;
        this.butter = butter;
    }

    public boolean canMakePancakes() {
        return flour >= REQUIRED_FLOUR_AMOUNT &&
                milk >= REQUIRED_MILK_AMOUNT &&
                egg >= REQUIRED_EGG_AMOUNT &&
                salt >= REQUIRED_SALT_AMOUNT &&
                butter >= REQUIRED_BUTTER_AMOUNT;
    }

    public void makePancakes() {
        if(canMakePancakes()) {
            flour -= REQUIRED_FLOUR_AMOUNT;
            milk -= REQUIRED_MILK_AMOUNT;
            egg -= REQUIRED_EGG_AMOUNT;
            salt -= REQUIRED_SALT_AMOUNT;
            butter -= REQUIRED_BUTTER_AMOUNT;

            System.out.println("A batch of pancakes are ready");

            makePancakes(); //recursive call -> continue making pancakes until ingredients are finished
        } else {
            System.out.println("You don't have enough ingredients left");
        }
    }

    public void makePancakes2() {
        while (canMakePancakes()) {
            flour -= REQUIRED_FLOUR_AMOUNT;
            milk -= REQUIRED_MILK_AMOUNT;
            egg -= REQUIRED_EGG_AMOUNT;
            salt -= REQUIRED_SALT_AMOUNT;
            butter -= REQUIRED_BUTTER_AMOUNT;

            System.out.println("A batch of pancakes are ready");
        }

        System.out.println("You don't have enough ingredients left");
    }

    public static void main(String[] args) {
        PancakeRecipe batch = new PancakeRecipe();
        batch.makePancakes();
    }
}

package com.company.inheritanceinterfaces;

public class Animal {
//    Skriv en klass som ärver från en annan klass. Superklassen ska vara något generellt och subklassen något mer
//    specifikt. Skapa objekt av båda klasserna för att kontrollera att du har gjort rätt.Animals

    private String color;

    public Animal() {

    }

    public Animal(String color) {
        this.color = color;
    }

    public void diet() {
        System.out.println("I like eating");
    }

    public String color() {
        return color;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "color='" + color + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Animal animal = new Animal("pink");
        System.out.println(animal);

        Fish fish1 = new Fish("orange", false);
        System.out.println(fish1);

        Animal fish2 = new Fish("silver", true);
        System.out.println(fish2);
    }

}

class Fish extends Animal {

    private boolean inFishBowl;

    public Fish() {
    }

    public Fish(String color, boolean inFishBowl) {
        super(color);
        this.inFishBowl = inFishBowl;
    }

    public Fish(Fish fish) {
        super(fish.color());
        this.inFishBowl = fish.inFishBowl;
    }

    @Override
    public void diet() {
        System.out.println("I like eating seaweed!");
    }

//    @Override
//    public String toString() {
//        return super.toString();
//    }


    @Override
    public String toString() {
        return "Fish{" +
                "inFishBowl=" + inFishBowl +
                '}';
    }
}

package com.company.inheritanceinterfaces;

//2 Skapa två publika metoder i superklassen från förra uppgiften. Metoderna ska skriva ut något så att man ser att de körs.
// Lägg till en av metoderna i subklassen. Skapa ett objekt av subklassen och testa vad som händer när du anropar båda funktionerna från superklassen.
public class Animal {
    private String color;

    public Animal() {

    }

    public Animal(String color) {
        this.color = color;
    }

    public String color() {
        return color;
    }

    public void diet() {
        System.out.println("I like eating");
    }

    public void wild() {
        System.out.println("I am a wild animal");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "color='" + color + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Animal animal = new Animal("pink");
        animal.diet();
        animal.wild();

        Fish fish1 = new Fish("orange", false);
        System.out.println(fish1);
        fish1.diet();
        fish1.wild();


        Animal fish2 = new Fish("silver", true);
//        System.out.println(fish2);
    }

}

class Fish extends Animal {

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

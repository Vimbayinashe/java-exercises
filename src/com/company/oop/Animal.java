package com.company.oop;

public class Animal {

    public void animal() {
        System.out.println("I am just an animal");
    }

    public void testMethod() {

    }

    public static void main(String[] args) {

        //an elephant can be 4 different type of objects
        Object elephant1 = new Elephant();
        Animal elephant2 = new Elephant();
        Mammal elephant3 = new Elephant();
        Elephant elephant4 = new Elephant();

        //an Animal array could take in Animals, Birds, Mammals, Elephants etc.
        //derived classes inherit fields and methods


        //testing inheritance:
        Fish tigerFish = new Fish();
        Animal bream = new Fish();

        tigerFish.animal(); //Fish type inherits Animal methods & fields.
        tigerFish.swim();

        bream.animal();
//        bream.swim(); //superclass cannot make use of derived class's method

    }

    public int test() {
        return 0;
    }

}

class Fish extends Animal {

    public void swim() {
        System.out.println("Swimming!");
    }

    @Override
    public int test() {
        return super.test();
    }

//    @Override
//    public void animal() {
//        super.animal();
//    }
}

class Bird extends Animal {

}

class Mammal extends Animal {

}

class Salmon extends Fish {

}

class Woodpecker extends Bird {

}

class Elephant extends Mammal {

}

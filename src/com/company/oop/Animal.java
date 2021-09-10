package com.company.oop;

public class Animal {

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
    }

}

class Fish extends Animal {

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

package com.company.inheritanceinterfaces;

import com.company.inheritanceinterfaces.animals.NoiseMaker;

public class AnimalsExtended {

}

class Bird extends Animal implements NoiseMaker {

    @Override
    public String makeNoise() {
        return "Tweet tweet";
    }
}

class Mammal extends Animal {

}

class Dinosaur extends Animal {

}


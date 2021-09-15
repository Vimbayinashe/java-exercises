package com.company.inheritanceinterfaces;

public class AnimalsExtended {

}

class Bird extends Animal implements NoiseMaker {

    @Override
    public String makeNoise() {
        return "Tweet tweet";
    }
}

class Reptile extends Animal implements NoiseMaker {

    @Override
    public String makeNoise() {
        return "Ssss";
    }
}

class Mammal extends Animal {

}

class Dinosaur extends Animal {

}

class Robot implements NoiseMaker {

    @Override
    public String makeNoise() {
        return "whirring";
    }
    
}

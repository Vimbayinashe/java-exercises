package com.company.inheritanceinterfaces.animals;

import com.company.inheritanceinterfaces.Animal;

public class Bird extends Animal implements NoiseMaker {

    @Override
    public String makeNoise() {
        return "Tweet tweet";
    }
}


package com.company.inheritanceinterfaces.animals;

import com.company.inheritanceinterfaces.Animal;
import com.company.inheritanceinterfaces.animals.NoiseMaker;

public class Reptile extends Animal implements NoiseMaker {

    @Override
    public String makeNoise() {
        return "Ssss";
    }
}

package com.company.generics;

import com.company.inheritanceinterfaces.Animal;
import com.company.inheritanceinterfaces.animals.Bird;
import com.company.inheritanceinterfaces.animals.Fish;
import com.company.inheritanceinterfaces.animals.Reptile;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    public static void main(String[] args) {
        Map<String, Animal> animalDictionary = new HashMap<>();

        Bird bird = new Bird();
        Fish fish = new Fish();
        Reptile snake = new Reptile();
        Reptile snake2 = new Reptile();
//    Robot robot = new Robot();


        animalDictionary.put("bird1", bird);
        animalDictionary.put("fish1", fish);
        animalDictionary.put("snake1", snake);
        animalDictionary.putIfAbsent("snake1", fish);

        System.out.println(animalDictionary.get("snake1"));

    }

}

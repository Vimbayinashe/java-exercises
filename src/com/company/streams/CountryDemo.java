package com.company.streams;

import java.util.ArrayList;
import java.util.List;

public class CountryDemo {

    public static void main(String[] args) {
        List<Country> countries = new ArrayList<>();

        countries.add(new Country("Sverige", "Stockholm", 10.07, 450295));
        countries.add(new Country("Norge", "Oslo", 5.27, 323802));
        countries.add(new Country("Island", "Reykyavik", 0.33, 102775));
        countries.add(new Country("Danmark", "Köpenhamn", 5.75, 42931));
        countries.add(new Country("Finland", "Helsinki", 5.51, 338424));
        countries.add(new Country("Belgien", "Bryssel", 11.30, 30528));
        countries.add(new Country("Tyskland", "Berlin", 82.18, 357168));
        countries.add(new Country("Frankrike", "Paris", 66.99, 640679));
        countries.add(new Country("Storbritannien", "London", 60.80, 209331));
        countries.add(new Country("Niue", "Alofi", 0.0016, 261));
        countries.add(new Country("Mongoliet", "Ulan Batar", 3.08, 1566000));
        countries.add(new Country("Polen", "Warsawa", 38.63, 312679));
        countries.add(new Country("Spanien", "Madrid", 46.5, 505990));
        countries.add(new Country("Portugal", "Lissabon", 10.31, 92212));
        countries.add(new Country("Italien", "Rom", 60.59, 301338));
        countries.add(new Country("Grekland", "Aten", 11.18, 131957));
        countries.add(new Country("Luxemburg", "Luxemburg", 0.58, 2586));
        countries.add(new Country("Liechtenstein", "Vaduz", 0.038, 160));

    }
}

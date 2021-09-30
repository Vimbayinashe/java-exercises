package com.company.streams;

import org.w3c.dom.xpath.XPathResult;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Countries {

    private final List<Country> countries;

    public Countries() {
        countries = new ArrayList<>();
        addCountries();
    }

    public void addCountries() {

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

    public Optional<String> firstCountry() {
        return countries.stream()
                .map(Country::name)
                .findFirst();
                // stop here if Optional<Country> is a sufficient return type
//                .orElse("No countries found.");
    }

    public Optional<String> lastCountry() {
        return countries.stream()
                .map(Country::name)
                .reduce((country1, country2) -> country2);
//                .orElse("No countries found.");
    }

    public List<String> countryNamesSortedByPopulation() {
        return countries.stream()
                .sorted(Comparator.comparing(Country::population).reversed())
                .map(Country::name)
                .toList();
    }

    public Optional<Country> countryWithGreatestPopulation() {
        return countries.stream()
                .max(Comparator.comparing(Country::population));
    }

    public double averageArea() {
        return countries.stream()
                .mapToDouble(Country::area)
                .average()
                .orElse(0.0);
    }

    public long areaLessThanAverage() {
        return countries.stream()
                .filter(country -> country.area() < averageArea())
                .count();
    }

    public List<String> populationLessThan(int size) {
        return countries.stream()
                .filter(country -> country.populationInteger() < size)
                .map(Country::name)
                .toList();
    }

    public long areaGreaterThan(int area) {
        return countries.stream()
                .filter(country -> country.area() > area)
                .count();
    }

    public List<String> capitalAndCountryBeginWithSameLetter() {
        return countries.stream()
                .filter(country -> country.name().startsWith(country.capitalCity().substring(0, 1)))
                .map(Country::name)
                .toList();
    }

    public List<String> countryNameLongerThanCapital() {
        return countries.stream()
                .filter(country -> country.name().length() > country.capitalCity().length())
                .map(Country::name)
                .toList();
    }

    public List<String> leastPopulation() {
        return countries.stream()
                .sorted(Comparator.comparingDouble(Country::populationInteger))
                .limit(5)
                .map(Country::name)
                .toList();
    }

    public List<String> leastPopulationAndOverSevenMillion() {
        return countries.stream()
                .filter(country -> country.populationInteger() > 7_000_000)
                .sorted(Comparator.comparingDouble(Country::population))
                .map(Country::name)
                .limit(3)
                .toList();
    }


    public List<String> threeCountriesReverseOrderWithAreaGreaterThan(int area) {
        return countries.stream()
                .filter(country -> country.area() >= area)
                .sorted(Comparator.comparing(Country::name).reversed())
                .map(Country::name)
                .limit(3)
                .toList();
    }


    public static void main(String[] args) {
        Countries countries = new Countries();

        System.out.print("First country: ");
        countries.firstCountry().ifPresent(System.out::println);
        System.out.print("\nLast country: ");
        countries.lastCountry().ifPresent(System.out::println);
        System.out.println("\nSorted countries from greatest to least: ");
        countries.countryNamesSortedByPopulation().forEach( country -> System.out.printf("%s, ", country));
        System.out.println("\n\nGreatest population");
        countries.countryWithGreatestPopulation().ifPresent(country -> System.out.println(country.populationInteger()));
        System.out.printf("\nAverage area is %.2f sq meters.",countries.averageArea());
        System.out.printf("\n\n%s countries with an area less than average.", countries.areaLessThanAverage());

        int comparisonPopulation = 5_000_000;
        System.out.println("\n\nCountries with population less than " + comparisonPopulation);
        countries.populationLessThan(comparisonPopulation).forEach(System.out::println);

        System.out.println("\n" + countries.areaGreaterThan(10_000) + " countries with area over 10.000");
        System.out.println(countries.areaGreaterThan(100_000) + " countries with area over 100.000");
        System.out.println(countries.areaGreaterThan(1_000_000) + " countries with area over 1.000.000");

        System.out.println("\nCountries whose name starts with the same letter as capital city");
        countries.capitalAndCountryBeginWithSameLetter().forEach(System.out::println);

        System.out.println("\nCountries whose name is longer than the capital city");
        countries.countryNameLongerThanCapital().forEach(System.out::println);

        System.out.println("\nFive countries with least population");
        countries.leastPopulation().forEach(System.out::println);

        System.out.println("\nThree countries with least population above 7,000,000");
        countries.leastPopulationAndOverSevenMillion().forEach(System.out::println);

        System.out.println("\nTop three countries with an minimum area of 500,000");
        countries.threeCountriesReverseOrderWithAreaGreaterThan(500_000).forEach(System.out::println);


    }
}



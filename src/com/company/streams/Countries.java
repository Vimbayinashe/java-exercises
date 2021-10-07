package com.company.streams;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class Countries {

    //Important change
    // create countries in main()
    //send countries as an argument into all methods

    private final List<Country> countries;

    public Countries() {
        countries = getCountries();
    }

    public List<Country> getCountries() {

        /* Alternative: make an unmodifiable List

         *   return  List.of(
         *      new Country( new Country("Sverige", "Stockholm", 10.07, 450295))
         *      new Country( new Country("Sverige", "Stockholm", 10.07, 450295)) ...and so on
         *
          */

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

        return countries;
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
                .reduce((first, second) -> second)
                .map(Country::name);
//                .orElse("No countries found.");
        //reduce first -> it's easier to work with object references than converting Country Object to a String
    }

//    record Pair(Optional<String> first, Optional<String> last) {}     ->  temp record to store and return data pairs

    public  List<String> countryNamesAlphabeticalOrder() {
        return countries.stream()
                .map(Country::name)
                .sorted()
                .toList();
    }

    //map first -> sort => String has an implemented sort function
    //Alternatives sort methods: .sorted(Comparator.naturalOrder()) .sorted(Comparator.reversedOrder())


    public List<String> countryNamesSortedByPopulation() {
        return countries.stream()
                .sorted(Comparator.comparing(Country::population).reversed())
                .map(Country::name)
                .toList();
    }

    //.sorted(Comparator.comparing(Country::population).thenComparing(Country::area))   //sort by population and then by area

    public Optional<Country> countryWithGreatestPopulation() {
        return countries.stream()
                .max(Comparator.comparing(Country::population));

        //Alt 2:
        /*return countries.stream()
                .mapToDouble(Country::population)       //mapToDouble -> we can use regular double methods
                .max();
         */
    }

    public double averageArea() {
        return countries.stream()
                .mapToDouble(Country::area)
                .average()
                .orElse(0.0);

    }

    public long areaLessThanAverage() {
        double averageAreaValue = averageArea();

        return countries.stream()
                .filter(country -> country.area() < averageAreaValue)       //**
                .count();
    }

    //** it is much better to create averageAreaValue once in the method than to call averageArea() in the returned
    // stream => this causes the method to be called for each cycle of the loop (n.size() times)

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

//    public void areaGreaterThanUsingGroupBy() {
//        countries.stream()
//                .collect(Collectors.groupingBy())
//    }

    public List<CountryNameAndCapital> capitalAndCountryBeginWithSameLetter() {
        return countries.stream()
                .filter(Countries::compareFirstLetters)     //method reference
                .map(country -> new CountryNameAndCapital(country.name(), country.capitalCity()))
                .toList();
    }

    record CountryNameAndCapital(String country, String capital) {}

    private static boolean compareFirstLetters(Country country) {
        return country.name().startsWith(country.capitalCity().substring(0, 1));
    }

    //Alt 2:     .filter(country -> country.name().startsWith(String.valueOf(country.capitalCity().charAt(0))))

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
                .filter(country -> country.population() > 7.0)
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

    //14 Skriv ut hur många länder det finns som börjar på varje bokstav som finns i listan.
    // Exempelvis så finns det två länder vars namn börjar på S, ett som börjar på D och två som börjar på F.
    public Map<String, Long> numberOfCountriesStartingWithSameLetter() {
        return countries.stream()
                .collect(Collectors.groupingBy(country -> country.name().substring(0, 1), Collectors.counting()));
    }

//    public Map<Integer, List<String >> numberOfCountriesWithXPopulation() {
//        return countries.stream()
//                .collect(Collectors.groupingBy(Country::populationInteger));
//    }

    public List<String> countriesWithPopulationX(int population) {
        return countries.stream()
                .filter(country -> population < country.population() && country.population() <= (population + 1))
                .sorted(Comparator.comparing(Country::name))
                .map(Country::name)
                .toList();
    }

    public List<String> nameAndPopulation() {
        return countries.stream()
                .map(country -> country.name() + " - " + country.populationInteger())
                .toList();
    }

    //create a new record type to represent two data types
    record CountryAndPop(String name, Integer popuation) {}

    public List<CountryAndPop> nameAndPopulation2() {
        return countries.stream()
                .map(country -> new CountryAndPop(country.name(), country.populationInteger() * 1_000_000))
                .toList();
    }

    public List<String> nameAndPopulationDensity() {
        return countries.stream()
                .map(country -> country.name() + " - " + country.population() * 1000000 / country.area())
                .toList();
    }

    //redo with a unique record type
    record CountryAndPopDensity(String name, Double popDensity) {}

    public List<CountryAndPopDensity> nameAndPopulationDensity2() {
        return countries.stream()
                .map(country -> new CountryAndPopDensity(country.name(), country.population() * 1000000 / country.area()))
                .sorted(Comparator.comparing(CountryAndPopDensity::popDensity))
                .toList();
    }

    private List<String> task17() {
        return countries.stream()
                //.sorted(Comparator.comparing(country -> getReverse(country)))
                .sorted(Comparator.comparing(this::getReverse))
                .map(Country::name)
                .toList();
    }

    @NotNull
    private String  getReverse(Country country) {
        return new StringBuilder(country.capitalCity()).reverse().toString();
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

        countries.numberOfCountriesStartingWithSameLetter()
                .forEach((letter, count) -> System.out.print(letter + ": " + count + ", "));

        System.out.println("\n\nCountries with X population:");
        countries.countriesWithPopulationX(10).forEach(System.out::println);

        System.out.println("\nCountry names and population");
        countries.nameAndPopulation().forEach(System.out::println);

        System.out.println("\nCountry names and population density");
        countries.nameAndPopulationDensity().forEach(System.out::println);

        countries.nameAndPopulation2().forEach(System.out::println);

        countries.nameAndPopulationDensity2().forEach(System.out::println);


    }
}



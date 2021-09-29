package com.company.streams;

import java.util.Objects;

public final class Country {
    private final String name;
    private final String capitalCity;
    private final double population;
    private final int area;

    public Country(String name, String capitalCity, double population, int area) {
        this.name = name;
        this.capitalCity = capitalCity;
        this.population = population;
        this.area = area;
    }

    public String name() {
        return name;
    }

    public String capitalCity() {
        return capitalCity;
    }

    public double population() {
        return population * 1e+6;
    }

    public int populationInteger() {
        return (int) (population * 1e+6);
    }

    public int area() {
        return area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Double.compare(country.population, population) == 0 && area == country.area && Objects.equals(name,
                country.name) && Objects.equals(capitalCity, country.capitalCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capitalCity, population, area);
    }

    @Override
    public String toString() {
        return "Country[" +
                "name=" + name + ", " +
                "capitalCity=" + capitalCity + ", " +
                "population=" + population + ", " +
                "area=" + area + ']';
    }

}

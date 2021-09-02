package com.company.methods;

public class Main {

    public static void main(String[] args) {

    }
    
    public static double add(double a, double b) {
        return a + b;
    }

    public static int multiplyThree(int num1, int num2, int num3) {
        return num1 * num2 * num3;
    }

    public static int unlimited(int[] array) {
        int result = 1;

        for (int value : array) {
            result = result * value;
        }
        
        return result;
    }

//    Skriv en funktion som tar tre parametrar: name, city och favoriteNumber.
//    Talet ska ha datatypen byte och de andra ska vara string.
//    Funktionen ska skriva ut informationen till konsolen i en fullständig mening. Exempel "Välkommen Namn från Göteborg med favorittal 12".
    public static String greeting(String name, String city, int number) {
        return  "Välkommen " + name + " från " + city + " med favorittal " + number;
    }

}




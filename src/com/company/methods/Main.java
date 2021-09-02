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

    public static String greeting(String name, String city, byte number) {
        return "Välkommen " + name + " från " + city + " med favorittal " + number;
    }

    public static int convertStringToInteger(String input) {
        int output;

        try {
            output = Integer.parseInt(input);
        } catch (NumberFormatException ignored) {
            System.out.println("Invalid input in convertStringToInteger function.");
            output = 0;
        }

        return output;
    }

    public static String convertStringToHTML(String input) {
        return "<p>" + input + "</p>";
    }

    enum Month {
        JAN,
        FEB,
        MAR,
        APR,
        MAY,
        JUN,
        JUL,
        AUG,
        SEP,
        OCT,
        NOV,
        DEC
    }

    public static int daysInAMonth(Month month) {
        int days = 0;

        switch (month) {
            case JAN:
            case MAR:
            case MAY:
            case JUL:
            case AUG:
            case OCT:
            case DEC:
                days = 31;
                break;
            case APR:
            case JUN:
            case SEP:
            case NOV:
                days = 30;
                break;
            case FEB:
                days = 28;
                break;

        }
        return days;
    }

    public static String firstThreeCharacters(String input) {
        return input.substring(0, 3);
    }

    public static String year(String date) {
        return date.substring(0, 4);
//        return date.substring(0, date.indexOf('-'));
    }

    //    Skriv en funktion med namnet daysBetween som räknar ut hur många dagar det är mellan två datum.
//Exempel: daysBetween(“2017-08-30”, “2017-09-02”) == 4 Tips: Använd javas färdiga klasser för att hantera datum.
    public static int daysBetween(String date1, String date2) {
        //TODO

        return 1;
    }

    //    10 Skriv en funktion som översätter en temperatur i Fahrenheit till Celsius.
//    Den ska ta en parameter och returnera ett värde. Välj lämpliga datatyper.
    public static String convertTemperature(double temp) {
        return  String.format("%.1f", (temp - 32) * 5 / 9);
    }

}




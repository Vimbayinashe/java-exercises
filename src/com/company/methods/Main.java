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

    //    Skriv en funktion med namnet paragraph, som tar en parameter.
//    Den ska returnera en sträng enligt det här exemplet: paragraph("hej") → "<p>hej</p>"
    public static String convertStringToHTML(String input) {
        return "<p>" + input + "</p>";
    }

}




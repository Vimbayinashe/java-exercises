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
    
//    Skriv en funktion som kan ta emot obegränsat med parametrar. 
    public static int unlimited(int[] array) {
        int result = 1;

        for (int value : array) {
            result = result * value;
        }
        
        return result;
    }
//    Den ska multiplicera alla och returnera resultatet.
}




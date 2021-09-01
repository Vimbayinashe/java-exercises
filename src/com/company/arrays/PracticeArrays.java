package com.company.arrays;

public class PracticeArrays {
    public static void main(String[] args) {
//        One();
        Two();
    }

    // 1 Skriv ett program som skapar en array med strängarna "gul", "grön", "orange", "blå", "grå". Skriv ut varje värde i arrayen på konsolen.
    static void One() {
        String[] colors = new String[] {"grön", "grön", "orange", "blå", "grå"};

        for (String color: colors) {
            System.out.println(color);
        }
    }

    // 2 Skriv ett program som räknar ut summan av alla element i arrayen [2, 3, 5, 8, 13, 21, 34].
    //Extra utmaning: vartannat tal ska adderas och vartannat subtraheras.
    static void Two() {

        int[] numbers = new int[] {2, 3, 5, 8, 13, 21, 34};
        int sum = 0;

        for (int number: numbers) {
            sum += number;
        }

        System.out.println("Sum of array is: " + sum);
    }
}

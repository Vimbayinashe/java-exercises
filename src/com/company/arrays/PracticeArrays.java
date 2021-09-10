package com.company.arrays;

import java.util.Scanner;

public class PracticeArrays {
    public static void main(String[] args) {
//        One();
        Two();
//        Three();
//        Four();
    }

    //4 Skriv ett program som frågar användaren efter ett tal.
    // Programmet ska skapa en ny array som är så lång och fylla den med slumptal (se uppgift 3) av datatypen int.
    // Skriv ut alla talen och vad de har för medelvärde som en double.
    static void Four() {
        System.out.println("Please enter a number");
        Scanner scanner = new Scanner(System.in);

        final int length = scanner.nextInt();   //variable's value should not be changed
        int[] newArray = new int[length];
        int sum = 0;
//        double sum = 0;   //you can also just declare sum as a double from the beginning

//        Random random = new Random();
//        int value = random.nextInt();     //random.nextInt(100); -> limit to 0-100

        System.out.println("Values in the new array");

        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * 20 + 1);
            newArray[i] = random;
            sum += random;
            System.out.println(newArray[i]);
        }

        System.out.println("Sum of all values: " + sum);

        double average = (double) sum / length;
//        double average = sum * 1.0 / length;    //teacher prefers this than the method above

        System.out.printf("Average of all values: %.2f", average);
        System.out.printf("Average of all values: %.2f och en gång till %.2f", average, average);

    }

    //    3 Skriv ett program som skapar en array med fem heltal, som ska slumpas fram.
    //    Programmet ska sedan gå igenom arrayen och skriva ut vilket det största och minsta talet är samt hur många tal som är udda.
    static void Three() {

        //slumpad array
        int[] randomNumbers = new int[5];

        for (int i = 0; i < 5; i++) {
            int random = (int) (Math.random() * 20 + 1);
            randomNumbers[i] = random;
            System.out.println(randomNumbers[i]);
        }


        int least = randomNumbers[0];
        int greatest = randomNumbers[0];
        int count = 0;


        for (int i = 1; i < 5; i++) {
            if (randomNumbers[i] < least)
                least = randomNumbers[i];
            if (randomNumbers[i] > greatest)
                greatest = randomNumbers[i];
            if (randomNumbers[i] % 2 == 1)
                ++count;
        }

        System.out.println("Minimum value: " + least);
        System.out.println("Maximum value: " + greatest);
        System.out.println("Count " + count);

//        Alt:
//        Random random = new Random();
//        int rand = random.nextInt();
//        int least = Integer.MAX_VALUE;  //works also
//        int greatest = Integer.MIN_VALUE;

    }

    // 1 Skriv ett program som skapar en array med strängarna "gul", "grön", "orange", "blå", "grå". Skriv ut varje värde i arrayen på konsolen.
    static void One() {
        String[] colors = new String[]{"grön", "grön", "orange", "blå", "grå"};

        for (String color : colors) {
            System.out.println(color);
        }
    }

    // 2 Skriv ett program som räknar ut summan av alla element i arrayen [2, 3, 5, 8, 13, 21, 34].
    //Extra utmaning: vartannat tal ska adderas och vartannat subtraheras.
    static void Two() {

        int[] numbers = new int[]{2, 3, 5, 8, 13, 21, 34};
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        System.out.println("Sum of array is: " + sum);

        int challenge = 0;

        for (int i = 0; i < numbers.length; i++) {
            if(i%2 == 0)
                challenge += numbers[i];
            else
                challenge -= numbers[i];
        }

        System.out.println("Result of challenge is: " + challenge);
    }
}

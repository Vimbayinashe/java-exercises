package com.company;

import java.io.Console;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    // Make scanner available in all the methods, make note of static
    // static -> scanner automatically has a reserved place in memory
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        numberOneFour();
//        numberOneBank();
//        numberTwoSeven();
//        numberTwoThree();
//        numberTwoNine();
//        numberTwoTen();
        numberTwoEleven();
//        numberTwoThreeSystem();
    }

    public static void numberOne() {
        System.out.println("Vad heter du?");

//        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Skriv ett nummer");

        int number = Integer.parseInt(scanner.nextLine());

        System.out.println("Hej " + name + ". Ditt nummer är " + number);
    }

    public static void numberOneFour() {
//        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a number");
        int first = Integer.parseInt(scanner.nextLine());
        System.out.println("Choose a second number");
        int second = Integer.parseInt(scanner.nextLine());

        int sum = first + second;
        int product = first * second;

//        double average = (first + second) / 2; -> gives us (int) result 4.0 instead of 4.5
        double average = (first + second) / 2;

        System.out.println("The sum is: " + sum);
        System.out.println("The product is: " + product);
        System.out.println("The average is: " + average);
    }

    public static void numberOneFive() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a decimal number");
        double number = Double.parseDouble(scanner.nextLine());
        int parsedNumber = (int) number;
        int roundedNumber = (int) Math.round(number);   //rounds up more correct than typecast

        System.out.println(number + " is " + parsedNumber + " when integer parsed and " + roundedNumber + " when rounded to a whole number.");
    }

    public static void numberOneBank() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your bank balance?");
        double balance = Double.parseDouble(scanner.nextLine());
        System.out.println("What is the interest rate in decimal format?");
        double interest = Double.parseDouble(scanner.nextLine());

        double newBalance = balance * (1.0 + interest);

        String pattern = "###,##0.00";
//        Alt 1: format using default UK locale
//        DecimalFormat decimalFormat = new DecimalFormat(pattern);

//        Alt 2 : format using Sweden locale
        Locale locale = new Locale("sv", "SV");
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);

        String formattedBalance = decimalFormat.format(newBalance);

        System.out.println("Your new balance is " + formattedBalance + " kr.");
        System.out.printf("Your new balance is: %.2f",  newBalance);
    }

    public static void numberTwoThree() {
        String password = "kdi3Qr";

        System.out.println("What is your password?");
        String input = scanner.nextLine();

        // String is a complex data type and == only compares references not the variable contents
//        if (password == new String(input)) {

        if (password.equals(input)) {
            System.out.println("Correct password!");
        } else {
            System.out.println("Incorrect password, please try again.");
        }

        //        Console console = System.console();
//        char[] input = console.readPassword();
//        String stringInput = String.valueOf(input);
    }

    // Alt 2: using System.console().readPassword()
    private static void numberTwoThreeSystem() {
        String password = "kdi3Qr";
        System.out.println("Enter your password?");

        //        String password3 = new String(System.console().readPassword());
        // recommended -> describes what we want to do rather than exactly what must be done
        String input = String.valueOf(System.console().readPassword());

        if(password.equals(input))
            System.out.println("Password is correct!");
        else
            System.out.println("Incorrect password");

    }

    public static void numberTwoFour() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a number");

        int number = Integer.parseInt(scanner.nextLine());

        if (number == 100) System.out.println("Your number is 100.");
        else if (number < 100)
            System.out.println("Your number is less than 100.");
        else
            System.out.println("Your number is greater than 100.");
    }

    public static void numberTwoFive() {
        System.out.println("Please choose a month between 1 - 12.");

        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        switch (number) {
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("July");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("October");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;
        }
    }

    public static void numberTwoSix() {
        int secretNumber = (int) (Math.random() * 100 + 1);

        // My attempt
        System.out.println("Guess the secret number between 1 - 100!");
        int guess = 0;

        while (guess != secretNumber) {
            guess = Integer.parseInt(scanner.nextLine());
            if (guess == secretNumber)
                System.out.println("Correct! " + guess + " is the secret number.");
            else if (guess > secretNumber) {
                System.out.println(guess + " is bigger than the secret number.");
            } else if (guess < secretNumber) {
                System.out.println(guess + " is smaller than the secret number.");
            }
            System.out.println("Guess again...");
            guess = Integer.parseInt(scanner.nextLine());
        }


        // Recommended
        int userGuess = 0;
        int counter = 0;

        do {
            System.out.println("Guess the secret number between 1 - 100!");

            try {
                userGuess = scanner.nextInt();
            } catch (InputMismatchException ignored) {
                System.out.println("Invalid guess");
                scanner.nextLine(); // rensa .nextInt() kvarliggande tomrum (space)
                userGuess = 0;  // reset userGuess from NaN input
            }

            counter++;

            if(userGuess == secretNumber)
                System.out.println("Correct! You guessed the " + userGuess + " after " + counter +  " guesses");
            else if (userGuess > secretNumber) {
                System.out.println(guess + " is bigger than the secret number.");
            } else
                System.out.println(guess + " is smaller than the secret number.");

        } while (userGuess != secretNumber);

    }

    public static void numberTwoSeven() {
        // Java är nollindexerad så man kan börja med 0
        for (int i = 1; i < 17; i++) {
            System.out.println(i);
        }
    }

    public static void numberTwoEight() {

        for (int i = 20; i > 0; i--) {
            if (i % 2 == 0)
                System.out.println(i);
        }

        // teacher's solution -> compute only even  numbers
        for (int i = 20; i >= 2 ; i -=2) {
            System.out.println(i);
        }
    }

    public static void numberTwoNine() {
        int number = 65536;

        while (number > 2) {
            System.out.println(number);

        /*
            shifting bits is much faster than multiplication or division
            >> shifting all the bits one step to the right = divide by 2 is the same as
            examples:
            n >> 1 -> move n 1 stage to the right = divide by 2
            n >> 2 -> move n 2 stages to the right = divide by 4
         */

            //number = number >> 1;
            number >>= 1;
        }
    }

    public static void numberTwoTen() {
        StringBuilder word = new StringBuilder();
        String input;

        while (true) {
            System.out.println("Please enter a word");
            input = scanner.nextLine();

            if(input.equals("") || input.equals(".")) {
                System.out.println("Your final word is: " + word);  //print here
                break;
            }

            //avoid adding space to an empty variable
            if (word.length() == 0)
                word.append(input);
            else
                word.append(" ").append(input);

        }
        System.out.println(word);   //or here




    }

    public static void numberTwoEleven() {

        System.out.println("Choose a number");

        Scanner scanner = new Scanner(System.in);
        int guess = Integer.parseInt(scanner.nextLine());


        while (guess > 2) {
            if (guess % 2 == 0) {
                guess >>= 2;
            } else {
                guess = (guess * 3) + 1;
            }
            System.out.println("The new number is " + guess);
        }
    }


}

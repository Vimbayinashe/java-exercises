package com.company.methods;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {

    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static int multiplyThree(int num1, int num2, int num3) {
        return num1 * num2 * num3;
    }

    //    Alt 1
//  varargs -> unlimited arguments, treated as an array
    public static int unlimitedVarargs(int... numbers) {
        int result = 1;

        for (int number : numbers) {
            result = result * number;
        }
        return result;
    }
//    Calling the fxn: unlimitedVarargs(2,3,4,5)

    //    Alt 2
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
//        }catch (NumberFormatException e) {
//            throw new Exception
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

//        Month input = Month.valueOf(scanner.next().toLowerCase());

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
//                days = leapYear();    //create a fxn that
                break;
            default:
                throw new RuntimeException();

        }
        return days;
    }

    public static String firstThreeCharacters(String input) {
        return input.substring(0, 3);
        //substring() returns a new string, does not modify the original
    }

    public static int year(String date) {
        if (date.length() != 10)
            throw new IllegalArgumentException();

        return Integer.parseInt(date.substring(0, 4));

//        return date.substring(0, date.indexOf('-'));

        //Alt 2 (advanced)
//        LocalDateTime dateTime = LocalDateTime.parse(date+"T00:00:00");
//        return dateTime.getYear();

    }

    //    Skriv en funktion med namnet daysBetween som räknar ut hur många dagar det är mellan två datum.
//Exempel: daysBetween(“2017-08-30”, “2017-09-02”) == 4 Tips: Använd javas färdiga klasser för att hantera datum.
    public static int daysBetween(String date1, String date2) {
        //TODO

        LocalDate localDate1 = LocalDate.parse(date1);
        LocalDate localDate2 = LocalDate.parse(date2);
        int days = 0;

        if (localDate1.isAfter(localDate2))
            days = (int) ChronoUnit.DAYS.between(localDate1, localDate2);

        return Math.abs(days);

    }

//    public static String  convertTemperature(double temp) {
//        return  String.format("%.1f", (temp - 32) * 5 / 9);
////        return  Math.round(100.0 * (temp - 32) * 5 / 9)/ 100.0;
//    }

    //Alt 2: Returns a double to 1 dp
    public static double convertTemperature(double temp) {
        return (int) (((temp - 32) * 5 / 9) * 10) / 10.0;
    }


    public static int sumOfNumbers() {
        int count = 1;
        int sum = 0;

        while (count <= 100) {
            sum += count;
            ++count;
        }

        return sum;

    }

    public static int sumOfNumbers(int limit) {
        int count = 1;
        int sum = 0;

        while (count <= limit) {
            sum += count;
            ++count;
        }

        return sum;

    }

    public static int sumOfNumbersRecursive(int limit) {
        //recursion reqs. a condiditon that breaks the loop
        if (limit == 0)
            return 0;
        else
            return limit + sumOfNumbersRecursive(limit - 1);
    }

    public static String reverse(String input) {
        int length = input.length();
        StringBuilder reversedWord = new StringBuilder();   //Stringbuilder is a data type

        for (int i = length - 1; i >= 0; i--) {
            reversedWord.append(input.charAt(i));

//             reversedWord += input.charAt(i);
            // satisfies test but -> warning in IDE. Stringbuilder is a complex datatype
        }

        return reversedWord.toString();
    }

    //Alt 2
    public static String returnStringBackwards(String inputString) {

        char[] stringInCharArray = inputString.toCharArray();
        StringBuilder stringBackwards = new StringBuilder();

        for (int i = stringInCharArray.length - 1; i >= 0; i--) {
            stringBackwards.append(stringInCharArray[i]);
        }

        return stringBackwards.toString();
    }

    //Alt 3
    public static String reverseStringStringBuilder(String inputString) {

        StringBuilder builder = new StringBuilder();
        return builder.append(inputString).reverse().toString();
    }

//    14 Skriv en funktion som beräknar medelvärdet av parametrarna som skickas in.
//    Gör flera versioner (överlagring, overloading) av metoden som tar olika antal
//    parametrar men har samma funktionsnamn. Vi vill kunna hantera 2,3,4,5…

    public static double average(int first, int second) {
        double average = (first + second) / 2.0;
        return (Math.round(average * 100) / 100.00);
    }

    public static double average(int first, int second, int third) {
        double average = (first + second + third) / 3.0;
        return (Math.round(average * 100) / 100.00);
    }

    public static double average(int[] numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }
        double average = (double) sum / numbers.length;
        return (Math.round(average * 100) / 100.00);
    }

//    13 Extrauppgift. Skriv en funktion som tar ett tal som parameter och returnerar true om det är ett primtal. Ett
//    primtal är ett heltal som bara är delbart med sig självt och 1. De första primtalen är 2, 3, 5, 7. Men 8 är
//    inget primtal eftersom 8 / 2 == 4.

    public static Boolean primeNumber(int number) {

//        Avoid hardcoding as below:
//        int[] primeNumbers = new int[] {2, 3, 5, 7, 11, 13, 17, 19};
//        boolean prime = false;
//
//        for (int number: primeNumbers) {
//            //if input is divisible by number return false
//            prime = input % number != 0;
//        }
//
//        return prime;

        if (number <= 1)
            return false;
        else if(number == 2)
            return true;
        else {
            for (int i = 2; i < number / 2; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
        }


        return true;
    }

//    int currentYear = Year.now().getValue();
//    Year.now().isLeap();

}




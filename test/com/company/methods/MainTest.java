package com.company.methods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void addTwoNumbersShouldReturnSumOfTwoNumbers() {
        double result = Main.add(2.5, 6.5);
        assertEquals(9, result);
    }

    @Test
    void multiplyThreeNumbersShouldReturnTheirProduct() {
        int result = Main.multiplyThree(2, 2, 2);
        assertEquals(8, result);
    }

    @Test
    void multiplyUnlimitedNumberOfParametersAndReturnTheirProduct() {
        int[] array = new int[]{2, 4, 5, 6, 11};
        int expected = 2 * 4 * 5 * 6 * 11;
        int actual = Main.unlimited(array);

        assertEquals(expected, actual);
    }

    @Test
    void inputNameCityAndFavouriteNumberShouldOutputAGreeting () {
        String name = "Vimbayi";
        String city = "Göteborg";
        byte number = 5;

        String actual = Main.greeting(name, city, number);
        String expected = "Välkommen " + name + " från " + city + " med favorittal " + number;

        assertEquals(expected, actual);
    }

    @Test
    void convertStringToIntegerAndThrowAnExceptionIfNotPossible() {

        assertEquals(12, Main.convertStringToInteger("12"));
        assertEquals(0, Main.convertStringToInteger("2b"));
    }

    @Test
    void returnAStringInAnHTMLParagraphTag() {
        assertEquals("<p>Hello World</p>", Main.convertStringToHTML("Hello World"));
    }

    @Test
    void daysInAMonthShouldReturnNumberOfDaysInAMonth() {
        assertEquals(31, Main.daysInAMonth(Main.Month.JAN));
    }

    @Test
    void returnFirstThreeCharactersInAStringInput() {
        assertEquals("bee", Main.firstThreeCharacters("beeswax"));
    }

    @Test
    void functionYearReturnsYearFromDateInput() {
        assertEquals("2022", Main.year("2022-12-31"));
    }

    @Test
    void daysBetweenReturnsNumberOfDaysBetweenTwoDates () {
        assertEquals(18, Main.daysBetween("2021-08-30", "2021-09-17"));
    }

    @Test
    void convertTemperatureConvertsFarenheitToCelsius() {
        assertEquals("37.8", Main.convertTemperature(100.0));
    }

    @Test
    void sumOfNumbersReturnSumOfFirstOneHundredNumbers() {
        assertEquals(5050, Main.sumOfNumbers());
    }

    @Test
    void sumOfNumbersReturnSumOfParametersValue() {
        assertEquals(15, Main.sumOfNumbers(5));
    }

    @Test
    void reverseReversesAString() {
        StringBuilder reversedWord = new StringBuilder("maet");
        assertEquals("maet", Main.reverse("team"));
    }

}
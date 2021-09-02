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
        int number = 5;

        String actual = Main.greeting(name, city, number);
        String expected = "Välkommen " + name + " från " + city + " med favorittal " + number;

        assertEquals(expected, actual);
    }
}
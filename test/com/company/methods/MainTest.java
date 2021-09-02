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
}
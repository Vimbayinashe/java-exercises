package com.company.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    MyStack<String> myStack = new MyStack<>();      //we need an instance of our object for testing.
                                                    // Each test will create a new object


    @Test
    void pushOneItemPopShouldReturnThatItem() {
        myStack.push("First item");
        String result = myStack.pop();

        assertEquals("First item", result);
    }

    @Test
    void pushTwoItemsPopShouldReturnLastAddedItem() {
        myStack.push("First item");
        myStack.push("Second item");
        String result = myStack.pop();

        assertEquals("Second item", result);
    }

    @Test
    void pushTwoItemsPopTwiceShouldReturnBothItemsInLIFOOrder() {
        myStack.push("First item");
        myStack.push("Second item");

        assertEquals("Second item", myStack.pop());
        assertEquals("First item", myStack.pop());
    }

    @Test
    void popBeforePushThrowsIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> myStack.pop());
        // used a lambda implementation since assertThrows expects an Executable
    }

    @Test
    void popAfterTwoPushThreePopThrowsIllegalStateException() {
        myStack.push("First item");
        myStack.push("Second item");

        myStack.pop();
        myStack.pop();

        assertThrows(IllegalStateException.class, () -> myStack.pop());

    }

    @Test
    void peekReturnsLastPushedItemAndPopReturnsLastItem() {
        myStack.push("First Item");
        myStack.push("Second Item");

        assertEquals("Second Item", myStack.peek());
        assertEquals("Second Item", myStack.pop());
    }

    @Test
    void sizeReturnNumberOfItemsPushedToStack() {
        myStack.push("One");
        myStack.push("Two");
        myStack.push("Three");

        assertEquals(3, myStack.size());

        myStack.pop();
        assertEquals(2, myStack.size());
    }

}
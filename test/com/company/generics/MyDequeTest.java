package com.company.generics;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class MyDequeTest {
    private  final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    MyDeque<Integer> integerMyDeque = new MyDeque<>();

    @BeforeEach
    void setUpOutStream() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreOutStream() {
        System.setOut(originalOut);
    }

    @Test
    void forEachRunsOurCodeInRightOrder() {
        integerMyDeque.push(1);
        integerMyDeque.push(2);
        integerMyDeque.push(3);
        //integerMyDeque.forEach();
        integerMyDeque.forEach((s) -> System.out.println(s));

        //A stack adds and removes from the top -> expected output: 3 2 1
        assertEquals("3\n2\n1\n", outContent.toString());
    }

    @Test
    void forEachDescRunsOurCodeInRightOrder() {
        integerMyDeque.push(1);
        integerMyDeque.push(2);
        integerMyDeque.push(3);
        integerMyDeque.forEachDesc(System.out::println);

        assertEquals("1\n2\n3\n", outContent.toString());
    }

    @Test
    void demonstratingForEachAndSuper() {
        integerMyDeque.push(1);
        integerMyDeque.push(2);
        integerMyDeque.push(3);
        //integerMyDeque.forEach();

        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };


        integerMyDeque.forEach(integerConsumer);

        //A stack adds and removes from the top -> expected output: 3 2 1
        assertEquals("3\n2\n1\n", outContent.toString());
    }

    @Test
    void loopingMyDequeUsingIterator() {
        integerMyDeque.push(1);
        integerMyDeque.push(2);
        integerMyDeque.push(3);

        for (Integer value : integerMyDeque) {  //implementing Iterable -> can use foreach loop
            System.out.println(value);
        }
        assertEquals("3\n2\n1\n", outContent.toString());


        //Benefit of using interfaces (Consumer & Iterable in this case)
        List<Integer> integers = new ArrayList<>();

        //integerMyDeque.forEach(s -> integers.add(s));
        integerMyDeque.forEach(integers::add);

        assertEquals(3, integers.get(0));
        assertEquals(2, integers.get(1));
        assertEquals(1, integers.get(2));

    }

}






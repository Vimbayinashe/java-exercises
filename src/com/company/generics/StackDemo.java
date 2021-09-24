package com.company.generics;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        //LIFO - Stack, FIFO - Queue, Deque - both
        Stack<String> stackTest = new Stack<>();

        stackTest.push("cheese");
        stackTest.push("mutton");
        stackTest.push("fish");

        System.out.println(stackTest.pop());
        System.out.println(stackTest.pop());
        System.out.println(stackTest.pop());

        Deque<Integer> stack = new ArrayDeque<>();

        stack.add(1);
        stack.add(2);
        stack.add(3);

        System.out.println(stack.removeLast());
        System.out.println(stack.removeLast());
        System.out.println(stack.removeLast());
    }
}

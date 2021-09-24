package com.company.generics;

import javax.swing.plaf.IconUIResource;

public class MyStack<T> {
    private Node<T> head;
    private int counter;

    public void push(T obj) {
        Node<T> node = new Node<>();
        node.data = obj;

        if(head != null) {
            node.next = head;   //shift reference from head to next position "index 1"
        }
        head = node;
        counter++;
    }

    public T pop() {
        if (head == null)       //Avoid NullPointerException
            throw new IllegalStateException();
        var temp = head.data;
        head = head.next;
        counter--;
        return temp;
    }

    public T peek() {
        return head.data;
    }

    public int size() {
        return counter;
    }
}

class Node<T> {
    T data;
    Node<T> next;
}

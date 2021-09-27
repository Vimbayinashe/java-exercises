package com.company.generics;

public class MyStack<T> {
    private DNode<T> head;
    private int counter;

    public void push(T obj) {
        DNode<T> node = new DNode<>();
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
    DNode<T> next;
}

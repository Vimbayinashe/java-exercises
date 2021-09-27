package com.company.generics;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.function.Consumer;

public class MyDeque<T> implements Iterable<T> {
    private DNode<T> head;
    private DNode<T> tail;
    private int counter;

    public void push(T obj) {
        DNode<T> node = new DNode<>();
        node.data = obj;

        if (head == null) {
            head = node;
            tail = node;
        }else {
            node.next = head;   //shift reference from head to next position "index 1"
            head.prev = node;
            head = node;
        }

        counter++;
    }

    public T pop() {
        if (head == null)       //Avoid NullPointerException
            throw new IllegalStateException();
        var temp = head.data;
        head = head.next;

        if (head != null)
            head.prev = null;
        else
            tail = null;

        counter--;
        return temp;
    }

    public T peek() {
        return head.data;
    }

    public int size() {
        return counter;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new MyDequeIterator();
    }

    public void forEach(Consumer<? super T> consumer) {
        var temp = head;

        while (temp != null) {
            consumer.accept(temp.data);
            temp = temp.next;
        }
    }

    // ? super T => accepts data type T or any of it's super classes. In this example, using Integer -> Number,
    // object are also acceptable

    // ? extends Iterable => we only accept classes that extend Iterable interface or class (i.e. Iterable's
    // descendants)

    public void forEachDesc(Consumer<T> consumer) {
        var temp = tail;

        while (temp != null) {
            consumer.accept(temp.data);
            temp = temp.prev;
        }
    }

    //klass i en klass => den automatiskt får tillgång till allt i förälderklass
    class MyDequeIterator implements Iterator<T> {
        private DNode<T> next = head;
        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public T next() {
            T temp = next.data;
            next = next.next;
            return temp;
        }
    }

// Without Consumer interface
//    public void forEach() {
//        var temp = head;
//
//        while (temp != null) {
//            System.out.println(temp.data);
//            temp = temp.next;
//        }
//    }

//    public void forEachDesc() {
//        var temp = tail;
//
//        while (temp != null) {
//            System.out.println(temp.data);
//            temp = temp.prev;
//        }
//    }
}



class DNode<T> {
    T data;
    DNode<T> prev;
    DNode<T> next;
}

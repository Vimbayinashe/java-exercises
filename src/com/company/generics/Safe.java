package com.company.generics;

import java.util.ArrayList;
import java.util.List;

public class Safe <T> {
    T storedObject;
//    List<T> safe = new ArrayList<>();

    public Safe() {

    }

    void store(T object) {
        storedObject = object;
//        safe.add(object);
    }

    T retrieve() {
        T storedObject = this.storedObject;
        this.storedObject = null;
        return storedObject;
        //return safe.remove(0);
    }

    public static void main(String[] args) {
        Safe<String> safe = new Safe<String>();

        safe.store("Hello");
        System.out.println(safe.retrieve());
        System.out.println(safe.retrieve());
    }

}

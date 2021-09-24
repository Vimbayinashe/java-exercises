package com.company.generics;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Safe <T> {
    private T storedObject;

    void store(@NotNull T object) {
        if(this.storedObject != null)
            throw new IllegalStateException("An object has already been stored.");
//        if (object == null)       //this check replaced by @NotNull annotation
//            throw new IllegalArgumentException("Cannot store null");
        storedObject = object;
    }

    T retrieve() {
        if(this.storedObject == null)
            throw new IllegalStateException("Nothing to retrieve, the safe is empty");
        T temp = this.storedObject;
        this.storedObject = null;
        return temp;
    }


    public static void main(String[] args) {
        Safe<String> safe = new Safe<String>();

        safe.store("Hello");
        System.out.println(safe.retrieve());
        System.out.println(safe.retrieve());
    }

}

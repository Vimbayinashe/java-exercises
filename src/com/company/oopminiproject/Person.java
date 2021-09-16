package com.company.oopminiproject;

abstract public class Person {
    private final String name;
    private int age;
    private String occupation;
    private int bankBalance;

    public Person(String name, int age, String occupation, int bankBalance) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.bankBalance = bankBalance;
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    public void birthday() {
        ++age;
    }

    public String occupation() {
        return occupation;
    }

    public void occupation(String occupation) {
        this.occupation = occupation;
    }

    public int bankBalance() {
        return bankBalance;
    }

    public void deposit(int deposit) {
        this.bankBalance += deposit;
    }

    public void withdrawal(int withdrawal) {
        this.bankBalance -= withdrawal;
    }
}

class Buyer extends Person {

    public Buyer(String name, int age, String occupation, int bankBalance) {
        super(name, age, occupation, bankBalance);
    }
}

class Seller extends Person {

    public Seller(String name, int age, String occupation, int bankBalance) {
        super(name, age, occupation, bankBalance);
    }
}

class Owner extends Person {

    public Owner(String name, int age, String occupation, int bankBalance) {
        super(name, age, occupation, bankBalance);
    }
}

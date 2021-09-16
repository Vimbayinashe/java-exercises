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

class Dealer extends Person {
    private int rate;   //as a percentage

    public Dealer(String name, int age, String occupation, int bankBalance) {
        super(name, age, occupation, bankBalance);
        rate = 5;
    }

    public void sellVehicle(Vehicle vehicle, Person person) {
        int commission = (vehicle.price() * rate / 100);
        vehicle.removeOwner();
        person.deposit(vehicle.price() - commission);
        deposit(commission);
    }


    public void buyVehicle(Vehicle vehicle, Person person) {
        if(person.bankBalance() > vehicle.price()) {    //check for sufficient balance here?
            person.withdrawal(vehicle.price());
            vehicle.addOwner(person);
        }
    }

    //todo: is this method necessary?
    public void vehicleTransfer(Person seller, Vehicle vehicle, Person buyer) {
        if(buyer.bankBalance() > vehicle.price()) {
            sellVehicle(vehicle, seller);
            buyVehicle(vehicle, buyer);
        }
    }

    public int fee() {
        return rate;
    }

    public void fee(int fee) {
        this.rate = fee;
    }
}










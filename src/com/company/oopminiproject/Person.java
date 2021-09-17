package com.company.oopminiproject;

public abstract class Person {
    private final String name;
    private int age;
    private String occupation;
    private float bankBalance;

    public Person(String name, int age, String occupation, float bankBalance) {
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

    public float bankBalance() {
        return bankBalance;
    }

    public void deposit(float deposit) {
        this.bankBalance += deposit;
    }

    public void withdrawal(float withdrawal) {
        this.bankBalance -= withdrawal;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                ", bankBalance=" + bankBalance +
                '}';
    }
}

class Buyer extends Person {

    public Buyer(String name, int age, String occupation, float bankBalance) {
        super(name, age, occupation, bankBalance);
    }
}

class Seller extends Person {

    public Seller(String name, int age, String occupation, float bankBalance) {
        super(name, age, occupation, bankBalance);
    }
}

class Dealer extends Person {
    private final float COMMISSION = 0.15f;

    public Dealer(String name, int age, float bankBalance) {
        super(name, age, "Vehicle Dealer", bankBalance);
    }
    

    public void changeOwner(Vehicle vehicle, Buyer buyer) {
        Person seller = vehicle.getOwner();
        if(buyer.bankBalance() >= vehicle.price()) {     //not certain if this is the correct way to implement check
            settlePayment(buyer, seller, vehicle);      //or to handle insufficient balance
            vehicle.addOwner(buyer);
        } else  {
            System.out.println("Insufficient balance in " + buyer.name() + "'s account.");
        }
    }

    private void settlePayment(Buyer buyer, Person seller, Vehicle vehicle) {
        buyer.withdrawal(vehicle.price());
        seller.deposit(vehicle.price() * (1 - COMMISSION));
        this.deposit(vehicle.price() * COMMISSION);
    }

    //säkrare att bara ta emot Buyer objekt typ i changeOwner() så att endast de som köper får köpa

}

//Unknown Person / Null Person / Empty Person
class UnknownPerson extends Person {
    public UnknownPerson() {
        super("Börje", 20, "unknown", 0);
    }
}









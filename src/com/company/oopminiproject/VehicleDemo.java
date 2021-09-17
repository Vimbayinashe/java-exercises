package com.company.oopminiproject;

import com.company.oopminiproject.Person.*;

public class VehicleDemo {
    public static void main(String[] args) {

        Buyer buyer1 = new Buyer("Martin", 44 , "teacher", 1000_000_000);
        Buyer buyer2 = new Buyer("Albin", 24, "pilot", 50000);
        Buyer buyer3 = new Buyer("Vimbayi", 21, "developer", 350000);

        Seller seller1 = new Seller("Greger", 96, "Retired", 500);
        Seller seller2 = new Seller("Elon Musk", 50, "SpaceX CEO", 161_000_000_000f);

        Dealer dealer = new Dealer("Hans", 45, 0);

        Airplane  airplane = new Airplane(44000, 440_000_000, seller1);
        Helicopter helicopter = new Helicopter(1000, 21_000_000, seller1);
        Car car = new Car(29000, 450_000, 150000, seller2);

        dealer.changeOwner(airplane, buyer1);
        System.out.println(buyer1);
        System.out.println(airplane);
        System.out.println(seller1);
        System.out.println(dealer);

    }
}

package com.company.oopminiproject;

public class Main {
    public static void main(String[] args) {
//        RoadVehicle motorcykel = new RoadVehicle(1500, 5000, 20000);
//        WaterVessel boat = new WaterVessel(7000, 15000);
//        Aircraft airplane = new Aircraft(60000, 1000000);
//        Aircraft helicopter = new Aircraft(35000, 750000);
        Car car = new Car(3000, 20000, 100000, new UnknownPerson());    //using /instantiating Unknownperson inline

        Buyer buyer1 = new Buyer("Angela", 42, "teacher", 100000);
        Buyer buyer2 = new Buyer("Tom", 32, "carpenter", 60000);
        Buyer buyer3 = new Buyer("Phillipa", 26,  "nurse", 75000);

        Seller seller1 = new Seller("Martin", 47, "bank manager", 250000);
        Seller seller2 = new Seller("Mimi", 32, "shop attendant", 15000);

        Dealer max = new Dealer("Max", 43, 50000);

//        1 säljare ska äga flygplanet och helikoptern medan bilen ska ägas av den andre.
//        Låt nu köparna köpa varsitt
//        fordon. Skriv ut transaktionerna på skärmen

    }
}

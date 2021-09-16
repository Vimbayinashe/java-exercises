package com.company.oopminiproject;

//public interface TransportInterfaces {
//}

@FunctionalInterface
interface Driving {
    void drive(int km);   //en km-räknare som ökar när man kör. Man kör m.h.a. metoden drive(int kms)
}

@FunctionalInterface
interface GPS {
    void go();          //en GPS-position som slumpvis ändras när man åker med båten    //double Math.random
}


interface Flying {
    void fly(boolean isFlying);
}

package com.company.generics;

import com.company.inheritanceinterfaces.*;
import com.company.oopminiproject.Aircraft;
import com.company.oopminiproject.RoadVehicle;
import com.company.oopminiproject.Vehicle;

public class Trio <T extends Aircraft, U extends RoadVehicle, V extends Vehicle> {
    public T first;
    public U second;
    public V third;

    public static void main(String[] args) {

    }

}

package com.ematiej.maven_course.paterrn.factory;

public class Truck implements Vehicle{

    @Override
    public void createVehicle() {
        System.out.println("Truck created");
    }
}

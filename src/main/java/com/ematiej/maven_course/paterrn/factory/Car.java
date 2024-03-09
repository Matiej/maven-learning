package com.ematiej.maven_course.paterrn.factory;

public class Car implements Vehicle{
    @Override
    public void createVehicle() {
        System.out.println("Car created");
    }
}

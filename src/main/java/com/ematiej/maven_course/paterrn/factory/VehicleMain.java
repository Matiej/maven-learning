package com.ematiej.maven_course.paterrn.factory;

import java.util.ArrayList;
import java.util.List;

public class VehicleMain {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getVehicle(VehicleType.CAR);
        Vehicle truck = VehicleFactory.getVehicle(VehicleType.TRUCK);

        List<Vehicle> garage = new ArrayList<>();
        garage.add(car);
        garage.add(truck);

        garage.forEach(Vehicle::createVehicle);


    }
}

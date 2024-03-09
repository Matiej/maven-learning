package com.ematiej.maven_course.paterrn.factory;

public class VehicleFactory {
    public static Vehicle getVehicle(VehicleType vehicleType) {
        return switch (vehicleType) {
            case CAR -> new Car();
            case TRUCK -> new Truck();
        };
    }
}

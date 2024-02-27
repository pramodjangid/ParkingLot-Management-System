package com.parkinglot;

import java.util.*;

public class Floor {
    private int floorNumber;
    private List<VehicleSpace> vehicleSpaces;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.vehicleSpaces = new ArrayList<>();
        // Assuming 5 spaces per floor for each vehicle type
        for (int i = 0; i < 5; i++) {
            vehicleSpaces.add(new VehicleSpace(i + 1));
        }
    }

    public String addVehicle(Vehicle vehicle) {
        for (VehicleSpace space : vehicleSpaces) {
            if (space.isAvailable()) {
                space.setVehicle(vehicle); // Set the vehicle in the space
                space.setAvailability(false);
                return "Token" + (vehicleSpaces.indexOf(space) + 1);
            }
        }
        return null; // No available space
    }

    public boolean removeVehicle(String registrationNumber) {
        for (VehicleSpace space : vehicleSpaces) {
            if (!space.isAvailable() && space.getVehicle().getRegistrationNumber().equals(registrationNumber)) {
                space.setAvailability(true);
                return true;
            }
        }
        return false; // Vehicle not found
    }

    public List<VehicleSpace> getVehicleSpaces() {
        return vehicleSpaces;
    }
}
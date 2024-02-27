package com.parkinglot;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class ParkingLot {
    private List<Floor> floors;
    private int totalFloors;
    private Map<String, String> tokenMap; // Map to store token and registration number
    private CostStrategy costCalculator;

    public ParkingLot(int totalFloors, CostStrategy costCalculator) {
        this.totalFloors = totalFloors;
        this.costCalculator = costCalculator;
        this.floors = new ArrayList<>();
        for (int i = 0; i < totalFloors; i++) {
            this.floors.add(new Floor(i + 1));
        }
        this.tokenMap = new HashMap<>();
    }

    // Add vehicle to parking lot
    public String addVehicle(Vehicle vehicle) {
        for (Floor floor : floors) {
            String token = floor.addVehicle(vehicle);
            if (token != null) {
                tokenMap.put(token, vehicle.getRegistrationNumber());
                return token;
            }
        }
        return null; // Parking lot full
    }

    // Remove vehicle from parking lot
    public String removeVehicle(String token, int hours) {
        if (tokenMap.containsKey(token)) {
            String registrationNumber = tokenMap.get(token);
            VehicleType vehicleType = getVehicleType(registrationNumber);
            for (Floor floor : floors) {
                if (floor.removeVehicle(registrationNumber)) {
                    tokenMap.remove(token);
                    double cost = costCalculator.calculateCost(vehicleType, hours);
                    return "Vehicle with registration number " + registrationNumber + " removed. Parking fee: " + cost;
                }
            }
        }
        return "Invalid token or vehicle not found.";
    }

    // Check availability of vehicle spaces on a specific floor for a given vehicle type using Stream API
    public boolean checkAvailability(int floorNumber, VehicleType vehicleType) {
        if (floorNumber <= totalFloors && floorNumber > 0) {
            Floor floor = floors.get(floorNumber - 1);
            return floor.getVehicleSpaces().stream()
                    .filter(space -> space.getVehicleType() == vehicleType)
                    .anyMatch(VehicleSpace::isAvailable);
        }
        return false;
    }
    
    
 // method to get the vehicle type from the registration number
    private VehicleType getVehicleType(String registrationNumber) {
        for (Floor floor : floors) {
            for (VehicleSpace space : floor.getVehicleSpaces()) {
                if (!space.isAvailable() && space.getVehicle().getRegistrationNumber().equals(registrationNumber)) {
                    return space.getVehicle().getVehicleType();
                }
            }
        }
        return null; // Vehicle not found
    }
}
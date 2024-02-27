package com.parkinglot.config;

import com.parkinglot.*;

public class Main {
    public static void main(String[] args) {
        // Initialize parking lot with 2 floors and flat cost strategy
        CostStrategy costCalculator = new FlatCostStrategy();
        ParkingLot parkingLot = new ParkingLot(2, costCalculator);

        // Use Case 1: Initializing the Parking Lot for 2 Cars
        System.out.println("Initializing the Parking Lot for 2 Cars...");

        // Use Case 2: Enter 2 car details , generating a token id for each car
        System.out.println("\nEnter 2 car details...");
        Vehicle car1 = new Vehicle("Verna", VehicleType.CAR, "White");
        String token1 = parkingLot.addVehicle(car1);
        if (token1 != null) {
            System.out.println("Car with registration number " + car1.getRegistrationNumber() + " arrived at the parking lot.");
            System.out.println("Token issued: " + token1);
        } else {
            System.out.println("Parking lot is full. Unable to accommodate the car.");
        }

        Vehicle car2 = new Vehicle("Honda", VehicleType.CAR, "Black");
        String token2 = parkingLot.addVehicle(car2);
        if (token2 != null) {
            System.out.println("Car with registration number " + car2.getRegistrationNumber() + " arrived at the parking lot.");
            System.out.println("Token issued: " + token2);
        } else {
            System.out.println("Parking lot is full. Unable to accommodate the car.");
        }

        // Use Case 3: Check if the token is correct and get car details along with the total amount for the parking fee
        System.out.println("\nCheck if the token is correct and get car details with parking fee...");
        String tokenToCheck = token1; // Change the token to check here
        int hoursParked = 2; // Sample hours parked
        String result = parkingLot.removeVehicle(tokenToCheck, hoursParked);
        System.out.println(result);

        // Use Case 4: Attempt to enter the next car when the capacity is full
        System.out.println("\nAttempting to enter the next car when the capacity is full...(If its not full it will generate the token)");
        Vehicle car3 = new Vehicle("Toyota", VehicleType.CAR, "Red");
        String token3 = parkingLot.addVehicle(car3);
        if (token3 != null) {
            System.out.println("Car with registration number " + car3.getRegistrationNumber() + " arrived at the parking lot.");
            System.out.println("Token issued: " + token3);
        } else {
            System.out.println("Parking lot is full. Unable to accommodate the car.");
        }
    }
}

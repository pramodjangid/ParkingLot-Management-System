package com.parkinglot;

import java.time.LocalDateTime;

public class Vehicle {
    private String registrationNumber;
    private VehicleType vehicleType;
    private String color;
    private LocalDateTime entryTime;

    public Vehicle(String registrationNumber, VehicleType vehicleType, String color) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
        this.color = color;
        this.entryTime = LocalDateTime.now(); // Record entry time
    }


    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

	public LocalDateTime getEntryTime() {
		return entryTime;
	}
    
}
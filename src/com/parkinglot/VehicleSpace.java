package com.parkinglot;


public class VehicleSpace {
    private int spaceNumber;
    private boolean availability;
    private Vehicle vehicle;

    public VehicleSpace(int spaceNumber) {
        this.spaceNumber = spaceNumber;
        this.availability = true;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleType getVehicleType() {
        return vehicle.getVehicleType();
    }
}

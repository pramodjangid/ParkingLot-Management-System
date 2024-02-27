package com.parkinglot;

public class FlatCostStrategy implements CostStrategy {
    @Override
    public double calculateCost(VehicleType vehicleType, int hours) {
        switch (vehicleType) {
            case CAR:
                return 20 * hours;
            case SPORTS_CAR:
                return 20 * hours;
            case TRUCK:
                return 30 * hours;
            case BUS:
                return 30 * hours;
            default:
                return 0;
        }
    }
}

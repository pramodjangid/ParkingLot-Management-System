package com.parkinglot;

public interface CostStrategy {
	double calculateCost(VehicleType vehicleType, int hours);
}

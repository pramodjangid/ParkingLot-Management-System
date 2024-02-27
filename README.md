# Parking Lot Management System

## Description
This Java project implements a parking lot management system that can accommodate different types of vehicles and supports a configurable cost strategy for parking fees. The system allows users to initialize the parking lot, add vehicles, remove vehicles, and check the availability of parking spaces on specific floors for different vehicle types.

## Features
- Initialize the parking lot with a given number of floors and car spaces per floor.
- Add vehicle details to the parking lot, including vehicle type, registration number, and color.
- Remove a vehicle from the parking lot based on the token ID.
- Check the availability of vehicle spaces on a specific floor for a given vehicle type.
- Supports configurable cost strategies for parking fees based on vehicle types and duration.

## Usage
1. **Initialization**: Initialize the parking lot with the desired number of floors and car spaces per floor.
2. **Adding Vehicles**: Add vehicles to the parking lot by providing details such as vehicle type, registration number, and color.
3. **Removing Vehicles**: Remove vehicles from the parking lot by providing token ID.
4. **Checking Availability**: Check the availability of vehicle spaces on specific floors for different vehicle types.
5. **Cost Calculation**: The system calculates parking fees based on the configured cost strategy and the duration for which a vehicle is parked.

## Installation
1. Clone the project repository to your local machine.
2. Import the project into your Java IDE.
3. Build and run the `Main` class to execute the parking lot management system.

## Configuration
- Adjust the number of floors and car spaces per floor in the `ParkingLot` class constructor.
- Modify the cost strategy by implementing the `CostStrategy` interface and providing custom calculation logic.
- Explore and extend the codebase to add new functionalities or adapt to specific requirements.

## Dependencies
- Java 8 or higher

## Contributors
- [Pramod Kumar Jangid](https://github.com/pramodjangid) - Java Backend Developer


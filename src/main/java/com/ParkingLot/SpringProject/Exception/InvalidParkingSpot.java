package com.ParkingLot.SpringProject.Exception;

public class InvalidParkingSpot extends RuntimeException {
    public InvalidParkingSpot(Long spotId) {
        super("Invalid Spot Id: "+spotId);
    }
}

package com.ParkingLot.SpringProject.Exception;

public class InvalidNumberOfSPots extends RuntimeException {
    public InvalidNumberOfSPots(String e){
        super(e);
    }
}

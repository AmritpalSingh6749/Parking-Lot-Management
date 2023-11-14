package com.ParkingLot.SpringProject.Exception;

public class InvalidParkingFloor extends RuntimeException{
    public InvalidParkingFloor(Long e){
        super("Floor Id does not exist: "+e);
    }
}

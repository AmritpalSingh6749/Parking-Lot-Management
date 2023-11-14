package com.ParkingLot.SpringProject.Exception;

public class InvalidNumberOfFloor extends RuntimeException{
    public InvalidNumberOfFloor(String e){
        super(e);
    }
}

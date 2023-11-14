package com.ParkingLot.SpringProject.Exception;

public class InvalidNumberOfGates extends RuntimeException{
    public InvalidNumberOfGates(String e){
        super(e);
    }
}

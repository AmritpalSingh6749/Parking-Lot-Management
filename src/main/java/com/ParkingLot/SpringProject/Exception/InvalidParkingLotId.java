package com.ParkingLot.SpringProject.Exception;

public class InvalidParkingLotId  extends RuntimeException{
    public InvalidParkingLotId(Long e){
        super("Parking Lot Id Does not exist: "+e);
    }
}

package com.ParkingLot.SpringProject.Model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@SuperBuilder
@Getter
public class ParkingFloor extends BaseModel {
    private int floorNumber;
    private List<ParkingSpot> spots = new ArrayList<>();
    private DisplayBoard displayBoard;
    private PaymentCounter paymentCounter;

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}

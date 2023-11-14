package com.ParkingLot.SpringProject.Model;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Vehicle extends BaseModel {
    private String number;
    private VehicleType type;

}

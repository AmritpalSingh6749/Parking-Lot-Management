package com.ParkingLot.SpringProject.dtos;

import com.ParkingLot.SpringProject.Model.VehicleType;
import lombok.Getter;

@Getter
public class CreateParkingSpotRequest {
    private VehicleType vehicleType;
}

package com.ParkingLot.SpringProject.dtos;

import com.ParkingLot.SpringProject.Model.SpotStatus;
import lombok.Getter;

@Getter
public class UpdateParkingSpotRequest {
    private SpotStatus status;
}

package com.ParkingLot.SpringProject.Model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ParkingSpot extends BaseModel {
    private Integer spotId;
    private SpotStatus spotStatus;
    private VehicleType vehicleType;
    public static Integer nextId = 0;

    public void setStatus(SpotStatus status) {
        this.spotStatus = status;
    }
}

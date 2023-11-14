package com.ParkingLot.SpringProject.dtos;

import com.ParkingLot.SpringProject.Model.VehicleType;

public class CreateTicketRequest {
    private Long parkingLotId;
    private String vehicleNumber;
    private VehicleType vehicleType;
    private Long entryGateId;
    private Long issuerId;
}

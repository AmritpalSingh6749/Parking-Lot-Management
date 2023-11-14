package com.ParkingLot.SpringProject.Model;

import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuperBuilder
public class Ticket extends BaseModel{
    private ParkingSpot spot;
    private Long vehicleId;
    private Date entryTime;
    private List<Invoice> invliceList = new ArrayList<>();
    private Long spotId;
    private Gate entryGate;
}

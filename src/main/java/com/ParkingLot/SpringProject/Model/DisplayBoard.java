package com.ParkingLot.SpringProject.Model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuperBuilder
@Getter
public class DisplayBoard extends BaseModel{
    private Date date;
    private List<ParkingSpot> spots = new ArrayList<>();

}

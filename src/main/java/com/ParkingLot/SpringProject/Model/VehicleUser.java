package com.ParkingLot.SpringProject.Model;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class VehicleUser extends User{
    private Vehicle vehicle;
}

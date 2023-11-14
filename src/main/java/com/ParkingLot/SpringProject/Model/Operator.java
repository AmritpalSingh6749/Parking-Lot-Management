package com.ParkingLot.SpringProject.Model;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Operator extends User {
    private Gate gate;
}

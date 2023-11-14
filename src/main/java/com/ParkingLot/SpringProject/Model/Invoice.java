package com.ParkingLot.SpringProject.Model;

import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
public class Invoice extends BaseModel {
    private Date exitTime;
    private Ticket ticket;
    private double amount;
    private Gate exitGate;
}

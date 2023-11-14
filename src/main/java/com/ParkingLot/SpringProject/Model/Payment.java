package com.ParkingLot.SpringProject.Model;

import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuperBuilder
public class Payment extends BaseModel{
    private PaymentMode mode;
    private double amount;
    private String reference;
    private PaymentStatus status;
    private Date date;
    private List<Invoice> invoices = new ArrayList<>();
}

package com.ParkingLot.SpringProject.Model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ExitGate extends Gate {
    private PaymentCounter paymentCounter;
}

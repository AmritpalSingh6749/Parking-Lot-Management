package com.ParkingLot.SpringProject.Model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class PaymentCounter extends BaseModel {
    private Long floorId;
}

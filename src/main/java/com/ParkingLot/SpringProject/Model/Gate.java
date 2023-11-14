package com.ParkingLot.SpringProject.Model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Gate extends BaseModel{
    private Integer gateId;
    private Operator operator;
}

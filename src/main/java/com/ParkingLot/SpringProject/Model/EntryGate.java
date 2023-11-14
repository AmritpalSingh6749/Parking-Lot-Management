package com.ParkingLot.SpringProject.Model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class EntryGate extends Gate {
    private DisplayBoard displayBoard;
}

package com.ParkingLot.SpringProject.Model;

import com.ParkingLot.SpringProject.dtos.UpdateParkingLotRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@SuperBuilder
@Getter
public class ParkingLot extends BaseModel {
    private String name;
    private String address;
    private List<ParkingFloor> parkingFloors = new ArrayList<>();
    private List<Gate> entryGates = new ArrayList<>();
    private List<Gate> exitGates = new ArrayList<>();
    private List<DisplayBoard> displayBoard;
    private static Long nextId = 0L;

    public static Long getNextId() {
        nextId++;
        return nextId;
    }
    public void setParkingFloors(ParkingFloor floor){
        parkingFloors.add(floor);
    }
    public void setNameAndAddress(UpdateParkingLotRequest request){
        this.name = request.getName();
        this.address = request.getAddress();
    }
}

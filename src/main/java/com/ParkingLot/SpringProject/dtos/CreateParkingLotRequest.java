package com.ParkingLot.SpringProject.dtos;

import com.ParkingLot.SpringProject.Data.GateData;
import com.ParkingLot.SpringProject.Data.ParkingFloorData;
import com.ParkingLot.SpringProject.Data.ParkingSpotData;
import com.ParkingLot.SpringProject.Model.*;
import lombok.Getter;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

@Getter
public class CreateParkingLotRequest {
    private String name;
    private String address;
    private Integer numberOfFloors;
    private Integer numberOfEntryGates;
    private Integer numberOfExitGates;
    private Map<VehicleType, Integer> numberOfSpotsPerFloor = new HashMap<>();
    private Long ParkingLotId = ParkingLot.getNextId();
    private Long floorId = 0L;
    private Long spotId = 0L;

    public ParkingLot toParkingLot(){
        Long lotId = ParkingLot.getNextId();
        List<Gate> entryGates = getEntryGateList();
        List<Gate> exitGates = getExitGateList();
        List<DisplayBoard> listBoard = new ArrayList<>();
        List<ParkingFloor> floors = getFloorList(listBoard);

        return ParkingLot.builder()
                .name(getName())
                .address(getAddress())
                .entryGates(entryGates)
                .exitGates(exitGates)
                .parkingFloors(floors)
                .displayBoard(listBoard)
                .id(lotId)
                .createdAt(new Date())
                .build();
    }

    private List<ParkingFloor> getFloorList(List<DisplayBoard> board) {
        List<ParkingFloor> floorList = new ArrayList<>();
        IntStream.range(0,numberOfFloors).forEach(x -> floorList.add(getFloor(x, board)));
        return floorList;
    }

    public ParkingFloor getFloor(Integer floorNumber, List<DisplayBoard> board) {
        List<ParkingSpot> spotList = getSpotList();
        floorId = getParkingLotId()*10000+floorNumber;
        DisplayBoard displayBoard = DisplayBoard.builder()
                .createdAt(new Date())
                .spots(spotList)
                .build();
        board.add(displayBoard);

        ParkingFloor floor = ParkingFloor.builder()
                .createdAt(new Date())
                .floorNumber(floorNumber)
                .spots(spotList)
                .displayBoard(displayBoard)
                .id(floorId)
                .build();
        ParkingFloorData.floorList.add(floor);
        return floor;
    }

    private List<ParkingSpot> getSpotList() {
        List<ParkingSpot> spotList = new ArrayList<>();
        AtomicReference<Integer> spotId = new AtomicReference<>(0);
        numberOfSpotsPerFloor.forEach(
                (key, value) -> IntStream.range(0, value).forEach(x -> {
                    spotList.add(getParkingSpot(key, spotId.get()));
                    spotId.getAndSet(spotId.get() + 1);
                })
        );
        return spotList;
    }

    private ParkingSpot getParkingSpot(VehicleType type, Integer id) {
        spotId = floorId*10000+id;
        ParkingSpot spot = ParkingSpot.builder()
                .spotId(id)
                .vehicleType(type)
                .id(spotId)
                .createdAt(new Date())
                .spotStatus(SpotStatus.AVAILABLE)
                .build();
        ParkingSpotData.spotList.add(spot);
        return spot;
    }

    private List<Gate> getExitGateList() {
        List<Gate> exitGate = new ArrayList<>();
        IntStream.range(0,numberOfExitGates).forEach(x -> exitGate.add(getExitGate(x)));
        return exitGate;
    }

    private Gate getExitGate(Integer gateNumber) {
        Gate exitGate =  ExitGate.builder()
                .createdAt(new Date())
                .gateId(gateNumber)
                .id(getParkingLotId()*10000+gateNumber)
                .build();
        GateData.exitGateList.add(exitGate);
        return exitGate;
    }

    private List<Gate> getEntryGateList() {
        List<Gate> entryGate = new ArrayList<>();
        IntStream.range(0,numberOfEntryGates).forEach(x -> entryGate.add(getEntryGate(x)));
        return entryGate;
    }

    private Gate getEntryGate(Integer gateNumber) {
        Gate entryGate = EntryGate.builder()
                .createdAt(new Date())
                .gateId(gateNumber)
                .id(getParkingLotId()*10000+gateNumber)
                .build();
        GateData.entryGateList.add(entryGate);
        return entryGate;
    }
}

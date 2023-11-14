package com.ParkingLot.SpringProject.dtos;

import com.ParkingLot.SpringProject.Data.ParkingFloorData;
import com.ParkingLot.SpringProject.Data.ParkingSpotData;
import com.ParkingLot.SpringProject.Model.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class CreateParkingFloorRequest {
    private Integer floorNumber;
    private Map<VehicleType, Integer> numberOfSpotsPerFloor = new HashMap<>();

    public ParkingFloor toParkingFLoor(Long lotId){
        Long floorId = lotId*10000+floorNumber;
        DisplayBoard board = DisplayBoard.builder()
                .createdAt(new Date())
                .id(floorId)
                .spots(getSpotList(floorId))
                .build();
        ParkingFloor floor = ParkingFloor.builder()
                .createdAt(new Date())
                .floorNumber(floorNumber)
                .id(floorId)
                .displayBoard(board)
                .build();
        ParkingFloorData.floorList.add(floor);
        return floor;
    }

    private List<ParkingSpot> getSpotList(Long floorId) {
        List<ParkingSpot> spotList = new ArrayList<>();
        AtomicReference<Integer> spotId = new AtomicReference<>(0);
        numberOfSpotsPerFloor.forEach(
                (key, value) -> IntStream.range(0, value).forEach(x -> {
                    spotList.add(getParkingSpot(key, spotId.get(), floorId));
                    spotId.getAndSet(spotId.get() + 1);
                })
        );
        return spotList;
    }

    private ParkingSpot getParkingSpot(VehicleType type, Integer number, Long floorId) {
        ParkingSpot spot = ParkingSpot.builder()
                .createdAt(new Date())
                .spotStatus(SpotStatus.AVAILABLE)
                .id(floorId*10000+number)
                .spotId(number)
                .vehicleType(type)
                .build();
        ParkingSpotData.spotList.add(spot);
        return spot;
    }
}

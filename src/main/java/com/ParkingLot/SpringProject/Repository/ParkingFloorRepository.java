package com.ParkingLot.SpringProject.Repository;

import com.ParkingLot.SpringProject.Data.ParkingFloorData;
import com.ParkingLot.SpringProject.Data.ParkingLotData;
import com.ParkingLot.SpringProject.Data.ParkingSpotData;
import com.ParkingLot.SpringProject.Exception.InvalidParkingFloor;
import com.ParkingLot.SpringProject.Exception.InvalidParkingLotId;
import com.ParkingLot.SpringProject.Model.ParkingFloor;
import com.ParkingLot.SpringProject.Model.ParkingLot;
import com.ParkingLot.SpringProject.dtos.CreateParkingFloorRequest;
import com.ParkingLot.SpringProject.dtos.UpdateParkingFloorRequest;
import org.springframework.stereotype.Repository;
import java.util.Objects;

@Repository
public class ParkingFloorRepository {
    public ParkingFloor fetch(Long id) {
        for(ParkingFloor floor : ParkingFloorData.floorList)
            if(Objects.equals(floor.getId(),id))
                return floor;
        throw new InvalidParkingFloor(id);
    }
    public void delete(Long id, Long lotid){
        for(ParkingFloor floor : ParkingFloorData.floorList){
            if(Objects.equals(floor.getId(),id)) {
                ParkingFloorData.floorList.remove(floor);
                removeFromParkingLot(lotid, floor);
                removeParkingSpots(floor);
                return;
            }
        }
    }

    private void removeParkingSpots(ParkingFloor floor) {
        floor.getSpots().forEach(spot -> ParkingSpotData.spotList.remove(spot));
    }

    private void removeFromParkingLot(long lotId, ParkingFloor floor) {
        for(ParkingLot lot : ParkingLotData.lotList)
            if(Objects.equals(lot.getId(),lotId)) {
                lot.getParkingFloors().remove(floor);
                return;
            }
    }

    public ParkingLot create(Long lotId, CreateParkingFloorRequest request){
        for(ParkingLot lot : ParkingLotData.lotList)
            if(Objects.equals(lot.getId(), lotId)){
                lot.setParkingFloors(request.toParkingFLoor(lotId));
                return lot;
            }
        throw new InvalidParkingLotId(lotId);
    }
    public ParkingFloor update(UpdateParkingFloorRequest request, Long id){
        for(ParkingFloor floor : ParkingFloorData.floorList)
            if (Objects.equals(floor.getId(),id)){
                floor.setFloorNumber(request.getFloorNumber());
                return floor;
            }
        throw new InvalidParkingFloor(id);
    }
}

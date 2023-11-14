package com.ParkingLot.SpringProject.Repository;

import com.ParkingLot.SpringProject.Data.ParkingFloorData;
import com.ParkingLot.SpringProject.Data.ParkingLotData;
import com.ParkingLot.SpringProject.Data.ParkingSpotData;
import com.ParkingLot.SpringProject.Exception.InvalidParkingFloor;
import com.ParkingLot.SpringProject.Exception.InvalidParkingLotId;
import com.ParkingLot.SpringProject.Exception.InvalidParkingSpot;
import com.ParkingLot.SpringProject.Model.ParkingFloor;
import com.ParkingLot.SpringProject.Model.ParkingSpot;
import com.ParkingLot.SpringProject.dtos.UpdateParkingSpotRequest;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.bind.validation.BindValidationException;
import org.springframework.stereotype.Repository;

import java.util.Objects;


@Repository
@AllArgsConstructor
public class ParkingSpotRepository {
    public ParkingSpot fetchParkingSpot(Long spotId){
        for(ParkingSpot spot : ParkingSpotData.spotList)
            if(Objects.equals(spot.getId(),spotId))
                return spot;
        throw new InvalidParkingSpot(spotId);
    }

    public ParkingFloor addParkingSpot(ParkingSpot spot, Long floorId) {
        for(ParkingFloor floor : ParkingFloorData.floorList)
            if(Objects.equals(floor.getId(),floorId)) {
                floor.getSpots().add(spot);
                return floor;
            }
        throw new InvalidParkingFloor(floorId);
    }

    public ParkingSpot updateParkingSPot(UpdateParkingSpotRequest request, long spotId) {
        for(ParkingSpot spot : ParkingSpotData.spotList)
            if(Objects.equals(spot.getId(),spotId)){
                spot.setStatus(request.getStatus());
                return spot;
            }
        throw new InvalidParkingSpot(spotId);
    }

    public ParkingSpot getSpot(Long id) {
        for(ParkingSpot spot : ParkingSpotData.spotList)
            if(Objects.equals(spot.getId(),id))
                return spot;
        throw new InvalidParkingSpot(id);
    }

    public void deleteSpot(Long spotId) {
        for(ParkingSpot spot : ParkingSpotData.spotList)
            if(Objects.equals(spot.getId(), spotId)){
                ParkingSpotData.spotList.remove(spot);
                return;
            }
        throw new InvalidParkingSpot(spotId);
    }
}

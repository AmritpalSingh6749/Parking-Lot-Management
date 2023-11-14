package com.ParkingLot.SpringProject.Repository;

import com.ParkingLot.SpringProject.Data.ParkingFloorData;
import com.ParkingLot.SpringProject.Data.ParkingLotData;
import com.ParkingLot.SpringProject.Exception.InvalidParkingFloor;
import com.ParkingLot.SpringProject.Exception.InvalidParkingLotId;
import com.ParkingLot.SpringProject.Model.DisplayBoard;
import com.ParkingLot.SpringProject.Model.ParkingFloor;
import com.ParkingLot.SpringProject.Model.ParkingLot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@AllArgsConstructor
public class DisplayBoardRepository {
    public List<DisplayBoard> fetchParkingLot(Long id){
        for(ParkingLot lot : ParkingLotData.lotList)
            if(Objects.equals(lot.getId(),id))
                return lot.getDisplayBoard();
        throw new InvalidParkingLotId(id);
    }


    public DisplayBoard fetchParkingFloor(Long floorId) {
        for(ParkingFloor floor : ParkingFloorData.floorList)
            if(Objects.equals(floor.getId(),floorId))
                return floor.getDisplayBoard();
        throw new InvalidParkingFloor(floorId);
    }

}

package com.ParkingLot.SpringProject.Repository;

import com.ParkingLot.SpringProject.Data.ParkingLotData;
import com.ParkingLot.SpringProject.Exception.InvalidParkingLotId;
import com.ParkingLot.SpringProject.Model.ParkingLot;
import com.ParkingLot.SpringProject.dtos.UpdateParkingLotRequest;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class ParkingLotRepository {
    public void save(ParkingLot parkingLot) {
        ParkingLotData.lotList.add(parkingLot);
    }
    public void delete(long id) {
        ParkingLotData.lotList.remove((int)id);
    }
    public ParkingLot update(UpdateParkingLotRequest request, Long id){
        for(ParkingLot lot : ParkingLotData.lotList)
            if(Objects.equals(lot.getId(),id)) {
                lot.setNameAndAddress(request);
                return lot;
            }
        throw new InvalidParkingLotId(id);
    }

    public ParkingLot fetch(Long id) {
        for(ParkingLot lot : ParkingLotData.lotList)
            if(Objects.equals(lot.getId(),id))
                return lot;
        throw new InvalidParkingLotId(id);
    }
}

package com.ParkingLot.SpringProject.Service;

import com.ParkingLot.SpringProject.Data.ParkingSpotData;
import com.ParkingLot.SpringProject.Model.ParkingFloor;
import com.ParkingLot.SpringProject.Model.ParkingSpot;
import com.ParkingLot.SpringProject.Model.SpotStatus;
import com.ParkingLot.SpringProject.Repository.ParkingSpotRepository;
import com.ParkingLot.SpringProject.dtos.CreateParkingSpotRequest;
import com.ParkingLot.SpringProject.dtos.UpdateParkingSpotRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.accessibility.AccessibleValue;

@Service
@AllArgsConstructor
public class ParkingSpotService {
    private ParkingSpotRepository repository;
    public ParkingFloor createParkingSPot(CreateParkingSpotRequest parkingSpot, Long floorId){
        return repository.addParkingSpot(toParkingSPot(parkingSpot, floorId), floorId);
    }

    private ParkingSpot toParkingSPot(CreateParkingSpotRequest request, Long floorId){
        ParkingSpot spot = ParkingSpot.builder()
                .id(floorId*10000 + ParkingSpot.nextId)
                .spotStatus(SpotStatus.AVAILABLE)
                .vehicleType(request.getVehicleType())
                .build();
        ParkingSpotData.spotList.add(spot);
        return spot;
    }
    public ParkingSpot getParkingSpot(Long id) {
        return repository.getSpot(id);
    }

    public ParkingSpot updateParkingSPot(UpdateParkingSpotRequest request, long spotId) {
        return repository.updateParkingSPot(request,spotId);
    }

    public void deleteSpot(Long spotId){
        repository.deleteSpot(spotId);
    }

}

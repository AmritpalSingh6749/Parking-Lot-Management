package com.ParkingLot.SpringProject.Service;

import com.ParkingLot.SpringProject.Model.ParkingFloor;
import com.ParkingLot.SpringProject.Model.ParkingLot;
import com.ParkingLot.SpringProject.Repository.ParkingFloorRepository;
import com.ParkingLot.SpringProject.dtos.CreateParkingFloorRequest;
import com.ParkingLot.SpringProject.dtos.UpdateParkingFloorRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParkingFloorService {
    private ParkingFloorRepository repository;

    public ParkingFloor getFloor(Long id) {
        return repository.fetch(id);
    }

    public ParkingFloor updateFloor(UpdateParkingFloorRequest request, Long id){
        return repository.update(request,id);
    }

    public ParkingLot createFloor(Long lotId, CreateParkingFloorRequest request){
        return repository.create(lotId,request);
    }
    public void deleteFloor(Long id, Long lotid){
        repository.delete(id, lotid);
    }
}

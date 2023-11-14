package com.ParkingLot.SpringProject.Service;

import com.ParkingLot.SpringProject.Model.DisplayBoard;
import com.ParkingLot.SpringProject.Model.ParkingFloor;
import com.ParkingLot.SpringProject.Model.ParkingLot;
import com.ParkingLot.SpringProject.Repository.DisplayBoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DisplayBoardService {
    public DisplayBoardRepository repository;
    public List<DisplayBoard> getParkingLot(Long lotId){
        return repository.fetchParkingLot(lotId);
    }

    public DisplayBoard getParkingFloor(Long floorId) {
        return repository.fetchParkingFloor(floorId);
    }
}

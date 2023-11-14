package com.ParkingLot.SpringProject.Controller;

import com.ParkingLot.SpringProject.Model.ParkingFloor;
import com.ParkingLot.SpringProject.Model.ParkingLot;
import com.ParkingLot.SpringProject.Service.ParkingFloorService;
import com.ParkingLot.SpringProject.Service.ParkingLotService;
import com.ParkingLot.SpringProject.dtos.CreateParkingFloorRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/parking-floor")
public class ParkingFloorController {
    private ParkingFloorService service;

    @GetMapping("/{id}")
    public ParkingFloor getParkingFloor(@PathVariable("id")Long id){
        return service.getFloor(id);
    }
    @PostMapping("create/{id}")
    public ParkingLot createParkingFloor(@RequestBody CreateParkingFloorRequest request, @PathVariable("id") Long lotId){
        return service.createFloor(lotId,request);
    }
    @DeleteMapping("/delete/{floor-id}/{lot-id}")
    public void deleteFloor(@PathVariable("floor-id") Long floorId, @PathVariable("lot-id") Long lotid){
        service.deleteFloor(floorId,lotid);
    }
}

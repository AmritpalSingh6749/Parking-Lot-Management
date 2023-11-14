package com.ParkingLot.SpringProject.Controller;

import com.ParkingLot.SpringProject.Model.ParkingFloor;
import com.ParkingLot.SpringProject.Model.ParkingSpot;
import com.ParkingLot.SpringProject.Service.ParkingSpotService;
import com.ParkingLot.SpringProject.dtos.CreateParkingSpotRequest;
import com.ParkingLot.SpringProject.dtos.UpdateParkingSpotRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/parking-spot")
public class ParkingSpotController {
    private ParkingSpotService service;
    // CRUD
    @GetMapping("/{id}")
    public ParkingSpot getParkingSpot(@PathVariable("id") Long id){
        return service.getParkingSpot(id);
    }
    @PutMapping("/add/{floor-id}")
    public ParkingFloor createParkingSpot(@RequestBody CreateParkingSpotRequest request, @PathVariable("floor-id") long id){
        return service.createParkingSPot(request,id);
    }
    @PostMapping("/set/{spot-id}")
    public ParkingSpot modifySpot(@RequestBody UpdateParkingSpotRequest request, @PathVariable("spot-id") long spotId){
        return service.updateParkingSPot(request,spotId);
    }

    @DeleteMapping("/delete/{spot-Id}")
    public void deleteSpot(@PathVariable("spot-id") Long spotId){
        service.deleteSpot(spotId);
    }

}

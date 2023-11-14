package com.ParkingLot.SpringProject.Controller;

import com.ParkingLot.SpringProject.Exception.InvalidNumberOfFloor;
import com.ParkingLot.SpringProject.Exception.InvalidNumberOfGates;
import com.ParkingLot.SpringProject.Exception.InvalidNumberOfSPots;
import com.ParkingLot.SpringProject.Model.ParkingLot;
import com.ParkingLot.SpringProject.Service.ParkingLotService;
import com.ParkingLot.SpringProject.dtos.CreateParkingLotRequest;
import com.ParkingLot.SpringProject.dtos.UpdateParkingLotRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/parking-lot")
public class ParkingLotController {
    private ParkingLotService parkingLotService;
    @PostMapping
    public ParkingLot createParkingLot(@RequestBody CreateParkingLotRequest request){
        validate(request);
        ParkingLot parkingLot = request.toParkingLot();
        parkingLotService.create(parkingLot);
        return parkingLot;
    }
    @GetMapping("/{id}")
    public ParkingLot getParkingLot(@PathVariable("id") Long id){
        return parkingLotService.getParkingLot(id);
    }

    @PutMapping("/update/{id}")
    public ParkingLot updateParkingLotName(@PathVariable("id") Long id, @RequestBody UpdateParkingLotRequest request){
        return  parkingLotService.update(request,id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteParkingLot(@PathVariable("id") long id){
        parkingLotService.delete(id);
    }
    private void validate(CreateParkingLotRequest request) {
        if(request.getNumberOfFloors()<1)
            throw new InvalidNumberOfFloor("Invalid Number of floors!");
        if(request.getNumberOfEntryGates() < 1 || request.getNumberOfExitGates() < 1)
            throw new InvalidNumberOfGates("Invalid Number of Gates "+request.getNumberOfEntryGates()+", " + request.getNumberOfExitGates());
        if(request.getNumberOfSpotsPerFloor().entrySet().size() <= 0)
            throw new InvalidNumberOfSPots("Invalid Number Of Spot: " + request.getNumberOfSpotsPerFloor());
    }
}

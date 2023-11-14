package com.ParkingLot.SpringProject.Controller;

import com.ParkingLot.SpringProject.Model.DisplayBoard;
import com.ParkingLot.SpringProject.Model.ParkingFloor;
import com.ParkingLot.SpringProject.Model.ParkingLot;
import com.ParkingLot.SpringProject.Service.DisplayBoardService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/display-board")
public class DisplayBoardController {
    private DisplayBoardService service;

    @GetMapping("/lot/{lot-id}")
    public List<DisplayBoard> getDisplayBoard(@PathVariable("lot-id") Long lotId){
        return service.getParkingLot(lotId);
    }

    @GetMapping("/floor/{floor-id}")
    public DisplayBoard getParkingFloor(@PathVariable("floor-id") Long floorId){
        return service.getParkingFloor(floorId);
    }

}

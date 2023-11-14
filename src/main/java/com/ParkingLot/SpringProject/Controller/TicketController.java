package com.ParkingLot.SpringProject.Controller;

import com.ParkingLot.SpringProject.Model.Ticket;
import com.ParkingLot.SpringProject.Service.TicketService;
import com.ParkingLot.SpringProject.dtos.CreateTicketRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/ticket")
@AllArgsConstructor
public class TicketController {
    private TicketService ticketService;
    @PostMapping
    public Ticket createTicket(@RequestBody CreateTicketRequest request){
        return null;
    }
}

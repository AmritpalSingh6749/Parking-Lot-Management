package com.ParkingLot.SpringProject.Service;

import com.ParkingLot.SpringProject.Repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketService {
    private TicketRepository ticketRepository;
}

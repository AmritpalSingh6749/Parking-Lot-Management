package com.ParkingLot.SpringProject.Repository;

import com.ParkingLot.SpringProject.Model.Ticket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class TicketRepository {
    private List<Ticket> ticketList = new ArrayList<>();
    public void save(Ticket ticket){
        ticketList.add(ticket);
    }
}

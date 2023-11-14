package com.ParkingLot.SpringProject.Repository;

import com.ParkingLot.SpringProject.Model.Ticket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class InvoiceRepository {
    public Ticket getTicket(Long id) {
        return null;
    }
}

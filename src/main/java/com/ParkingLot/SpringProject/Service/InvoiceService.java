package com.ParkingLot.SpringProject.Service;

import com.ParkingLot.SpringProject.Model.Invoice;
import com.ParkingLot.SpringProject.Model.Ticket;
import com.ParkingLot.SpringProject.Repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InvoiceService {
    private InvoiceRepository repository;
    public Invoice getInvoice(Long id){
        Ticket ticket = repository.getTicket(id);
        Invoice inv = Invoice.builder().build();
        return null;
    }
}

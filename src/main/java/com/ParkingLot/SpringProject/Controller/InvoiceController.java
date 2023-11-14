package com.ParkingLot.SpringProject.Controller;

import com.ParkingLot.SpringProject.Model.Invoice;
import com.ParkingLot.SpringProject.Service.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/api/v1/invoice/")
@RestController
public class InvoiceController {
    private InvoiceService service;
    @GetMapping("/api/v1/{ticket-id}")
    public Invoice getInvoice(@PathVariable("{ticket-id}") Long id){
        return service.getInvoice(id);
    }
}

package com.java.team.shippingservice.controller;

import com.java.team.shippingservice.entity.ShipmentDocument;
import com.java.team.shippingservice.service.ShipmentDocumentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shipment-document")
public class ShipmentDocumentController {

    private final ShipmentDocumentService service;

    public ShipmentDocumentController(ShipmentDocumentService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ShipmentDocument request, Model model) {
        String message = service.save(request).getData();
        model.addAttribute("message", message);
        return "shipment-document";
    }

    @PutMapping("/update/{id}")
    public String update(@ModelAttribute ShipmentDocument request, Model model) {
        String message = service.update(request).getData();
        model.addAttribute("message", message);
        return "shipment-document";
    }


    @GetMapping("/all")
    public String findAll(@PathVariable Long shipmentId, Model model) {
        List<ShipmentDocument> all = service.findByShipmentId(shipmentId);
        model.addAttribute("all", all);
        model.addAttribute("message", "All shipment addresses found");
        return "shipment-documents";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id, Model model) {
        service.delete(id);
        model.addAttribute("message", "Shipment address with id " + id + " deleted");
        return "shipment-document";
    }

}

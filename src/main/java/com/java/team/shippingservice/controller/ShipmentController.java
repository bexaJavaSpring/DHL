package com.java.team.shippingservice.controller;

import com.java.team.shippingservice.dto.ShipmentSaveRequest;
import com.java.team.shippingservice.service.ShipmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shipment")
public class ShipmentController {

    private final ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping("/create")
    public String createShipment(@ModelAttribute ShipmentSaveRequest request, Model model) {
        String message = shipmentService.create(request);
        model.addAttribute("message", message);
        return "shipment";
    }

    @PostMapping("/update/{id}")
    public String updateShipment(@ModelAttribute ShipmentSaveRequest request, @PathVariable Integer id, Model model) {
        String message = shipmentService.update(request, id);
        model.addAttribute("message", message);
        return "shipment";
    }
}

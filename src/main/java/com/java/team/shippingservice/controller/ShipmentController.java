package com.java.team.shippingservice.controller;

import com.java.team.shippingservice.dto.ShipmentDto;
import com.java.team.shippingservice.dto.ShipmentSaveRequest;
import com.java.team.shippingservice.entity.Shipment;
import com.java.team.shippingservice.service.ShipmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shipment")
public class ShipmentController {

    private final ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping("/create")
    public String createShipment(@ModelAttribute Shipment request, Model model) {
        String message = shipmentService.save(request).getData();
        model.addAttribute("message", message);
        return "shipment";
    }

    @PutMapping("/update/{id}")
    public String updateShipment(@ModelAttribute Shipment request, Model model) {
        String message = shipmentService.update(request).getData();
        model.addAttribute("message", message);
        return "shipment";
    }

    @GetMapping("/all")
    public String all(@PathVariable Long userId, Model model) {
        List<Shipment> all = shipmentService.getAll(userId);
        model.addAttribute("message", "All shipments");
        model.addAttribute("shipments", all);
        return "shipment";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable Long id, Model model) {
        Shipment dto = shipmentService.getOne(id);
        model.addAttribute("message", "Shipment with id " + id + " found");
        model.addAttribute("shipment", dto);
        return "shipment";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id, Model model) {
        shipmentService.delete(id);
        model.addAttribute("message", "Shipment with id " + id + " deleted successfully");
        return "shipment";
    }
}

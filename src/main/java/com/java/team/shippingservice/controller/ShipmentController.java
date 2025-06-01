package com.java.team.shippingservice.controller;

import com.java.team.shippingservice.dto.DataDto;
import com.java.team.shippingservice.dto.ShipmentDto;
import com.java.team.shippingservice.dto.ShipmentSaveRequest;
import com.java.team.shippingservice.service.ShipmentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    private final ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping("/create")
    public String createShipment(@ModelAttribute @Valid ShipmentSaveRequest request, Model model) {
        DataDto<String> data = shipmentService.create(request);
        model.addAttribute("data", data);
        model.addAttribute("message", "Successfully created");
        return "shipment";
    }

    @PutMapping("/update/{id}")
    public String updateShipment(@ModelAttribute ShipmentSaveRequest request, @PathVariable Integer id, Model model) {
        DataDto<String> data = shipmentService.update(request, id);
        model.addAttribute("message", "Successfully updated");
        model.addAttribute("data", data);
        return "shipment";
    }

    @GetMapping("/all")
    public String all(Model model) {
        List<ShipmentDto> all = shipmentService.getAll();
        model.addAttribute("message", "All shipments");
        model.addAttribute("shipments", all);
        return "shipment";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable Integer id, Model model) {
        ShipmentDto dto = shipmentService.getOne(id);
        model.addAttribute("message", "Shipment found");
        model.addAttribute("shipment", dto);
        return "shipment";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        DataDto<Boolean> data = shipmentService.delete(id);
        model.addAttribute("data", data);
        model.addAttribute("message", "Shipment deleted successfully");
        return "shipment";
    }
}

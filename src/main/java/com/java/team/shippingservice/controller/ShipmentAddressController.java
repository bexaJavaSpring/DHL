package com.java.team.shippingservice.controller;

import com.java.team.shippingservice.dto.ShipmentAddressDto;
import com.java.team.shippingservice.dto.ShipmentAddressSaveRequest;
import com.java.team.shippingservice.entity.ShipmentAddress;
import com.java.team.shippingservice.service.ShipmentAddressService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shipment-address")
public class ShipmentAddressController {

    private final ShipmentAddressService service;

    public ShipmentAddressController(ShipmentAddressService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public String createShipmentAddress(@ModelAttribute ShipmentAddressSaveRequest request, Model model) {
        String message = service.create(request);
        model.addAttribute("message", message);
        return "shipment-address";
    }

    @PutMapping("/update/{id}")
    public String updateShipmentAddress(@PathVariable Integer id, @ModelAttribute ShipmentAddressSaveRequest request, Model model) {
        String message = service.update(id, request);
        model.addAttribute("message", message);
        return "shipment-address";
    }

    @GetMapping("/{id}")
    public String showShipmentAddress(@PathVariable Integer id, Model model) {
        ShipmentAddressDto one = service.getOne(id);
        model.addAttribute("one", one);
        model.addAttribute("message", "Shipment address with id " + id + " found");
        return "shipment-address";
    }

    @GetMapping("/all")
    public String showAllShipmentAddresses(Model model) {
        List<ShipmentAddressDto> all = service.getAll();
        model.addAttribute("all", all);
        model.addAttribute("message", "All shipment addresses found");
        return "shipment-addresses";
    }

    @DeleteMapping("/{id}")
    public String deleteShipmentAddress(@PathVariable Integer id, Model model) {
        service.delete(id);
        model.addAttribute("message", "Shipment address with id " + id + " deleted");
        return "shipment-address";
    }

}

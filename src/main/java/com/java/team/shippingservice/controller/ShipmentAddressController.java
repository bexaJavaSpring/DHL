package com.java.team.shippingservice.controller;

import com.java.team.shippingservice.dto.DataDto;
import com.java.team.shippingservice.dto.ShipmentAddressDto;
import com.java.team.shippingservice.dto.ShipmentAddressSaveRequest;
import com.java.team.shippingservice.dto.ShipmentListRequestDto;
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
    public String createShipmentAddress(@ModelAttribute ShipmentListRequestDto request, Model model) {
        DataDto<List<Integer>> data = service.create(request);
        model.addAttribute("message", "Shipment Address created successfully");
        model.addAttribute("newIds", data);
        return "shipment-address";
    }

    @PutMapping("/update/{id}")
    public String updateShipmentAddress(@PathVariable Integer id, @ModelAttribute ShipmentAddressSaveRequest request, Model model) {
        DataDto<String> data = service.update(id, request);
        model.addAttribute("message", "Shipment Address updated successfully");
        model.addAttribute("updatedId", data);
        return "shipment-address";
    }

    @GetMapping("/{id}")
    public String showShipmentAddress(@PathVariable Integer id, Model model) {
        DataDto<ShipmentAddressDto> data = service.getOne(id);
        model.addAttribute("data", data);
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
        DataDto<Boolean> data = service.delete(id);
        model.addAttribute("data", data);
        model.addAttribute("message", "Shipment address with id " + id + " deleted");
        return "shipment-address";
    }

}

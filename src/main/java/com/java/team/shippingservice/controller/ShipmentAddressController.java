package com.java.team.shippingservice.controller;

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

    @PostMapping("/save")
    public String save(@ModelAttribute ShipmentAddress request, Model model) {
        String message = service.save(request).getData();
        model.addAttribute("message", message);
        return "shipment-address";
    }

    @PutMapping("/update/{id}")
    public String update(@ModelAttribute ShipmentAddress request, Model model) {
        String message = service.update(request).getData();
        model.addAttribute("message", message);
        return "shipment-address";
    }

    @GetMapping("/{id}")
    public String find(@PathVariable Integer id, Model model) {
        ShipmentAddress one = service.getOne(id);
        model.addAttribute("one", one);
        model.addAttribute("message", "Shipment address with id " + id + " found");
        return "shipment-address";
    }

    @GetMapping("/all")
    public String findAll(@PathVariable Integer userId, Model model) {
        List<ShipmentAddress> all = service.getAll(userId);
        model.addAttribute("all", all);
        model.addAttribute("message", "All shipment addresses found");
        return "shipment-addresses";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        service.delete(id);
        model.addAttribute("message", "Shipment address with id " + id + " deleted");
        return "shipment-address";
    }

}

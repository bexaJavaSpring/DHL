package com.java.team.shippingservice.controller;

import com.java.team.shippingservice.entity.ShipmentDocument;
import com.java.team.shippingservice.entity.ShipmentPackage;
import com.java.team.shippingservice.entity.enums.UnitType;
import com.java.team.shippingservice.service.ShipmentPackageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shipment-package")
public class ShipmentPackageController {

    private final ShipmentPackageService service;

    public ShipmentPackageController(ShipmentPackageService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ShipmentPackage request, Model model) {
        String message = service.save(request).getData();
        model.addAttribute("units", UnitType.values());
        model.addAttribute("message", message);
        return "shipment-package";
    }

    @PutMapping("/update/{id}")
    public String update(@ModelAttribute ShipmentPackage request, Model model) {
        String message = service.update(request).getData();
        model.addAttribute("units", UnitType.values());
        model.addAttribute("message", message);
        return "shipment-package";
    }


    @GetMapping("/all")
    public String findAll(@PathVariable Long shipmentId, Model model) {
        List<ShipmentPackage> all = service.findByShipmentId(shipmentId);
        model.addAttribute("all", all);
        model.addAttribute("message", "All shipment addresses found");
        return "shipment-packages";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id, Model model) {
        service.delete(id);
        model.addAttribute("message", "Shipment address with id " + id + " deleted");
        return "shipment-package";
    }

}

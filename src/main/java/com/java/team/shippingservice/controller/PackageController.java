package com.java.team.shippingservice.controller;

import com.java.team.shippingservice.service.PackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/package")
@RequiredArgsConstructor
public class PackageController {

    private final PackageService service;

    @GetMapping("/all")
    public String all(Model model) {
        service.findAll();
        model.addAttribute("message");
        return "shipment";
    }
}

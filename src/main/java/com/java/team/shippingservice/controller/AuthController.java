package com.java.team.shippingservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.team.shippingservice.dto.*;
import com.java.team.shippingservice.service.AuthService;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest request, Model model) {
        DataDto<LoginResponse> data = service.login(request);
        model.addAttribute("data", data);
        return "shipmentActions";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute RegisterRequest request, Model model) {
        DataDto<String> data = service.register(request);
        model.addAttribute("data", data);
        if(data.isSuccess()) {
            return "index";
        }
        return "register";
    }

    @GetMapping("/me")
    @PreAuthorize("isAuthenticated()")
    public String me(Model model) {
        DataDto<UserInfo> data = service.getUserInfo();
        model.addAttribute("me", data);
        return "index";
    }

    @GetMapping(value = "/logout")
    @PreAuthorize(value = "isAuthenticated()")
    public String logout(Model model) {
        DataDto<Boolean> data = service.logout();
        model.addAttribute("message", data);
        return "index";
    }

    @PostMapping(value = "/next")
    public String next(@ModelAttribute AddressDto dto, Model model) {
        model.addAttribute("data", dto);
        return "next";
    }
}

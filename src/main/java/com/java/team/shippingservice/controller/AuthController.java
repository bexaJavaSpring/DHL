package com.java.team.shippingservice.controller;

import com.java.team.shippingservice.service.AuthService;
import com.java.team.shippingservice.dto.LoginRequest;
import com.java.team.shippingservice.dto.RegisterRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest request, Model model) {
        String message = service.login(request);
        model.addAttribute("message", message);
        return "login";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute RegisterRequest request, Model model){
        String message = service.register(request);
        model.addAttribute("message", message);
        return "login";
    }
}

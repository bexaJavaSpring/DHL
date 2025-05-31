package com.java.team.shippingservice.controller;

import com.java.team.shippingservice.dto.*;
import com.java.team.shippingservice.service.AuthService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("message", "Successfully logged in");
        model.addAttribute("data", data);
        return "index";
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
        return "login";
    }
}

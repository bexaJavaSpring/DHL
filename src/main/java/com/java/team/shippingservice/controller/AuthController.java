package com.java.team.shippingservice.controller;

import com.java.team.shippingservice.dto.*;
import com.java.team.shippingservice.service.AuthService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request, Model model) {
        DataDto<LoginResponse> data = service.login(request);
        model.addAttribute("data", data);
        return "login";
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request, Model model) {
        DataDto<String> data = service.register(request);
        model.addAttribute("data", data);
        return "index";
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

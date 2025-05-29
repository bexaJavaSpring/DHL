package com.java.team.shippingservice.controller;

import com.java.team.shippingservice.dto.*;
import com.java.team.shippingservice.service.AuthService;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public String login(@RequestBody LoginRequest request, Model model) {
        DataDto<LoginResponse> data = service.login(request);
        model.addAttribute("data", data);
        return "login";
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request, Model model) {
        DataDto<String> data = service.register(request);
        model.addAttribute("message", data);
        return "register";
    }

    @GetMapping("/me")
    public String me(@RequestParam Integer userId, Model model) {
        UserInfo userInfo = service.getUserInfo(userId);
        model.addAttribute("me", userInfo);
        return "dashboard";
    }
    @GetMapping("/logout")
    public String logout(Model model) {
        SecurityContextHolder.getContext().setAuthentication(null);
        model.addAttribute("message", "You have been logged out");
        return "home";
    }
}

package com.java.team.shippingservice.controller;

import com.java.team.shippingservice.dto.DataDto;
import com.java.team.shippingservice.dto.UserInfo;
import com.java.team.shippingservice.service.AuthService;
import com.java.team.shippingservice.dto.LoginRequest;
import com.java.team.shippingservice.dto.RegisterRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        DataDto<String> data = service.login(request);
        model.addAttribute("message", data);
        return "login";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute RegisterRequest request, Model model) {
        DataDto<String> data = service.register(request);
        model.addAttribute("message", data);
        return "register";
    }

    @GetMapping("/me")
    public String me(Model model) {
        UserInfo userInfo = service.getUserInfo();
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

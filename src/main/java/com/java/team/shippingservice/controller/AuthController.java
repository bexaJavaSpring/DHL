package com.java.team.shippingservice.controller;

import com.java.team.shippingservice.dto.*;
import com.java.team.shippingservice.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<DataDto<LoginResponse>> login(@ModelAttribute LoginRequest request) {
        return ResponseEntity.ok(service.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<DataDto<Integer>> register(@ModelAttribute RegisterRequest request) {
       return ResponseEntity.ok(service.register(request));
    }

    @GetMapping("/me")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<DataDto<UserInfo>> me() {
        return ResponseEntity.ok(service.getUserInfo());
    }

    @GetMapping(value = "/logout")
    @PreAuthorize(value = "isAuthenticated()")
    public ResponseEntity<DataDto<Boolean>> logout() {
        return ResponseEntity.ok(service.logout());
    }
}

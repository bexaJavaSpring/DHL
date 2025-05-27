package com.java.team.shippingservice.service;

import com.java.team.shippingservice.dto.LoginRequest;
import com.java.team.shippingservice.dto.RegisterRequest;
import com.java.team.shippingservice.entity.User;
import com.java.team.shippingservice.repository.RoleRepository;
import com.java.team.shippingservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public String login(LoginRequest request) {
        String message = "";
        User user = userRepository.findByEmail(request.getEmail());
        if (user == null) {
            message = "email doesn't exist";
            return message;
        }
        if (!user.getPassword().equals(request.getPassword())) {
            message = "password doesn't match";
            return message;
        }
        return "Successfully logged in";
    }

    public String register(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        user.setCompany(request.getCompany());
        user.setPhoneNumber(request.getPhone());
        user.setRoles(Set.of(roleRepository.findByCode("USER")));
        userRepository.save(user);
        return "Successfully registered";
    }
}

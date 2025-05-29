package com.java.team.shippingservice.service;

import com.java.team.shippingservice.config.CustomUserDetails;
import com.java.team.shippingservice.dto.*;
import com.java.team.shippingservice.entity.User;
import com.java.team.shippingservice.repository.RoleRepository;
import com.java.team.shippingservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailService customUserDetailService;
    private final PasswordEncoder encoder;

    public DataDto<LoginResponse> login(LoginRequest request) {
        String message = "";
        CustomUserDetails userDetails = customUserDetailService.loadUserByUsername(request.getEmail());
        if (!encoder.matches(request.getPassword(), userDetails.getPassword())) {
            message = "password doesn't match";
            return new DataDto<>(LoginResponse.builder().message(message).build(), false);
        }
        return new DataDto<>(LoginResponse.builder()
                .message(message)
                .userId(userDetails.getId())
                .build(), true);
    }

    public DataDto<String> register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            return new DataDto<>("Email is already exist", false);
        }
        if (!request.getPassword().equalsIgnoreCase(request.getConfirmPassword())) {
            return new DataDto<>("Passwords do not match", false);
        }
        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setCompany(request.getCompany());
        user.setPhoneNumber(request.getPhone());
        user.setRole(roleRepository.findByCode("USER"));
        userRepository.save(user);
        return new DataDto<>("Successfully registered", true);
    }

    public UserInfo getUserInfo(Integer userId) {
        Optional<User> byId = userRepository.findById(userId);
        User user = null;
        if (byId.isPresent()) {
            user = byId.get();
        }
        return UserInfo.builder()
                .userId(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .company(user.getCompany())
                .phone(user.getPhoneNumber())
                .role(user.getRole())
                .build();
    }
}

package com.java.team.shippingservice.service;

import com.java.team.shippingservice.config.CustomUserDetails;
import com.java.team.shippingservice.dto.DataDto;
import com.java.team.shippingservice.dto.LoginRequest;
import com.java.team.shippingservice.dto.RegisterRequest;
import com.java.team.shippingservice.dto.UserInfo;
import com.java.team.shippingservice.entity.User;
import com.java.team.shippingservice.repository.RoleRepository;
import com.java.team.shippingservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailService customUserDetailService;
    private final PasswordEncoder encoder;

    public DataDto<String> login(LoginRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String message = "";
        User user = userRepository.findByEmail(request.getEmail());
        if (user == null) {
            message = "email doesn't exist";
            return new DataDto<>(message, false);
        }
        CustomUserDetails userDetails = customUserDetailService.loadUserByUsername(user.getEmail());
        if (authentication != null && userDetails != null) {
            if (!encoder.matches(authentication.getName(), userDetails.getPassword())) {
                message = "password doesn't match";
                return new DataDto<>(message, false);
            }
        }
        message = "Successfully logged in";
        return new DataDto<>(message, true);
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
        CustomUserDetails userDetails = customUserDetailService.loadUserByUsername(user.getEmail());
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new DataDto<>("Successfully registered", true);
    }

    public UserInfo getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        return UserInfo.builder()
                .userId(userDetails.getId())
                .firstName(userDetails.getFirstName())
                .lastName(userDetails.getLastName())
                .email(userDetails.getEmail())
                .company(userDetails.getCompany())
                .phone(userDetails.getPhone())
                .role(userDetails.getRole())
                .build();
    }
}

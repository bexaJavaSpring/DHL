package com.java.team.shippingservice.service;

import com.java.team.shippingservice.config.CustomAuthenticationProvider;
import com.java.team.shippingservice.config.CustomUserDetails;
import com.java.team.shippingservice.config.UserSession;
import com.java.team.shippingservice.dto.*;
import com.java.team.shippingservice.entity.Status;
import com.java.team.shippingservice.entity.TokenUser;
import com.java.team.shippingservice.entity.User;
import com.java.team.shippingservice.exception.CustomNotFoundException;
import com.java.team.shippingservice.repository.RoleRepository;
import com.java.team.shippingservice.repository.TokenUserRepository;
import com.java.team.shippingservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomAuthenticationProvider authenticationProvider;
    private final TokenUserRepository tokenUserRepository;
    private final JwtTokenService jwtTokenService;

    public DataDto<LoginResponse> login(LoginRequest request) {
        Authentication authenticate = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(), request.getPassword()
        ));
        CustomUserDetails userDetails = (CustomUserDetails) authenticate.getPrincipal();
        User user = userRepository.getReferenceById(userDetails.getId());
        if (user == null) {
            throw new CustomNotFoundException(userDetails.getId().toString(), "User not found");
        }
        Optional<TokenUser> optionalTokenUser = tokenUserRepository.findByUserId(user.getId());
        if (optionalTokenUser.isPresent()) {
            TokenUser token = optionalTokenUser.get();
            String accessToken = jwtTokenService.generateToken(userDetails.getUsername());
            String refreshToken = jwtTokenService.generateToken(userDetails.getUsername());
            token.setAccessToken(accessToken);
            token.setRefreshToken(refreshToken);
            token.setStatus(Status.ACTIVE);
            tokenUserRepository.save(token);
            return new DataDto<>(LoginResponse.builder()
                    .access_token(token.getAccessToken())
                    .refresh_token(token.getRefreshToken())
                    .build(), true);
        }
        String accessToken = jwtTokenService.generateToken(userDetails.getUsername());
        String refreshToken = jwtTokenService.generateToken(userDetails.getUsername());
        tokenUserRepository.save(TokenUser.builder()
                .user(user)
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .status(Status.ACTIVE)
                .build());
        return new DataDto<>(LoginResponse.builder()
                .access_token(accessToken)
                .refresh_token(refreshToken)
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

    public DataDto<UserInfo> getUserInfo() {
        Optional<User> optionalUser = userRepository.findById(UserSession.getCurrentUser().getId());
        if (optionalUser.isEmpty())
            throw new CustomNotFoundException("User not found");
        User user = optionalUser.get();
        return new DataDto<>(UserInfo.builder()
                .userId(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .company(user.getCompany())
                .phone(user.getPhoneNumber())
                .role(user.getRole())
                .build());
    }

    public DataDto<Boolean> logout() {
        User user = userRepository.getReferenceById(UserSession.getCurrentUser().getId());
        if (user == null) {
            throw new CustomNotFoundException("User not found");
        }
        Optional<TokenUser> sessionOptional = tokenUserRepository.findByUserId(user.getId());
        if (sessionOptional.isPresent()) {
            TokenUser session = sessionOptional.get();
            session.setStatus(Status.INACTIVE);
            tokenUserRepository.save(session);
        }
        return new DataDto<>(true);
    }
}

package com.java.team.shippingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private String nameTitle;
    private String email;
    private String company;
    private String phone;
    private String phoneType;
}

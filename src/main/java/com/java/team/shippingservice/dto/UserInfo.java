package com.java.team.shippingservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserInfo {
    private Integer userId;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String company;
    private String role;
}

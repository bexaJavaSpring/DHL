package com.java.team.shippingservice.dto;

import com.java.team.shippingservice.entity.Role;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserInfo {
    private Long userId;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String company;
    private Role role;
}

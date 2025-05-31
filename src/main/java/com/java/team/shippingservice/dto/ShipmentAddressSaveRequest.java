package com.java.team.shippingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Service
public class ShipmentAddressSaveRequest {
    private String holderName;
    private String company;
    private String address;
    private String postalCode;
    private String city;
    private String state;
    private String email;
    private String phone;
    private String type;
}

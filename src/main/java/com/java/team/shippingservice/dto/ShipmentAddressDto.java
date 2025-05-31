package com.java.team.shippingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ShipmentAddressDto {
    private Integer id;
    private String holderName;
    private String city;
    private String state;
    private String company;
    private String email;
    private String type;
    private String postalCode;
    private String phone;
}

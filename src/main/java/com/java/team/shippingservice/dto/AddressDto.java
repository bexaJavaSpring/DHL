package com.java.team.shippingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressDto {
    private String countryA;
    private String countryB;
    private String addressA;
    private String addressB;
}

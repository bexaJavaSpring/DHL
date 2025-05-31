package com.java.team.shippingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShipmentDto {
    private Integer id;
    private String  nickName;
    private String  description;
    private String shipmentType;
    private Double shipmentValue;
}

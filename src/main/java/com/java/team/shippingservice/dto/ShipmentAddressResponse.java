package com.java.team.shippingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShipmentAddressResponse {
    private Integer fromId;
    private Integer toId;
}

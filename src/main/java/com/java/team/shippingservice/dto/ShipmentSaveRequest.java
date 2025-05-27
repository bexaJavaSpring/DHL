package com.java.team.shippingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShipmentSaveRequest {
    private String name;
    private Integer fromId;
    private Integer toId;
    private String  nickName;
    private String  description;
    private String shipmentType;
    private String reference;
    private Double shipmentValue;
}

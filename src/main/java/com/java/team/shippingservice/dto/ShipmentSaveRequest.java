package com.java.team.shippingservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShipmentSaveRequest {
    @NotNull(message = "fromId must not be null")
    private Integer fromId;
    @NotNull(message = "toId must not be null")
    private Integer toId;
    private String  nickName;
    private String  description;
    private String shipmentType;
    private Double shipmentValue;
}

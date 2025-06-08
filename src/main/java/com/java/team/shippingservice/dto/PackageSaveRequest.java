package com.java.team.shippingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PackageSaveRequest {
    private String packageType;
    private Integer shipmentId;
    private Double quantity;
    private String status;
    private Double weight;
    private Double height;
    private Double width;
    private Double length;
}

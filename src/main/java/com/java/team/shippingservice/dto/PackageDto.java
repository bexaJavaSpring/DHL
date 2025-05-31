package com.java.team.shippingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PackageDto {
    private Integer id;
    private String type;
    private Integer shipmentId;
    private Double totalShipmentWeight;
    private Long numberOfPackages;
    private Double quantity;
    private Double length;
    private Double weight;
    private Double height;
    private String status;
}

package com.java.team.shippingservice.entity;

import com.java.team.shippingservice.entity.enums.PackageStatus;
import com.java.team.shippingservice.entity.enums.PackageType;
import com.java.team.shippingservice.entity.enums.UnitType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "shipment_packages")
public class ShipmentPackage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PackageType type;

    @Column(name = "shipment_id")
    private Long shipmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipment_id",  updatable = false, insertable = false)
    private Shipment shipment;

    @Column(name = "total_shipment_weight")
    private Double totalShipmentWeight;

    @Column(name = "number_of_packages")
    private Long numberOfPackages;

    private Double quantity;

    private Double length;

    private Double weight;

    private Double width;

    private Double height;

    @Enumerated(EnumType.STRING)
    private UnitType unit;

    @Enumerated(EnumType.STRING)
    private PackageStatus status;
}

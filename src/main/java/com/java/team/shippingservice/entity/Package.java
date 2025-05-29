package com.java.team.shippingservice.entity;

import com.java.team.shippingservice.entity.enums.PackageStatus;
import com.java.team.shippingservice.entity.enums.PackageType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "packages")
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private PackageType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipment_id", nullable = false, referencedColumnName = "id")
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
    private PackageStatus status;
}

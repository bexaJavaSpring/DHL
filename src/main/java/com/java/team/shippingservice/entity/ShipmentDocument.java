package com.java.team.shippingservice.entity;

import com.java.team.shippingservice.entity.enums.PackageStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "shipment_documents")
public class ShipmentDocument implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shipment_id")
    private Long shipmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipment_id",  updatable = false, insertable = false)
    private Shipment shipment;

    @Enumerated(EnumType.STRING)
    private PackageStatus status;

    @Column(name = "description")
    private String description;

    @Column(name = "reference")
    private String reference;
}

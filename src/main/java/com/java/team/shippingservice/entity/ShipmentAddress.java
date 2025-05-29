package com.java.team.shippingservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "shipment_address")
public class ShipmentAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String company;

    private String address;

    @Column(name = "postal_code")
    private String postalCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shipment_id", referencedColumnName = "id")
    private Shipment shipment;

    private String city;

    private String state;

    private String phone;
}

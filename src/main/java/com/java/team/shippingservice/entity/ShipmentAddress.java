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

    private String country;

    private String address;

    private String address2;

    private String address3;

    @Column(name = "postal_code")
    private String postalCode;

    private String city;

    private String state;

    @Column(name = "is_residential")
    private boolean isResidential;

    private String phone;

    @Column(name = "is_sms_enabled")
    private boolean isSmsEnabled;

    @Column(name = "tax_id")
    private String taxId;

    @Column(name = "eori_number")
    private String eoriNumber;
}

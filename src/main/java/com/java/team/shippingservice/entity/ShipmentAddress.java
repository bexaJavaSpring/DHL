package com.java.team.shippingservice.entity;

import com.java.team.shippingservice.entity.enums.AddressType;
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

    @Column(name = "holder_name")
    private String holderName;

    private String company;

    private String email;

    private String address;

    @Column(name = "postal_code")
    private String postalCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipment_id", referencedColumnName = "id")
    private Shipment shipment;

    private String city;

    private String state;

    private String phone;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;
}

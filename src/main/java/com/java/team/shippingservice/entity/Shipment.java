package com.java.team.shippingservice.entity;

import com.java.team.shippingservice.entity.enums.ShipmentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "shipments")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "nick_name")
    private String nickName;

    @Enumerated(EnumType.STRING)
    private ShipmentType shipmentType;

    private String description;

    @Column(name = "shipment_value")
    private Double shipmentValue;
}

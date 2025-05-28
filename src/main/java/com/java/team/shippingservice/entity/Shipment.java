package com.java.team.shippingservice.entity;

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

    @OneToOne
    @JoinColumn(name = "from",referencedColumnName = "id")
    private ShipmentAddress from;

    @OneToOne
    @JoinColumn(name = "to", referencedColumnName = "id")
    private ShipmentAddress to;

    @Column(name = "nick_name")
    private String nickName;

    @Enumerated(EnumType.STRING)
    private ShipmentType shipmentType;

    private String description;

    @Column(name = "shipment_value")
    private Double shipmentValue;
}

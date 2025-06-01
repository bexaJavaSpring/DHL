package com.java.team.shippingservice.entity;

import com.java.team.shippingservice.entity.enums.ShipmentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "shipments")
public class Shipment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "nick_name")
    private String nickName;

    @Enumerated(EnumType.STRING)
    private ShipmentType shipmentType;

    private String description;

    @Column(name = "shipment_value")
    private Double shipmentValue;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private User user;

    @Column(name = "registered_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.s")
    private Date registeredAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @PrePersist
    public void onCreate(){
        this.registeredAt = new Date();
        this.updatedAt = new Date();
    }

    @PreUpdate
    public void onUpdate(){
        this.updatedAt = new Date();
    }
}

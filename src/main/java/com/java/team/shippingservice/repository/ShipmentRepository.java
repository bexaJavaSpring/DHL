package com.java.team.shippingservice.repository;

import com.java.team.shippingservice.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {
}

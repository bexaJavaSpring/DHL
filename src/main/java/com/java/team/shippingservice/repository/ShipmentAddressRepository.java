package com.java.team.shippingservice.repository;

import com.java.team.shippingservice.entity.ShipmentAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentAddressRepository extends JpaRepository<ShipmentAddress, Integer> {
}

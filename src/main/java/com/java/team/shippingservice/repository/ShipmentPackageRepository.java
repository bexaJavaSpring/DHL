package com.java.team.shippingservice.repository;

import com.java.team.shippingservice.entity.ShipmentPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentPackageRepository extends JpaRepository<ShipmentPackage, Long> {

    List<ShipmentPackage> findByShipmentId(Long shipmentId);
}

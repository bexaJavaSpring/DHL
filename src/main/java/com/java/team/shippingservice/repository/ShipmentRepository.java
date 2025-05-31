package com.java.team.shippingservice.repository;

import com.java.team.shippingservice.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {
    @Query("select t from Shipment t where t.id=?1")
    Shipment findByIdCustom(Integer id);
}

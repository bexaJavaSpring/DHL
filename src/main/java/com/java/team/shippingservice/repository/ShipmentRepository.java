package com.java.team.shippingservice.repository;

import com.java.team.shippingservice.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

    @Query(value = "select s from Shipment s where s.userId=:userId order by s.registeredAt desc")
    List<Shipment> getAllByUserId(@Param("userId") Long userId);
}

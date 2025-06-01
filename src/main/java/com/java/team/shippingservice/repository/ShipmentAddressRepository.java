package com.java.team.shippingservice.repository;

import com.java.team.shippingservice.entity.Shipment;
import com.java.team.shippingservice.entity.ShipmentAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentAddressRepository extends JpaRepository<ShipmentAddress, Integer> {

    @Query(value = "select s from ShipmentAddress s where s.shipment.userId=:userId")
    List<ShipmentAddress> findByUserId(@Param("userId") int userId);
}

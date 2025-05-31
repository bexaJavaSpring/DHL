package com.java.team.shippingservice.repository;

import com.java.team.shippingservice.entity.ShipmentAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShipmentAddressRepository extends JpaRepository<ShipmentAddress, Integer> {
    @Query("select t from ShipmentAddress t where t.id=?1")
    ShipmentAddress findByIdAndDeleted(Integer id);
}

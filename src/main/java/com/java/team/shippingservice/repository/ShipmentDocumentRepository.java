package com.java.team.shippingservice.repository;

import com.java.team.shippingservice.entity.ShipmentDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentDocumentRepository extends JpaRepository<ShipmentDocument, Long> {

    List<ShipmentDocument> findByShipmentId(Long shipmentId);
}

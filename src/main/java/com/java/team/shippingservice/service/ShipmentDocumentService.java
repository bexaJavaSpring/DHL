package com.java.team.shippingservice.service;

import com.java.team.shippingservice.dto.DataDto;
import com.java.team.shippingservice.entity.ShipmentDocument;
import com.java.team.shippingservice.repository.ShipmentDocumentRepository;
import com.java.team.shippingservice.util.NumberUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentDocumentService {

    private final ShipmentDocumentRepository shipmentDocumentRepository;

    public ShipmentDocumentService(ShipmentDocumentRepository shipmentDocumentRepository) {
        this.shipmentDocumentRepository = shipmentDocumentRepository;
    }

    public DataDto<String> save(ShipmentDocument shipmentDocument) {
        try {
            shipmentDocumentRepository.save(shipmentDocument);
            return new DataDto<>("Successfully", true);
        } catch (Exception e) {
            return new DataDto<>("Error happened", false);
        }
    }

    public List<ShipmentDocument> findByShipmentId(Long shipmentId) {
        return shipmentDocumentRepository.findByShipmentId(shipmentId);
    }

    public DataDto<String> update(ShipmentDocument shipmentDocument) {
        try {
            if (!NumberUtils.existParam(shipmentDocument.getId())) {
                return new DataDto<>("Id does not exist", false);
            }
            shipmentDocumentRepository.save(shipmentDocument);
            return new DataDto<>("Successfully updated", true);
        } catch (Exception e) {
            return new DataDto<>("Error happened", false);
        }
    }

    public void delete(Long id) {
        if (!NumberUtils.existParam(id)) {
            return;
        }

        shipmentDocumentRepository.deleteById(id);
    }

}

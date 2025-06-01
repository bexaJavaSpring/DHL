package com.java.team.shippingservice.service;

import com.java.team.shippingservice.dto.DataDto;
import com.java.team.shippingservice.entity.ShipmentPackage;
import com.java.team.shippingservice.repository.ShipmentPackageRepository;
import com.java.team.shippingservice.util.NumberUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentPackageService {

    private final ShipmentPackageRepository shipmentPackageRepository;

    public ShipmentPackageService(ShipmentPackageRepository shipmentPackageRepository) {
        this.shipmentPackageRepository = shipmentPackageRepository;
    }

    public DataDto<String> save(ShipmentPackage shipmentPackage) {
        try {
            shipmentPackage = shipmentPackageRepository.save(shipmentPackage);
            return new DataDto<>("Successfully", true);
        } catch (Exception e) {
            return new DataDto<>("Error happened", false);
        }
    }

    public List<ShipmentPackage> findByShipmentId(Long shipmentId) {
        return shipmentPackageRepository.findByShipmentId(shipmentId);
    }

    public DataDto<String> update(ShipmentPackage shipmentPackage) {
        try {
            if (!NumberUtils.existParam(shipmentPackage.getId())) {
                return new DataDto<>("Id doesnt exist", false);
            }
            shipmentPackageRepository.save(shipmentPackage);
            return new DataDto<>("Successfully", true);
        } catch (Exception e) {
            return new DataDto<>("Error happened", false);
        }
    }

    public void delete(Long id) {
        if(!NumberUtils.existParam(id)) {
            return;
        }

        shipmentPackageRepository.deleteById(id);
    }


}

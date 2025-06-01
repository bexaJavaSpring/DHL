package com.java.team.shippingservice.service;

import com.java.team.shippingservice.dto.DataDto;
import com.java.team.shippingservice.dto.ShipmentDto;
import com.java.team.shippingservice.entity.Shipment;
import com.java.team.shippingservice.repository.ShipmentRepository;
import com.java.team.shippingservice.util.NumberUtils;
import org.springframework.stereotype.Service;

import java.util.IllegalFormatCodePointException;
import java.util.List;

@Service
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentService(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public DataDto<String> save(Shipment request) {
        try {
            shipmentRepository.save(request);
        } catch (Exception e) {
            return new DataDto<>("Error happened", false);
        }
        return new DataDto<>("Successfully", true);
    }

    public DataDto<String> update(Shipment request) {
        try {
            if (!NumberUtils.existParam(request.getId()))
                return new DataDto<>("Id doesnt exist", false);
            shipmentRepository.save(request);
        } catch (Exception e) {
            return new DataDto<>("Error happened", false);
        }
        return new DataDto<>("Successfully", true);
    }

    public List<Shipment> getAll(Long userId) {
        if (!NumberUtils.existParam(userId))
            return null;

        return shipmentRepository.getAllByUserId(userId);
    }

    public Shipment getOne(Long id) {
        if (!NumberUtils.existParam(id))
            return null;
        return shipmentRepository.getReferenceById(id);
    }

    public void delete(Long id) {
        if (!NumberUtils.existParam(id))
            return;
        shipmentRepository.deleteById(id);
    }
}

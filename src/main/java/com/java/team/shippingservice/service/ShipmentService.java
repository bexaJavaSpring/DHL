package com.java.team.shippingservice.service;

import com.java.team.shippingservice.dto.ShipmentDto;
import com.java.team.shippingservice.dto.ShipmentSaveRequest;
import com.java.team.shippingservice.entity.Shipment;
import com.java.team.shippingservice.entity.ShipmentAddress;
import com.java.team.shippingservice.entity.enums.ShipmentType;
import com.java.team.shippingservice.mapper.ShipmentMapper;
import com.java.team.shippingservice.repository.ShipmentAddressRepository;
import com.java.team.shippingservice.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentService {

    private final ShipmentAddressRepository shipmentAddressRepository;
    private final ShipmentRepository shipmentRepository;
    private final ShipmentMapper mapper;

    public ShipmentService(ShipmentAddressRepository shipmentAddressRepository, ShipmentRepository shipmentRepository, ShipmentMapper mapper) {
        this.shipmentAddressRepository = shipmentAddressRepository;
        this.shipmentRepository = shipmentRepository;
        this.mapper = mapper;
    }

    public String create(ShipmentSaveRequest request) {
        Shipment shipment = new Shipment();
        shipment.setShipmentType(ShipmentType.valueOf(request.getShipmentType()));
        shipment.setShipmentValue(request.getShipmentValue());
        shipment.setDescription(request.getDescription());
        shipment.setNickName(request.getNickName());
        List<ShipmentAddress> allShipmentAddress = shipmentAddressRepository.findAllById(List.of(request.getFromId(), request.getToId()));
        allShipmentAddress.forEach(shipmentAddress -> {
            shipmentAddress.setShipment(shipment);
        });
        shipmentAddressRepository.saveAll(allShipmentAddress);

    }

    public String update(ShipmentSaveRequest request, Integer id) {
        return null;
    }

    public List<ShipmentDto> getAll() {
        shipmentRepository.findAll().stream().map(mapper::toDto).toList();
    }

    public ShipmentDto getOne(Integer id) {
        return null;
    }

    public void delete(Integer id) {

    }
}

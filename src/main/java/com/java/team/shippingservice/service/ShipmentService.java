package com.java.team.shippingservice.service;

import com.java.team.shippingservice.dto.DataDto;
import com.java.team.shippingservice.dto.ShipmentDto;
import com.java.team.shippingservice.dto.ShipmentSaveRequest;
import com.java.team.shippingservice.entity.Shipment;
import com.java.team.shippingservice.entity.ShipmentAddress;
import com.java.team.shippingservice.entity.enums.ShipmentType;
import com.java.team.shippingservice.exception.CustomNotFoundException;
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

    public DataDto<String> create(ShipmentSaveRequest request) {
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
        Shipment save = shipmentRepository.save(shipment);
        return new DataDto<>(save.getId().toString());
    }

    public DataDto<String> update(ShipmentSaveRequest request, Integer id) {
        Shipment shipment = shipmentRepository.findByIdCustom(id);
        if (shipment == null) {
            throw new CustomNotFoundException("Shipment not found");
        }
        shipment.setShipmentType(ShipmentType.valueOf(request.getShipmentType()));
        shipment.setShipmentValue(request.getShipmentValue());
        shipment.setDescription(request.getDescription());
        shipment.setNickName(request.getNickName());
        shipmentRepository.save(shipment);
        return new DataDto<>(shipment.getId().toString());
    }

    public List<ShipmentDto> getAll() {
        return shipmentRepository.findAll().stream().map(mapper::toDto).toList();
    }

    public ShipmentDto getOne(Integer id) {
        Shipment shipment = shipmentRepository.findByIdCustom(id);
        if (shipment == null) {
            throw new CustomNotFoundException("Shipment not found");
        }
        return mapper.toDto(shipment);
    }

    public DataDto<Boolean> delete(Integer id) {
        Shipment shipment = shipmentRepository.findByIdCustom(id);
        if (shipment == null) {
            throw new CustomNotFoundException("Shipment not found");
        }
        shipmentRepository.delete(shipment);
        return new DataDto<>(true);
    }
}

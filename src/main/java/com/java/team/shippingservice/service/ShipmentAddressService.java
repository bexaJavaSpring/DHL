package com.java.team.shippingservice.service;

import com.java.team.shippingservice.dto.ShipmentAddressDto;
import com.java.team.shippingservice.dto.ShipmentAddressSaveRequest;
import com.java.team.shippingservice.repository.ShipmentAddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentAddressService {

    private final ShipmentAddressRepository shipmentAddressRepository;

    public ShipmentAddressService(ShipmentAddressRepository shipmentAddressRepository) {
        this.shipmentAddressRepository = shipmentAddressRepository;
    }

    public String create(ShipmentAddressSaveRequest request) {
        return null;
    }

    public String update(Integer id, ShipmentAddressSaveRequest request) {
        return null;
    }

    public ShipmentAddressDto getOne(Integer id) {
        return null;
    }

    public List<ShipmentAddressDto> getAll() {
        return null;
    }

    public void delete(Integer id) {

    }
}

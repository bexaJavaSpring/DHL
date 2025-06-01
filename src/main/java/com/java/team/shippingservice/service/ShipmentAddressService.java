package com.java.team.shippingservice.service;

import com.java.team.shippingservice.dto.DataDto;
import com.java.team.shippingservice.dto.ShipmentAddressDto;
import com.java.team.shippingservice.dto.ShipmentAddressSaveRequest;
import com.java.team.shippingservice.entity.ShipmentAddress;
import com.java.team.shippingservice.repository.ShipmentAddressRepository;
import com.java.team.shippingservice.util.NumberUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentAddressService {

    private final ShipmentAddressRepository shipmentAddressRepository;

    public ShipmentAddressService(ShipmentAddressRepository shipmentAddressRepository) {
        this.shipmentAddressRepository = shipmentAddressRepository;
    }

    public DataDto<String> save(ShipmentAddress request) {
        try {
            shipmentAddressRepository.save(request);
        } catch (Exception e) {
            return new DataDto<>("Error happened!", false);
        }
        return new DataDto<>("Successfully", true);
    }

    public DataDto<String> update(ShipmentAddress request) {
        try {
            if (!NumberUtils.existParam(request.getId()))
                return new DataDto<>("Id doesnt exist!", false);

            shipmentAddressRepository.save(request);
        } catch (Exception e) {
            return new DataDto<>("Error happened!", false);
        }
        return new DataDto<>("Successfully", true);
    }

    public ShipmentAddress getOne(Integer id) {
        if (!NumberUtils.existParam(id))
            return null;
        return shipmentAddressRepository.getReferenceById(id);
    }

    public List<ShipmentAddress> getAll(Integer userId) {
        if (!NumberUtils.existParam(userId))
            return null;
       return shipmentAddressRepository.findByUserId(userId);
    }

    public DataDto<String> delete(Integer id) {
        if (!NumberUtils.existParam(id))
            return new DataDto<>("Id doesnt exist!", false);
        shipmentAddressRepository.deleteById(id);
        return new DataDto<>("Successfully", true);

    }
}

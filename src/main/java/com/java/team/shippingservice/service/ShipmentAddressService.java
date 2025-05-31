package com.java.team.shippingservice.service;

import com.java.team.shippingservice.mapper.ShipmentAddressMapper;
import com.java.team.shippingservice.dto.DataDto;
import com.java.team.shippingservice.dto.ShipmentAddressDto;
import com.java.team.shippingservice.dto.ShipmentAddressSaveRequest;
import com.java.team.shippingservice.dto.ShipmentListRequestDto;
import com.java.team.shippingservice.entity.ShipmentAddress;
import com.java.team.shippingservice.entity.enums.AddressType;
import com.java.team.shippingservice.repository.ShipmentAddressRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShipmentAddressService {

    private final ShipmentAddressRepository shipmentAddressRepository;
    private final ShipmentAddressMapper mapper;

    public ShipmentAddressService(ShipmentAddressRepository shipmentAddressRepository, ShipmentAddressMapper mapper) {
        this.shipmentAddressRepository = shipmentAddressRepository;
        this.mapper = mapper;
    }

    public DataDto<List<Integer>> create(ShipmentListRequestDto dto) {
        List<Integer> list = new ArrayList<>();
        if (dto.getList().isEmpty()) {
            for (ShipmentAddressSaveRequest request : dto.getList()) {
                ShipmentAddress shipmentAddress = new ShipmentAddress();
                shipmentAddress.setHolderName(request.getHolderName());
                shipmentAddress.setCompany(request.getCompany());
                shipmentAddress.setEmail(request.getEmail());
                shipmentAddress.setCity(request.getCity());
                shipmentAddress.setState(request.getState());
                shipmentAddress.setAddressType(AddressType.valueOf(request.getType()));
                shipmentAddress.setPostalCode(request.getPostalCode());
                shipmentAddress.setPhone(request.getPhone());
                ShipmentAddress save = shipmentAddressRepository.save(shipmentAddress);
                list.add(save.getId());
            }
        }
        return new DataDto<>(list);
    }

    public DataDto<String> update(Integer id, ShipmentAddressSaveRequest request) {
        ShipmentAddress shipmentAddress = shipmentAddressRepository.findByIdAndDeleted(id);
        shipmentAddress.setHolderName(request.getHolderName());
        shipmentAddress.setCompany(request.getCompany());
        shipmentAddress.setCity(request.getCity());
        shipmentAddress.setState(request.getState());
        shipmentAddress.setPostalCode(request.getPostalCode());
        shipmentAddress.setPhone(request.getPhone());
        shipmentAddressRepository.save(shipmentAddress);
        return new DataDto<>(shipmentAddress.getId().toString());
    }

    public DataDto<ShipmentAddressDto> getOne(Integer id) {
        ShipmentAddress shipmentAddress = shipmentAddressRepository.findByIdAndDeleted(id);
        return new DataDto<>(ShipmentAddressDto.builder()
                .id(shipmentAddress.getId())
                .holderName(shipmentAddress.getHolderName())
                .company(shipmentAddress.getCompany())
                .city(shipmentAddress.getCity())
                .email(shipmentAddress.getEmail())
                .type(shipmentAddress.getAddressType().toString())
                .state(shipmentAddress.getState())
                .postalCode(shipmentAddress.getPostalCode())
                .phone(shipmentAddress.getPhone())
                .build());
    }

    public List<ShipmentAddressDto> getAll() {
        return shipmentAddressRepository.findAll()
                .stream().map(mapper::toDto).toList();
    }

    public DataDto<Boolean> delete(Integer id) {
        ShipmentAddress shipmentAddress = shipmentAddressRepository.findByIdAndDeleted(id);
        if (shipmentAddress == null) {
            throw new RuntimeException("Shipment address with id " + id + " not found");
        }
        shipmentAddressRepository.delete(shipmentAddress);
        return new DataDto<>(true);
    }
}

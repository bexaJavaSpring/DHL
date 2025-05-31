package com.java.team.shippingservice.mapper;

import com.java.team.shippingservice.dto.ShipmentAddressDto;
import com.java.team.shippingservice.entity.ShipmentAddress;
import org.springframework.stereotype.Component;

@Component
public class ShipmentAddressMapper {
    public ShipmentAddressDto toDto(ShipmentAddress entity) {
        ShipmentAddressDto dto = new ShipmentAddressDto();
        dto.setId(entity.getId());
        dto.setCompany(entity.getCompany());
        dto.setEmail(entity.getEmail());
        dto.setCity(entity.getCity());
        dto.setPostalCode(entity.getPostalCode());
        dto.setPhone(entity.getPhone());
        dto.setState(entity.getState());
        dto.setHolderName(entity.getHolderName());
        dto.setType(entity.getAddressType().toString());
        return dto;
    }
}

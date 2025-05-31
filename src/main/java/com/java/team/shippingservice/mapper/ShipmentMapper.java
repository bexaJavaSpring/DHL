package com.java.team.shippingservice.mapper;

import com.java.team.shippingservice.dto.ShipmentDto;
import com.java.team.shippingservice.entity.Shipment;
import org.springframework.stereotype.Component;

@Component
public class ShipmentMapper {

    public ShipmentDto toDto(Shipment shipment) {
        ShipmentDto shipmentDto = new ShipmentDto();
        shipmentDto.setId(shipment.getId());
        shipmentDto.setDescription(shipment.getDescription());
        shipmentDto.setShipmentType(String.valueOf(shipment.getShipmentType()));
        shipmentDto.setNickName(shipment.getNickName());
        return shipmentDto;
    }
}

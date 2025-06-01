package com.java.team.shippingservice.mapper;

import com.java.team.shippingservice.dto.PackageDto;
import com.java.team.shippingservice.entity.Packages;
import org.springframework.stereotype.Component;

@Component
public class PackageMapper {
    public PackageDto toDto(Packages entity) {
        PackageDto dto = new PackageDto();
        dto.setId(entity.getId());
        dto.setHeight(entity.getHeight());
        return dto;
    }
}

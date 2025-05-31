package com.java.team.shippingservice.mapper;

import com.java.team.shippingservice.dto.PackageDto;
import com.java.team.shippingservice.entity.Package;
import org.springframework.stereotype.Component;

@Component
public class PackageMapper {
    public PackageDto toDto(Package entity) {
        PackageDto dto = new PackageDto();
        dto.setId(entity.getId());
    }
}

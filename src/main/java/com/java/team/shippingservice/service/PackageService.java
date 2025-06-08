package com.java.team.shippingservice.service;

import com.java.team.shippingservice.dto.DataDto;
import com.java.team.shippingservice.dto.PackageDto;
import com.java.team.shippingservice.dto.PackageSaveRequest;
import com.java.team.shippingservice.entity.Packages;
import com.java.team.shippingservice.entity.Shipment;
import com.java.team.shippingservice.entity.enums.PackageStatus;
import com.java.team.shippingservice.entity.enums.PackageType;
import com.java.team.shippingservice.exception.CustomNotFoundException;
import com.java.team.shippingservice.mapper.PackageMapper;
import com.java.team.shippingservice.repository.PackageRepository;
import com.java.team.shippingservice.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PackageService {
    private final PackageRepository packageRepository;
    private final PackageMapper mapper;
    private final ShipmentRepository shipmentRepository;

    public DataDto<List<PackageDto>> findAll() {
        return new DataDto<>(packageRepository.findAll().stream().map(mapper::toDto).toList());
    }

    public DataDto<Integer> create(PackageSaveRequest request) {
        Packages packages = new Packages();
        packages.setType(PackageType.valueOf(request.getPackageType()));
        packages.setWeight(request.getWeight());
        packages.setQuantity(request.getQuantity());
        packages.setWidth(request.getWidth());
        packages.setHeight(request.getHeight());
        packages.setLength(request.getLength());
        Shipment shipment = shipmentRepository.findByIdCustom(request.getShipmentId());
        if (shipment == null) {
            throw new CustomNotFoundException("Shipment not found");
        }
        packages.setShipment(shipment);
        packages.setStatus(PackageStatus.PENDING);
        Packages save = packageRepository.save(packages);
        return new DataDto<>(save.getId());
    }

    public DataDto<Integer> update(Integer id, PackageSaveRequest request) {
        Packages packages = packageRepository.findByIdCustom(id);
        if (packages == null) {
            throw new CustomNotFoundException("Package not found");
        }
        packages.setType(PackageType.valueOf(request.getPackageType()));
        packages.setWeight(request.getWeight());
        packages.setQuantity(request.getQuantity());
        packages.setWidth(request.getWidth());
        packages.setHeight(request.getHeight());
        packages.setLength(request.getLength());
        packages.setStatus(PackageStatus.valueOf(request.getStatus()));
        packageRepository.save(packages);
        return new DataDto<>(packages.getId());
    }

    public DataDto<PackageDto> delete(Integer id) {
        Packages packages = packageRepository.findByIdCustom(id);
        if (packages == null) {
            throw new CustomNotFoundException("Package not found");
        }
        packageRepository.delete(packages);
        return new DataDto<>(true);
    }

    public DataDto<PackageDto> getOne(Integer id) {
        Packages packages = packageRepository.findByIdCustom(id);
        if (packages == null) {
            throw new CustomNotFoundException("Package not found");
        }
        return new DataDto<>(mapper.toDto(packages));
    }
}

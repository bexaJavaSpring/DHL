package com.java.team.shippingservice.service;

import com.java.team.shippingservice.dto.DataDto;
import com.java.team.shippingservice.dto.PackageDto;
import com.java.team.shippingservice.dto.PackageSaveRequest;
import com.java.team.shippingservice.mapper.PackageMapper;
import com.java.team.shippingservice.repository.PackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PackageService {
    private final PackageRepository packageRepository;
    private final PackageMapper mapper;

    public DataDto<List<PackageDto>> findAll() {
        return new DataDto<>(packageRepository.findAll().stream().map(mapper::toDto).toList());
    }

    public DataDto<PackageDto> create(PackageSaveRequest request) {

    }

    public DataDto<PackageDto> update(Integer id, PackageSaveRequest request) {
        return null;
    }

    public DataDto<PackageDto> delete(Integer id) {
        return null;
    }

    public DataDto<PackageDto> getOne(Integer id) {
        return null;
    }
}

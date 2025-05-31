package com.java.team.shippingservice.service;

import com.java.team.shippingservice.dto.DataDto;
import com.java.team.shippingservice.dto.PackageDto;
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
        return packageRepository.findAll().stream().map(mapper::toDto).toList();
    }

}

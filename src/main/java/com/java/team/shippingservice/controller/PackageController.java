package com.java.team.shippingservice.controller;

import com.java.team.shippingservice.dto.DataDto;
import com.java.team.shippingservice.dto.PackageDto;
import com.java.team.shippingservice.dto.PackageSaveRequest;
import com.java.team.shippingservice.service.PackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/package")
@RequiredArgsConstructor
public class PackageController {

    private final PackageService service;

    @GetMapping("/all")
    public ResponseEntity<DataDto<List<PackageDto>>> all() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<DataDto<PackageDto>> create(@RequestBody PackageSaveRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DataDto<PackageDto>> update(@PathVariable Integer id, @RequestBody PackageSaveRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataDto<PackageDto>> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataDto<PackageDto>> get(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getOne(id));
    }
}

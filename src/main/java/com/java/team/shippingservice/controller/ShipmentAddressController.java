package com.java.team.shippingservice.controller;

import com.java.team.shippingservice.dto.*;
import com.java.team.shippingservice.service.ShipmentAddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipment-address")
public class ShipmentAddressController {

    private final ShipmentAddressService service;

    public ShipmentAddressController(ShipmentAddressService service) {
        this.service = service;
    }

    @PostMapping("/create")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<DataDto<ShipmentAddressResponse>> createShipmentAddress(@RequestBody ShipmentListRequestDto request) {
        return ResponseEntity.ok(service.create(request));
    }

    @PutMapping("/update/{id}")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<DataDto<Integer>> updateShipmentAddress(@PathVariable Integer id, @RequestBody ShipmentAddressSaveRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<DataDto<ShipmentAddressDto>> showShipmentAddress(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getOne(id));
    }

    @GetMapping("/all")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<DataDto<List<ShipmentAddressDto>>> showAllShipmentAddresses() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<DataDto<Boolean>> deleteShipmentAddress(@PathVariable Integer id) {
        return ResponseEntity.ok(service.delete(id));
    }
}

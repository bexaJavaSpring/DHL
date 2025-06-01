package com.java.team.shippingservice.controller;

import com.java.team.shippingservice.dto.DataDto;
import com.java.team.shippingservice.dto.ShipmentAddressDto;
import com.java.team.shippingservice.dto.ShipmentAddressSaveRequest;
import com.java.team.shippingservice.dto.ShipmentListRequestDto;
import com.java.team.shippingservice.service.ShipmentAddressService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<DataDto<List<Integer>>> createShipmentAddress(@RequestBody ShipmentListRequestDto request) {
        return ResponseEntity.ok(service.create(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DataDto<Integer>> updateShipmentAddress(@PathVariable Integer id, @RequestBody ShipmentAddressSaveRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataDto<ShipmentAddressDto>> showShipmentAddress(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getOne(id));
    }

    @GetMapping("/all")
    public ResponseEntity<DataDto<List<ShipmentAddressDto>>> showAllShipmentAddresses() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataDto<Boolean>> deleteShipmentAddress(@PathVariable Integer id) {
        return ResponseEntity.ok(service.delete(id));
    }
}

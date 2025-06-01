package com.java.team.shippingservice.controller;

import com.java.team.shippingservice.dto.DataDto;
import com.java.team.shippingservice.dto.ShipmentDto;
import com.java.team.shippingservice.dto.ShipmentSaveRequest;
import com.java.team.shippingservice.service.ShipmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    private final ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping("/create")
    public ResponseEntity<DataDto<Integer>> createShipment(@RequestBody @Valid ShipmentSaveRequest request) {
        return ResponseEntity.ok(shipmentService.create(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DataDto<Integer>> updateShipment(@RequestBody ShipmentSaveRequest request, @PathVariable Integer id) {
        return ResponseEntity.ok(shipmentService.update(request, id));
    }

    @GetMapping("/all")
    public ResponseEntity<DataDto<List<ShipmentDto>>> all() {
        return ResponseEntity.ok(shipmentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataDto<ShipmentDto>> getOne(@PathVariable Integer id) {
        return ResponseEntity.ok(shipmentService.getOne(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataDto<Boolean>> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(shipmentService.delete(id));
    }
}

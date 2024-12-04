package com.example.ERP_MANAGEMENT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ERP_MANAGEMENT.models.Bus;
import com.example.ERP_MANAGEMENT.service.BusService;
@CrossOrigin
@RestController
@RequestMapping("/api/buses")
public class BusController {

    @Autowired
    private BusService busesService;

    // POST a new bus
    @PostMapping
    public ResponseEntity<Bus> addBus(@RequestBody Bus bus) {
        return ResponseEntity.ok(busesService.addBus(bus));
    }

    // GET all buses
    @GetMapping
    public ResponseEntity<List<Bus>> getAllBuses() {
        return ResponseEntity.ok(busesService.getAllBuses());
    }

    // GET a specific bus by ID
    @GetMapping("/{id}")
    public ResponseEntity<Bus> getBusById(@PathVariable Long id) {
        return busesService.getBusById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body(null));
    }

    // Update a bus by ID
    @PutMapping("/{id}")
    public ResponseEntity<Bus> updateBus(@PathVariable Long id, @RequestBody Bus bus) {
        try {
            return ResponseEntity.ok(busesService.updateBus(id, bus));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    // Delete a bus by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBus(@PathVariable Long id) {
        busesService.deleteBus(id);
        return ResponseEntity.ok("Bus deleted successfully");
    }
}

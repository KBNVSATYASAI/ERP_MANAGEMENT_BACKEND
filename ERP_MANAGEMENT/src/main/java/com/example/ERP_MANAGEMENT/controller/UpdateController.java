package com.example.ERP_MANAGEMENT.controller;

import java.util.List;
import java.util.Optional;

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

import com.example.ERP_MANAGEMENT.models.Update;
import com.example.ERP_MANAGEMENT.service.UpdateService;
@CrossOrigin
@RestController
@RequestMapping("api/updates")
public class UpdateController {

    @Autowired
    private UpdateService updateService;

    // POST a new update
    @PostMapping
    public ResponseEntity<Update> createUpdate(@RequestBody Update update) {
        Update savedUpdate = updateService.createUpdate(update);
        return ResponseEntity.status(200).body(savedUpdate);
    }

    // GET all updates
    @GetMapping
    public ResponseEntity<List<Update>> getAllUpdates() {
        List<Update> updates = updateService.getAllUpdates();
        return ResponseEntity.ok(updates);
    }

    // GET a specific update by ID
    @GetMapping("/{id}")
    public ResponseEntity<Update> getUpdateById(@PathVariable String id) {
        Optional<Update> update = updateService.getUpdateById(id);
        return update.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body(null));
    }

    // Update an update by ID
    @PutMapping("/{id}")
    public ResponseEntity<Update> updateUpdate(@PathVariable String id, @RequestBody Update updateDetails) {
        Update updatedUpdate = updateService.updateUpdate(id, updateDetails);
        return ResponseEntity.ok(updatedUpdate);
    }

    // Delete an update by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUpdate(@PathVariable String id) {
        updateService.deleteUpdate(id);
        return ResponseEntity.ok("Update deleted successfully");
    }

    // Delete updates by StudentId
    @DeleteMapping("/student/{studentId}")
    public ResponseEntity<String> deleteUpdatesByStudentId(@PathVariable String studentId) {
        try {
            updateService.deleteUpdatesByStudentId(studentId);
            return ResponseEntity.ok("Updates deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}

package com.example.ERP_MANAGEMENT.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP_MANAGEMENT.Repository.UpdateRepository;
import com.example.ERP_MANAGEMENT.models.Update;

@Service
public class UpdateService {

    @Autowired
    private UpdateRepository updateRepository;

    public Update createUpdate(Update update) {
        return updateRepository.save(update);
    }

    public List<Update> getAllUpdates() {
        return updateRepository.findAll();
    }

    public Optional<Update> getUpdateById(String id) {
        return updateRepository.findById(id);
    }

    public Update updateUpdate(String id, Update updateDetails) {
        Update existingUpdate = updateRepository.findById(id).orElseThrow(() -> new RuntimeException("Update not found"));
        existingUpdate.setStudentId(updateDetails.getStudentId());
        existingUpdate.setUpdateRequest(updateDetails.getUpdateRequest());
        existingUpdate.setDisc(updateDetails.getDisc());
        return updateRepository.save(existingUpdate);
    }

    public void deleteUpdate(String id) {
        updateRepository.deleteById(id);
    }

    public void deleteUpdatesByStudentId(String studentId) {
        List<Update> updates = updateRepository.findByStudentId(studentId);
        if (!updates.isEmpty()) {
            updateRepository.deleteAll(updates);
        } else {
            throw new RuntimeException("No updates found for the student");
        }
    }
}

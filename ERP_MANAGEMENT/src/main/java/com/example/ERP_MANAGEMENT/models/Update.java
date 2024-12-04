package com.example.ERP_MANAGEMENT.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "update_requests")  // Renaming the table to avoid reserved keyword
public class Update {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate the ID
    private Long id;  // Change id type to Long
    
    private String studentId;
    private String updateRequest;
    private String disc;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getUpdateRequest() {
        return updateRequest;
    }

    public void setUpdateRequest(String updateRequest) {
        this.updateRequest = updateRequest;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }
}

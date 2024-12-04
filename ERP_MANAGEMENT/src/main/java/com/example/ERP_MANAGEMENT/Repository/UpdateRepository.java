package com.example.ERP_MANAGEMENT.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ERP_MANAGEMENT.models.Update;

public interface UpdateRepository extends JpaRepository<Update, String> {
    List<Update> findByStudentId(String studentId);
}

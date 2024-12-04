package com.example.ERP_MANAGEMENT.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ERP_MANAGEMENT.models.Marks;

public interface MarksRepository extends JpaRepository<Marks, Long> {
    List<Marks> findByStudentId(String studentId);
    Marks findByStudentIdAndExamName(String studentId, String examName);
    List<Marks> findByExamName(String examName);
}

package com.example.ERP_MANAGEMENT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP_MANAGEMENT.Repository.MarksRepository;
import com.example.ERP_MANAGEMENT.models.Marks;

@Service
public class MarksService {

    @Autowired
    private MarksRepository repository;

    public Marks addStudentMarks(Marks marks) {
        return repository.save(marks);
    }

    public List<Marks> getAllMarks() {
        return repository.findAll();
    }

    public Marks getMarksByStudentAndExam(String studentId, String examName) {
        return repository.findByStudentIdAndExamName(studentId, examName);
    }

    public List<Marks> getMarksByStudentId(String studentId) {
        return repository.findByStudentId(studentId);
    }

    public List<Marks> getMarksByExamName(String examName) {
        return repository.findByExamName(examName);
    }

    public Marks updateMarks(Marks marks) {
        return repository.save(marks);
    }

    public void deleteMarksById(Long id) {
        repository.deleteById(id);
    }

    public void deleteMarksByStudentAndExam(String studentId, String examName) {
        Marks marks = repository.findByStudentIdAndExamName(studentId, examName);
        if (marks != null) {
            repository.delete(marks);
        }
    }

    public void deleteAllMarks() {
        repository.deleteAll();
    }
}

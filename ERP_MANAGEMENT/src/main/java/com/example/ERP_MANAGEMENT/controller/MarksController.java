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

import com.example.ERP_MANAGEMENT.models.Marks;
import com.example.ERP_MANAGEMENT.service.MarksService;
@CrossOrigin
@RestController
@RequestMapping("/api/marks")
public class MarksController {

    @Autowired
    private MarksService service;

    @PostMapping
    public ResponseEntity<Marks> addMarks(@RequestBody Marks marks) {
        return ResponseEntity.ok(service.addStudentMarks(marks));
    }

    @GetMapping
    public ResponseEntity<List<Marks>> getAllMarks() {
        return ResponseEntity.ok(service.getAllMarks());
    }

    @GetMapping("/{studentId}/{examName}")
    public ResponseEntity<Marks> getMarksByStudentAndExam(
            @PathVariable String studentId,
            @PathVariable String examName) {
        return ResponseEntity.ok(service.getMarksByStudentAndExam(studentId, examName));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Marks>> getMarksByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok(service.getMarksByStudentId(studentId));
    }

    @GetMapping("/exam/{examName}")
    public ResponseEntity<List<Marks>> getMarksByExamName(@PathVariable String examName) {
        return ResponseEntity.ok(service.getMarksByExamName(examName));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marks> updateMarks(@PathVariable Long id, @RequestBody Marks marks) {
        marks.setId(id);
        return ResponseEntity.ok(service.updateMarks(marks));
    }

    @DeleteMapping("/{studentId}/{examName}")
    public ResponseEntity<String> deleteMarksByStudentAndExam(
            @PathVariable String studentId,
            @PathVariable String examName) {
        service.deleteMarksByStudentAndExam(studentId, examName);
        return ResponseEntity.ok("Marks deleted successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllMarks() {
        service.deleteAllMarks();
        return ResponseEntity.ok("All marks deleted successfully");
    }
}

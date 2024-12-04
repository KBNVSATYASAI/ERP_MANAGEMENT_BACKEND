package com.example.ERP_MANAGEMENT.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP_MANAGEMENT.Repository.StudentRepository;
import com.example.ERP_MANAGEMENT.models.Student;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String login(String studentId, String password) {
        Optional<Student> student = studentRepository.findByStudentId(studentId);
        if (student.isPresent()) {
            return student.get().getPassword().equals(password) ? "Success login" : "Password is incorrect";
        }
        return "No Student Found";
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> addMultipleStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    public Optional<Student> getStudentByStudentId(String studentId) {
        return studentRepository.findByStudentId(studentId);
    }

    public Student updateStudent(String id, Student updatedStudent) {
        if (studentRepository.existsById(id)) {
            updatedStudent.setStudentId(id);
            return studentRepository.save(updatedStudent);
        }
        throw new RuntimeException("Student not found");
    }

    public void deleteStudent(String id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Student not found");
        }
    }
}

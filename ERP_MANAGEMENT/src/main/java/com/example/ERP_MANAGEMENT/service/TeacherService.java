package com.example.ERP_MANAGEMENT.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP_MANAGEMENT.Repository.TeacherRepository;
import com.example.ERP_MANAGEMENT.models.Teacher;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    // Login Service (POST method to handle login)
    public String login(String teacherId, String password) {
        Optional<Teacher> teacher = teacherRepository.findByTeacherId(teacherId);
        if (teacher.isPresent()) {
            if (teacher.get().getPassword().equals(password)) {
                return "Success login";
            } else {
                return "Password is incorrect";
            }
        } else {
            return "No Teacher Found";
        }
    }

    // Add a new teacher
    public Teacher addTeacher(Teacher teacher) {
        Optional<Teacher> existingTeacher = teacherRepository.findByTeacherId(teacher.getTeacherId());
        if (existingTeacher.isPresent()) {
            throw new IllegalArgumentException("Teacher ID is already in use.");
        }
        return teacherRepository.save(teacher);
    }

    // Get all teachers
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    // Get teacher by ID
    public Optional<Teacher> getTeacherById(String id) {
        return teacherRepository.findById(id);
    }

    // Get teacher by TeacherId
    public Optional<Teacher> getTeacherByTeacherId(String teacherId) {
        return teacherRepository.findByTeacherId(teacherId);
    }

    // Update teacher
    public Teacher updateTeacher(String id, Teacher teacherDetails) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new RuntimeException("Teacher not found"));
        teacher.setTeacherName(teacherDetails.getTeacherName());
        teacher.setSubject(teacherDetails.getSubject());
        teacher.setMobileNumber(teacherDetails.getMobileNumber());
        teacher.setAddress(teacherDetails.getAddress());
        teacher.setPassword(teacherDetails.getPassword());
        return teacherRepository.save(teacher);
    }

    // Delete teacher
    public void deleteTeacher(String id) {
        teacherRepository.deleteById(id);
    }
}

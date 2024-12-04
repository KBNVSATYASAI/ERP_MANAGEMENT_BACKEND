package com.example.ERP_MANAGEMENT.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentId;
    private String studentName;
    private String examName;
    private String studentClass;
    private Integer telugu;
    private Integer hindi;
    private Integer english;
    private Integer maths;
    private Integer science;
    private Integer social;
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
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getExamName() {
        return examName;
    }
    public void setExamName(String examName) {
        this.examName = examName;
    }
    public String getStudentClass() {
        return studentClass;
    }
    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }
    public Integer getTelugu() {
        return telugu;
    }
    public void setTelugu(Integer telugu) {
        this.telugu = telugu;
    }
    public Integer getHindi() {
        return hindi;
    }
    public void setHindi(Integer hindi) {
        this.hindi = hindi;
    }
    public Integer getEnglish() {
        return english;
    }
    public void setEnglish(Integer english) {
        this.english = english;
    }
    public Integer getMaths() {
        return maths;
    }
    public void setMaths(Integer maths) {
        this.maths = maths;
    }
    public Integer getScience() {
        return science;
    }
    public void setScience(Integer science) {
        this.science = science;
    }
    public Integer getSocial() {
        return social;
    }
    public void setSocial(Integer social) {
        this.social = social;
    }

    // Getters and Setters
    
}

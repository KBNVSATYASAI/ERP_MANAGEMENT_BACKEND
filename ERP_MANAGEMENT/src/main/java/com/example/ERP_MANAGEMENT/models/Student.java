package com.example.ERP_MANAGEMENT.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private String studentId;
    private String studentName;
    private String parentNames;
    private String mobileNumber;
    private String studentClass;
    private String address;
    private String password;
    private Double fee;
    private Double feePaid;
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
    public String getParentNames() {
        return parentNames;
    }
    public void setParentNames(String parentNames) {
        this.parentNames = parentNames;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public String getStudentClass() {
        return studentClass;
    }
    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Double getFee() {
        return fee;
    }
    public void setFee(Double fee) {
        this.fee = fee;
    }
    public Double getFeePaid() {
        return feePaid;
    }
    public void setFeePaid(Double feePaid) {
        this.feePaid = feePaid;
    }

    // Getters and Setters
    
}

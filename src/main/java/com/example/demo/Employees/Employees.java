package com.example.demo.Employees;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String employeeName;
    private String employeeMobile;
    private String employeeDesignation;
    private String employeeAddress;
    private String dateOfJoining;

    public Employees() {
    }

    public Employees(Integer id, String employeeName, String employeeMobile, String employeeDesignation, String employeeAddress, String dateOfJoining) {
        this.id = id;
        this.employeeName = employeeName;
        this.employeeMobile = employeeMobile;
        this.employeeDesignation = employeeDesignation;
        this.employeeAddress = employeeAddress;
        this.dateOfJoining = dateOfJoining;
    }

    public Employees(String employeeName, String employeeMobile, String employeeDesignation, String employeeAddress, String dateOfJoining) {
        this.employeeName = employeeName;
        this.employeeMobile = employeeMobile;
        this.employeeDesignation = employeeDesignation;
        this.employeeAddress = employeeAddress;
        this.dateOfJoining = dateOfJoining;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeMobile() {
        return employeeMobile;
    }

    public void setEmployeeMobile(String employeeMobile) {
        this.employeeMobile = employeeMobile;
    }

    public String getEmployeeDesignation() {
        return employeeDesignation;
    }

    public void setEmployeeDesignation(String employeeDesignation) {
        this.employeeDesignation = employeeDesignation;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", employeeMobile='" + employeeMobile + '\'' +
                ", employeeDesignation='" + employeeDesignation + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", dateOfJoining=" + dateOfJoining +
                '}';
    }
}

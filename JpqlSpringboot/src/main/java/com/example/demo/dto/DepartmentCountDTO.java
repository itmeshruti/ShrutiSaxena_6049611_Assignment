package com.example.demo.dto;

public class DepartmentCountDTO {

    private String deptName;
    private Long employeeCount;

    public DepartmentCountDTO(String deptName, Long employeeCount) {
        this.deptName = deptName;
        this.employeeCount = employeeCount;
    }

    // Getters
    public String getDeptName() { return deptName; }
    public Long getEmployeeCount() { return employeeCount; }

    // Setters (needed for Jackson serialization/deserialization)
    public void setDeptName(String deptName) { this.deptName = deptName; }
    public void setEmployeeCount(Long employeeCount) { this.employeeCount = employeeCount; }
}
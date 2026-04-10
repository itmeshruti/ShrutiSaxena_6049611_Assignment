package com.example.demo.dto;

public class EmployeeWithDepartmentDTO {
    private Long empId;
    private String empName;
    private String deptName;
    public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptManager() {
		return deptManager;
	}

	public void setDeptManager(String deptManager) {
		this.deptManager = deptManager;
	}

	private String deptManager;

    public EmployeeWithDepartmentDTO(Long empId, String empName, String deptName, String deptManager) {
        this.empId = empId;
        this.empName = empName;
        this.deptName = deptName;
        this.deptManager = deptManager;
    }

    // Getters and Setters
}
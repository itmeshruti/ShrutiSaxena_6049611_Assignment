package com.demos.springcoree.beans;

public class Employee {

    private int employeeId;
    private String employeeName;
    private double salary;

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return "Employee [empId=" + employeeId +
               ", empName=" + employeeName +
               ", empSalary=" + salary + "]";
    }
    public void getSBUDdetails() {

        System.out.println("Employee Details");
        System.out.println("-----------------------");

        System.out.println("Employee ID = " + employeeId);
        System.out.println("Employee Name = " + employeeName);
        System.out.println("Employee Salary = " + salary);
    }
}
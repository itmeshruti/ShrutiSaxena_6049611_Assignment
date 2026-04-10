package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Employee;
import com.example.demo.repo.IEmployee;
import com.example.demo.repo.IDepartment;
import com.example.demo.dto.EmployeeWithDepartmentDTO;
import com.example.demo.dto.DepartmentCountDTO;
import com.example.demo.exception.DepartmentNameNotFoundException;
import com.example.demo.exception.MobileNumberDoesNotExistsForEmployeeException;

@Service
public class EmployeeService {

    private final IEmployee employeeRepo;
    private final IDepartment departmentRepo;

    public EmployeeService(IEmployee employeeRepo, IDepartment departmentRepo) {
        this.employeeRepo = employeeRepo;
        this.departmentRepo = departmentRepo;
    }

    // Insert
    public Employee saveEmployee(Employee emp) {
        return employeeRepo.save(emp);
    }

    // Convert Entity → DTO
    public List<EmployeeWithDepartmentDTO> getAllEmployees() {

        List<Employee> list = employeeRepo.findAllWithDepartment();

        return list.stream().map(e ->
            new EmployeeWithDepartmentDTO(
                e.getId(),
                e.getName(),
                e.getDepartment().getName(),
                e.getDepartment().getManagerName()
            )
        ).toList();
    }

    public List<EmployeeWithDepartmentDTO> getEmployeesByDept(String deptName) {

        List<Employee> list = employeeRepo.findByDeptName(deptName);

        if (list.isEmpty()) {
            throw new DepartmentNameNotFoundException("Department not found: " + deptName);
        }

        return list.stream().map(e ->
            new EmployeeWithDepartmentDTO(
                e.getId(),
                e.getName(),
                e.getDepartment().getName(),
                e.getDepartment().getManagerName()
            )
        ).toList();
    }

    public Employee getEmployeeByMobile(String mobile) {
        Employee emp = employeeRepo.findEmployeeByMobile(mobile);

        if (emp == null) {
            throw new MobileNumberDoesNotExistsForEmployeeException("No employee found with mobile: " + mobile);
        }

        return emp;
    }

    public List<DepartmentCountDTO> getEmployeeCountByDept() {
        return departmentRepo.countEmployeesPerDept();
    }
}
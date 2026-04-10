package com.example.demo.repo;

import com.example.demo.entities.Employee;
import com.example.demo.dto.EmployeeWithDepartmentDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmployee extends JpaRepository<Employee, Long> {

    // Fetch all employees along with department name & manager using DTO
	@Query("SELECT e FROM Employee e JOIN FETCH e.department")
    List<Employee> findAllWithDepartment();

    @Query("SELECT e FROM Employee e JOIN FETCH e.department d WHERE d.name = :deptName")
    List<Employee> findByDeptName(@Param("deptName") String deptName);

    @Query("SELECT e FROM Employee e JOIN FETCH e.department JOIN e.mobileNumbers m WHERE m = :mobile")
    Employee findEmployeeByMobile(@Param("mobile") String mobile);
}
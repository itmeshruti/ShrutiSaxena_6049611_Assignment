package com.example.demo.repo;

import com.example.demo.entities.Department;
import com.example.demo.dto.DepartmentCountDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDepartment extends JpaRepository<Department, Long> {

    // Count employees in each department using DTO
	@Query("SELECT new com.example.demo.dto.DepartmentCountDTO(d.name, COUNT(e)) " +
	           "FROM Department d LEFT JOIN d.employees e GROUP BY d.name")
	    List<DepartmentCountDTO> countEmployeesPerDept();

	    Department findByName(String name);
}
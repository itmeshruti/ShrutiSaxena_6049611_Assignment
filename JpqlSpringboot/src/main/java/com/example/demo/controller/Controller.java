package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;

import com.example.demo.service.EmployeeService;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Department;
import com.example.demo.dto.EmployeeWithDepartmentDTO;
import com.example.demo.dto.DepartmentCountDTO;
import com.example.demo.repo.IDepartment;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private EmployeeService service;

    @Autowired
    private IDepartment departmentRepo;

    @PostMapping("/employees")
    public Employee addEmployee(@Valid @RequestBody Employee emp) {
        return service.saveEmployee(emp);
    }

    @GetMapping("/employees")
    public List<EmployeeWithDepartmentDTO> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/employees/department/{name}")
    public List<EmployeeWithDepartmentDTO> getByDept(@PathVariable String name) {
        return service.getEmployeesByDept(name);
    }

    @GetMapping("/employees/mobile/{mobile}")
    public Employee getByMobile(@PathVariable String mobile) {
        return service.getEmployeeByMobile(mobile);
    }

    @GetMapping("/departments/count")
    public List<DepartmentCountDTO> getEmployeeCount() {
        return service.getEmployeeCountByDept();
    }

    // Optional
    @PostMapping("/departments")
    public Department addDepartment(@RequestBody Department dept) {
        return departmentRepo.save(dept);
    }
}




















//package com.example.demo.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.entities.Department;
//import com.example.demo.entities.Employee;
//import com.example.demo.exception.EmployeeNotFoundException;
//import com.example.demo.repo.IDepartment;
//import com.example.demo.repo.IEmployee;
//
//import jakarta.validation.Valid;
//
//@RestController
//public class Controller {
//	@Autowired
//	private IEmployee empRepo;
//
//	@Autowired
//	private IDepartment deptRepo;
//
//	@PostMapping("/emp")
//	public String addEmployee(@Valid @RequestBody Employee emp) {
//		empRepo.save(emp);
//		return "Employee Added...";
//	}
//
//	@PostMapping("/dept")
//	public String addDepartment(@RequestBody Department dept) {
//		deptRepo.save(dept);
//		return "Department Added...";
//	}
//
//	@GetMapping("/emp")
//	public List<Employee> getAllEmployees() {
//		return empRepo.findAll();
//	}
//
//	@GetMapping("/dept")
//	public List<Department> getAllDepartments() {
//		return deptRepo.findAll();
//	}
//
//	@GetMapping("/emp/deptmg")
//	public List<Object[]> getEmpDeptMg() {
//		return empRepo.getEmpDeptMg();
//	}
//
//	@GetMapping("/emp/countbydept")
//	public List<Object[]> getEmpCountByDept() {
//		return empRepo.getEmpCountByDept();
//	}
//	
//	@GetMapping("/emp/deptname")
//	public List<Employee> getEmpByDeptName(@RequestParam String deptName) {
//		return empRepo.getEmpByDeptName(deptName);
//	}
//	
//	@GetMapping("/emp/byPhone")
//	public List<Object[]> getEmpByPhone(@RequestParam String empPhone) {
//
//		List<Object[]> result = empRepo.getEmpByPhone(empPhone);
//
//		if (result == null || result.isEmpty()) {
//			throw new EmployeeNotFoundException("Employee with phone number " + empPhone + " not found");
//		}
//
//		return result;
//	}
//
////	@ExceptionHandler(EmployeeNotFoundException.class)
////    public ResponseEntity<String> handlerForPhoneNotFound(EmployeeNotFoundException ex) {
////
////        return ResponseEntity
////                .status(HttpStatus.NOT_FOUND)
////                .body(ex.getMessage());
////    }
//}
//
//
//
//
//

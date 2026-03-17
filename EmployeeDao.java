package com.demos.springcore.beans;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDao {

    private List<Employee> empList = new ArrayList<>();

    public EmployeeDao() {
        empList.add(new Employee(100, "Rama", 12345.67));
        empList.add(new Employee(101, "Shyam", 20000));
    }

    public Employee getEmployeeById(int id) {
        return empList.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
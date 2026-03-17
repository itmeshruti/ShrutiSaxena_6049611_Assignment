package com.demos.springcore.beans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeDao dao;

    public Employee getEmployee(int id) {
        return dao.getEmployeeById(id);
    }
}
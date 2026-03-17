package com.demos.springcore.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        System.out.println("Starting Application...");

        ApplicationContext ac =
                new ClassPathXmlApplicationContext("beans.xml");

        EmployeeService service = ac.getBean(EmployeeService.class);

        Employee emp = service.getEmployee(101);

        System.out.println("Employee Info:");
        System.out.println("Employee ID: " + emp.getId());
        System.out.println("Employee NAME: " + emp.getName());
        System.out.println("Employee SALARY: " + emp.getSalary());

        System.out.println("Closing Application...");
    }
}
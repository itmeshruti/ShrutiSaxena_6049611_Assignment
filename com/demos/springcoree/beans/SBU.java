package com.demos.springcoree.beans;

import java.util.List;

public class SBU {

    private String sbuCode;
    private String sbuName;
    private String sbuHead;

    private List<Employee> empList;

    public void setSbuCode(String sbuCode) {
        this.sbuCode = sbuCode;
    }

    public void setSbuName(String sbuName) {
        this.sbuName = sbuName;
    }

    public void setSbuHead(String sbuHead) {
        this.sbuHead = sbuHead;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }

    public void display() {

        System.out.println("SBU Details");
        System.out.println("------------------------");

        System.out.println("SBU Code = " + sbuCode);
        System.out.println("SBU Name = " + sbuName);
        System.out.println("SBU Head = " + sbuHead);

        System.out.println("\nEmployee Details:");

        for(Employee e : empList) {
            System.out.println(e);
        }
    }
}
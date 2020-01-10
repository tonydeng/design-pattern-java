package com.github.tonydeng.desgin.proxy.virual;

/**
 * Created by tonydeng on 15/10/5.
 */
public class Employee {
    private String employeeName;
    private double employeeSalary;
    private String employeeDesignation;

    public Employee(String employeeName, double employeeSalary, String employeeDesignation) {
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeDesignation = employeeDesignation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeSalary='" + employeeSalary + '\'' +
                ", employeeDesignation='" + employeeDesignation + '\'' +
                '}';
    }
}

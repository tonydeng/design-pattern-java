package com.github.tonydeng.desgin.proxy.virual.impl;

import com.github.tonydeng.desgin.proxy.virual.ContactList;
import com.github.tonydeng.desgin.proxy.virual.Employee;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by tonydeng on 15/10/5.
 */
public class ContactListImpl implements ContactList {
    @Override
    public List<Employee> getEmployeeList() {
        List<Employee> employees = Lists.newArrayList(
                new Employee("Employee A", 2565.55, "SE"),
                new Employee("Employee B", 22574, "Manager"),
                new Employee("Employee C", 3256.77, "SSE"),
                new Employee("Employee D", 4875.54, "SSE"),
                new Employee("Employee E", 2847.01, "SE")
        );

        return employees;
    }
}

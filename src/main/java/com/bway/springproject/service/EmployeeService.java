package com.bway.springproject.service;

import com.bway.springproject.model.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee emp);
    void deleteEmployee(int id);
    void updateEmployee(Employee emp);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();

}

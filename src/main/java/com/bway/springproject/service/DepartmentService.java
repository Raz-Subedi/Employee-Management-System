package com.bway.springproject.service;

import com.bway.springproject.model.Department;

import java.util.List;

public interface DepartmentService {

    void addDept(Department dept);
    void deleteDept(int dptId);
    void updateDept(Department dept);
    List<Department> getAllDept();
    Department getDeptById(int deptId);

}

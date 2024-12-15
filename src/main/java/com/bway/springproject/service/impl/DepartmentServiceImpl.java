package com.bway.springproject.service.impl;

import com.bway.springproject.model.Department;
import com.bway.springproject.repository.DepartmentRepository;
import com.bway.springproject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository deptRepo;
    @Override
    public void addDept(Department dept) {
        deptRepo.save(dept);

    }

    @Override
    public void deleteDept(int dptId) {
        deptRepo.deleteById(dptId);

    }

    @Override
    public void updateDept(Department dept) {
        deptRepo.save(dept);

    }

    @Override
    public List<Department> getAllDept() {
        return deptRepo.findAll();
    }

    @Override
    public Department getDeptById(int deptId) {
        return deptRepo.findById(deptId).get();
    }
}

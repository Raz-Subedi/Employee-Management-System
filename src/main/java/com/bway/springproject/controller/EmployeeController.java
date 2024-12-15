package com.bway.springproject.controller;

import com.bway.springproject.model.Employee;
import com.bway.springproject.service.DepartmentService;
import com.bway.springproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService empService;
    @Autowired
    private DepartmentService deptService;

    @GetMapping("/employee")
    public String getEmployee(Model model){
        model.addAttribute("dList",deptService.getAllDept());

        return "EmployeeForm";
    }

    @PostMapping("/employee")
    public String postEmployee(@ModelAttribute Employee emp){
        empService.addEmployee(emp);

        return "redirect:/employee";
    }

    @GetMapping("/employeeList")
    public String getEmpList(Model model){
        model.addAttribute("eList",empService.getAllEmployees());

        return "EmployeeListForm";
    }
    @GetMapping("/emp/edit")
    public String edit(@RequestParam int id,Model model){
        model.addAttribute("eModel",empService.getEmployeeById(id));
        model.addAttribute("dList",deptService.getAllDept());

        return "EmployeeEditForm";
    }
    @PostMapping("/emp/update")
    public String update(@ModelAttribute Employee emp){
        empService.addEmployee(emp);

        return "redirect:/employeeList";
    }

    @GetMapping("/emp/delete")
    public String delete(@RequestParam int id){
        empService.deleteEmployee(id);

        return "redirect:/employeeList";
    }

}

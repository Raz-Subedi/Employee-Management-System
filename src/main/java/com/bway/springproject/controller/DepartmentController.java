package com.bway.springproject.controller;

import com.bway.springproject.model.Department;
import com.bway.springproject.service.DepartmentService;
import com.bway.springproject.utils.DepartmentExcelView;
import com.bway.springproject.utils.DepartmentPdfView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService deptService;

    @GetMapping("/department")
    public String getDeptForm(){

        return "DepartmentForm";
    }

    @PostMapping("/department")
    public String postDept(@ModelAttribute Department dept){
        deptService.addDept(dept);

        return "DepartmentForm";
    }

    @GetMapping("/departmentList")
    public String getDpList(Model model){
        model.addAttribute("dList",deptService.getAllDept());
        return "DepartmentListForm";
    }

    @GetMapping("/dept/delete")
    public String delete(@RequestParam int id){
        deptService.deleteDept(id);

        return "redirect:/departmentList";
    }
    @GetMapping("/dept/edit")
    public String edit(@RequestParam int id,Model model){

        model.addAttribute("dModel",deptService.getDeptById(id));

        return "DepartmentEditForm";
    }
    @PostMapping("/dept/update")
    public String update(@ModelAttribute Department dept){
        deptService.updateDept(dept);

        return "redirect:/departmentList";
    }
    @GetMapping("/dept/excel")
    public ModelAndView excel(){

        ModelAndView mv = new ModelAndView();

        mv.addObject("dList",deptService.getAllDept());
        mv.setView(new DepartmentExcelView());

        return mv;
    }
    @GetMapping("/dept/pdf")
    public ModelAndView pdf(){

        ModelAndView mv = new ModelAndView();

        mv.addObject("dList",deptService.getAllDept());
        mv.setView(new DepartmentPdfView());

        return mv;
    }
}

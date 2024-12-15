package com.bway.springproject.api;

import com.bway.springproject.model.Employee;
import com.bway.springproject.model.Product;
import com.bway.springproject.repository.ProductRepository;
import com.bway.springproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeRestController {

    @Autowired
    private ProductRepository prodRepo;

    @Autowired
    private EmployeeService empService;

    @GetMapping("/api/emp/list")
    public List<Employee> getAll(){

        return empService.getAllEmployees();
    }

    @PostMapping("/api/emp/add")
    public String add(@RequestBody Employee emp){

        empService.addEmployee(emp);

        return "Added Success";
    }

    @GetMapping("/api/emp/{id}")
    public Employee getOne(@PathVariable int id){

        return empService.getEmployeeById(id);
    }
    @DeleteMapping("/api/emp/delete/{id}")
    public String delete(@PathVariable int id){
        empService.deleteEmployee(id);

        return "Delete Success";
    }

    @PutMapping("/api/emp/update")
    public String update(@RequestBody Employee emp){

        empService.updateEmployee(emp);

        return "Update Success";
    }
    @GetMapping("/api/emp/j2o")
    public String jsonTObject(){

        RestTemplate temp = new RestTemplate();
        Employee emp = temp.getForObject("http://localhost:8080/api/emp/1",Employee.class);

        return "First Name = "+emp.getFname();
    }
    @GetMapping("/api/emp/ja2oa")
    public String jsonArrayToObjArray(){

        RestTemplate temp = new RestTemplate();
        Employee[] emps = temp.getForObject("http://localhost:8080/api/emp/list",Employee[].class);

        return "First Name = "+emps[0].getFname();
    }
    @GetMapping("/api/load")
    public String loadProducts(){

        RestTemplate temp = new RestTemplate();
        Product[] products = temp.getForObject("https://fakestoreapi.com/products",Product[].class);

        prodRepo.saveAll(Arrays.asList(products));

        return "Success";
    }
}

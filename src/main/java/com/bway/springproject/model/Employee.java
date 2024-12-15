package com.bway.springproject.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.List;
@Data
@Entity
@Table(name="employee_tbl")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String fname;
    private String lname;
    private String gender;
    private LocalDate dob;
    private String company;
    private String post;
    private int Salary;

    @OneToOne
    @JoinColumn(name = "department_id")
    private Department department;

    private LocalDate joinDate;
    private String email;
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @ElementCollection
    @CollectionTable
    private List<String> projects;
}

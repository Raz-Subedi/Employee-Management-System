package com.bway.springproject.model;

import jakarta.persistence.*;

@Entity
@Table(name="dept_tbl")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dept_id;
    private String dpt_name;
    private String dpt_phone;
    private String dpt_hod;

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDpt_name() {
        return dpt_name;
    }

    public void setDpt_name(String dpt_name) {
        this.dpt_name = dpt_name;
    }

    public String getDpt_phone() {
        return dpt_phone;
    }

    public void setDpt_phone(String dpt_phone) {
        this.dpt_phone = dpt_phone;
    }

    public String getDpt_hod() {
        return dpt_hod;
    }

    public void setDpt_hod(String dpt_hod) {
        this.dpt_hod = dpt_hod;
    }
}

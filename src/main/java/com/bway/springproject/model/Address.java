package com.bway.springproject.model;

import jakarta.persistence.*;

@Entity
@Table(name="address_tbl")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int adr_id;
    private String country;
    private String city;
    private String state;
    private String zipcode;

    public int getAdr_id() {
        return adr_id;
    }

    public void setAdr_id(int adr_id) {
        this.adr_id = adr_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}

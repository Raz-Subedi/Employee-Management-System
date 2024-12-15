package com.bway.springproject.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private double price;
    @Column(columnDefinition = "longtext")
    private String description;
    private String image;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="rate_id")
    private Rating rating;
}

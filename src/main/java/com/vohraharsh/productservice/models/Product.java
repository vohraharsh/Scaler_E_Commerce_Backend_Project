package com.vohraharsh.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private float price;
    private String description;
    private String imageUrl;

    @ManyToOne
    private Category category;

}

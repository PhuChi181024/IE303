package com.example.lab4.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private String productPrice;

    @Column(name = "product_brand")
    private String productBrand;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_img")
    private String productImgPath;
}

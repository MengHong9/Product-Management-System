package com.productmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;
    private Double price;
    private Integer quantity;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;


    @ManyToOne(fetch = FetchType.LAZY ,  cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;


    @ManyToOne(fetch = FetchType.LAZY ,  cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @PrePersist
    public void preCreatedAt(){
        this.createdDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdatedAt(){
        this.updatedDate = LocalDateTime.now();
    }
}

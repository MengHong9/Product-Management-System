package com.productmanagementsystem.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "brands")
@Data
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Long brandId;

    @Column(name = "brand_name")
    private String brandName;

    private String country;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @OneToMany(mappedBy = "brand" , fetch = FetchType.LAZY ,  cascade = CascadeType.ALL)
    private List<Product> products;



    @PrePersist
    public void preCreatedDate() {
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdatedDate() {
        updatedDate = LocalDateTime.now();
    }
}

package com.productmanagementsystem.dto.brand;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class BrandResponseDto {
    private Long brandId;
    private String brandName;
    private String country;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

}

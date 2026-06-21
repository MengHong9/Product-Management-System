package com.productmanagementsystem.dto.category;

import com.productmanagementsystem.dto.product.ProductDto;
import com.productmanagementsystem.dto.product.ProductResponseDto;
import com.productmanagementsystem.entity.Product;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class CategoryResponseDto {
    private Long categoryId;
    private String categoryName;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private List<ProductResponseDto> products;

}

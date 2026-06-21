package com.productmanagementsystem.dto.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.productmanagementsystem.dto.product.ProductDto;
import com.productmanagementsystem.entity.Product;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {
    @NotNull(message = "category name is required")
    @JsonProperty("category_name")
    private String categoryName;


    private List<Product> products;
    private String description;
}

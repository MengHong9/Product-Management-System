package com.productmanagementsystem.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDto {

    @JsonProperty("product_name")
    @NotNull(message = "product name is required")
    private String productName;

    @NotNull(message = "price is required")
    private Double price;

    @NotNull(message = "quantity is required")
    private Integer quantity;

    @NotNull(message = "category_id is required")
    @JsonProperty("category_id")
    private Long categoryId;


    @NotNull(message = "brand_id is required")
    @JsonProperty("brand_id")
    private Long brandId;
}

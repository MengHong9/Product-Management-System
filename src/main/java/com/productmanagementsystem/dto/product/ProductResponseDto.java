package com.productmanagementsystem.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.productmanagementsystem.entity.Brand;
import com.productmanagementsystem.entity.Category;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ProductResponseDto {

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("product_name")
    private String productName;
    private Double price;
    private Integer quantity;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;

    @JsonProperty("category_id")
    private Long categoryId;

    @JsonProperty("brand_id")
    private Long brandId;
}

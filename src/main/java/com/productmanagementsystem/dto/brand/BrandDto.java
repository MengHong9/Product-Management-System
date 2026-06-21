package com.productmanagementsystem.dto.brand;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BrandDto {

    @NotNull(message = "Brand name is required")
    private String brandName;

    private String country;
}

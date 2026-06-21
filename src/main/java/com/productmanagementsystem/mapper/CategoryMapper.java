package com.productmanagementsystem.mapper;

import com.productmanagementsystem.dto.category.CategoryDto;
import com.productmanagementsystem.dto.category.CategoryResponseDto;
import com.productmanagementsystem.dto.product.ProductDto;
import com.productmanagementsystem.dto.product.ProductResponseDto;
import com.productmanagementsystem.entity.Brand;
import com.productmanagementsystem.entity.Category;
import com.productmanagementsystem.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class CategoryMapper {

    public Category toEntity(CategoryDto dto){
        Category category = new Category();
        category.setCategoryName(dto.getCategoryName());
        category.setDescription(dto.getDescription());

        if (dto.getProducts() != null) {

            List<Product> products = dto.getProducts().stream().map(p->{
                Product product = new Product();
                product.setProductName(p.getProductName());
                product.setPrice(p.getPrice());
                product.setQuantity(p.getQuantity());


                if (p.getBrand() != null) {
                    Brand brand = new Brand();
                    brand.setBrandId(p.getBrand().getBrandId());
                    product.setBrand(brand);
                }

                product.setCategory(category);


                return product;

            }).collect(Collectors.toList());

            category.setProducts(products);

        }
        return category;
    }

    public CategoryResponseDto toDto(Category category){
        CategoryResponseDto dto = new CategoryResponseDto();
        dto.setCategoryId(category.getCategoryId());
        dto.setCategoryName(category.getCategoryName());
        dto.setDescription(category.getDescription());
        dto.setCreatedDate(category.getCreatedDate());
        dto.setUpdatedDate(category.getUpdatedDate());


        // ✅ FIX HERE
        if (category.getProducts() != null) {

            List<ProductResponseDto> products = category.getProducts().stream().map(p -> {
                ProductResponseDto product = new ProductResponseDto();

                product.setProductId(p.getProductId());
                product.setProductName(p.getProductName());
                product.setPrice(p.getPrice());
                product.setQuantity(p.getQuantity());

                if (p.getCategory() != null) {
                    product.setCategoryId(p.getCategory().getCategoryId());
                }
                if (p.getBrand() != null ) {
                    product.setBrandId(p.getBrand().getBrandId());
                }
                product.setCreatedDate(p.getCreatedDate());
                product.setUpdatedDate(p.getUpdatedDate());




                return product;
            }).collect(Collectors.toList());

            dto.setProducts(products);
        }

        return dto;
    }

    public List<CategoryResponseDto> toDtoList(List<Category> category){
        if (category == null ||  category.isEmpty()){
            return new ArrayList<>();
        }

        return category.stream().map(entity-> toDto(entity)).collect(Collectors.toList());
    }

    public void changeCategory(Category category , CategoryDto dto){
        if (category == null || dto == null){
            return;
        }
        category.setCategoryName(dto.getCategoryName());
        category.setDescription(dto.getDescription());
    }
}

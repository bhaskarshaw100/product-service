package com.bhaskar.productservice.dtos;

import com.bhaskar.productservice.models.CategoryName;
import com.bhaskar.productservice.models.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductResponse {
    private Long id;
    private String title;
    private double price;
    private CategoryName categoryName;

    public static ProductResponse fromProduct(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .categoryName(product.getCategoryName())
                .build();
    }
}

package com.bhaskar.productservice.dtos;

import com.bhaskar.productservice.models.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateProductResponse {
    private Long id;
    private String title;
    private double price;
    private String categoryName;

    public static CreateProductResponse fromProduct(Product product) {
        return CreateProductResponse.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .categoryName(product.getCategoryName())
                .build();
    }
}

package com.bhaskar.productservice.dtos;

import com.bhaskar.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String categoryName;

    public Product toProduct() {
        return Product.builder()
                .title(this.title)
                .description(this.description)
                .price(this.price)
                .imageUrl(this.imageUrl)
                .categoryName(this.categoryName)
                .build();
    }
}

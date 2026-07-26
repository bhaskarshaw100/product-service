package com.bhaskar.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequest {
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String categoryName;
}

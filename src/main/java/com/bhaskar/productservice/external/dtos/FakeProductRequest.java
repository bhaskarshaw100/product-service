package com.bhaskar.productservice.external.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class FakeProductRequest {
    private int id;
    private String title;
    private float price;
    private String description;
    private String category;
    private String image;
}

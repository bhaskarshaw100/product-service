package com.bhaskar.productservice.external.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FakeProductResponse {
    private int id;
    private String title;
    private float price;
    private String description;
    private String category;
    private String image;
}

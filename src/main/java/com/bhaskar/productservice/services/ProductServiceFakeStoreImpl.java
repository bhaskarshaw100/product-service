package com.bhaskar.productservice.services;

import com.bhaskar.productservice.external.dtos.FakeProductRequest;
import com.bhaskar.productservice.external.dtos.FakeProductResponse;
import com.bhaskar.productservice.external.services.FakeProductService;
import com.bhaskar.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceFakeStoreImpl implements ProductService {

    private final FakeProductService fakeProductService;

    public ProductServiceFakeStoreImpl(FakeProductService fakeProductService) {
        this.fakeProductService = fakeProductService;
    }

    @Override
    public Product createProduct(Product product) {
        // Implement the logic to create a product in the fake store
        System.out.println("Creating product in Fake Store: " + product.getTitle() + ", " + product.getDescription() + ", " + product.getCategoryName() + ", " + product.getPrice());
        FakeProductResponse fakeProductResponse = fakeProductService.createFakeProduct(createFakeProductRequest(product));
        product.setId((long) fakeProductResponse.getId());
        return product;
    }

    private FakeProductRequest createFakeProductRequest(Product product) {
        return FakeProductRequest.builder()
                .title(product.getTitle())
                .price((float) product.getPrice())
                .description(product.getDescription())
                .category(product.getCategoryName())
                .image(product.getImageUrl())
                .build();
    }
}

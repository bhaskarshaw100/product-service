package com.bhaskar.productservice.services;

import com.bhaskar.productservice.external.dtos.FakeProductRequest;
import com.bhaskar.productservice.external.dtos.FakeProductResponse;
import com.bhaskar.productservice.external.services.FakeProductService;
import com.bhaskar.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return createProductFromFakeProductResponse(fakeProductResponse);
    }

    @Override
    public List<Product> getAllProducts() {
        List<FakeProductResponse> fakeProductResponseList = fakeProductService.getAllProducts();
        return fakeProductResponseList
                .stream()
                .map(this::createProductFromFakeProductResponse)
                .toList();
    }

    @Override
    public Product getSingleProduct(Long id) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

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

    private Product createProductFromFakeProductResponse(FakeProductResponse fakeProductResponse) {
        return Product.builder()
                .title(fakeProductResponse.getTitle())
                .price(fakeProductResponse.getPrice())
                .description(fakeProductResponse.getDescription())
                .categoryName(fakeProductResponse.getCategory())
                .imageUrl(fakeProductResponse.getImage())
                .build();
    }
}

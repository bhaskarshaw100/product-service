package com.bhaskar.productservice.services;

import com.bhaskar.productservice.external.dtos.FakeProductRequest;
import com.bhaskar.productservice.external.dtos.FakeProductResponse;
import com.bhaskar.productservice.external.services.FakeProductService;
import com.bhaskar.productservice.models.CategoryName;
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
        List<FakeProductResponse> fakeProductResponseList = fakeProductService.getAllFakeProducts();
        return fakeProductResponseList
                .stream()
                .map(this::createProductFromFakeProductResponse)
                .toList();
    }

    @Override
    public Product getSingleProduct(Long id) {
        FakeProductResponse fakeProductResponse = fakeProductService.getSingleFakeProduct(id.intValue());
        return createProductFromFakeProductResponse(fakeProductResponse);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        FakeProductResponse fakeProductResponse = fakeProductService.updateFakeProduct(id.intValue(), createFakeProductRequest(product));
        return createProductFromFakeProductResponse(fakeProductResponse);
    }

    @Override
    public String deleteProduct(Long id) {
        boolean result = fakeProductService.deleteFakeProduct(id.intValue());
        return result ? "Product deleted successfully" : "Product deletion failed";
    }

    private FakeProductRequest createFakeProductRequest(Product product) {
        return FakeProductRequest.builder()
                .title(product.getTitle())
                .price((float) product.getPrice())
                .description(product.getDescription())
                .category(product.getCategoryName().name())
                .image(product.getImageUrl())
                .build();
    }

    private Product createProductFromFakeProductResponse(FakeProductResponse fakeProductResponse) {
         Product product = new Product();
         product.setId((long) fakeProductResponse.getId());
         product.setTitle(fakeProductResponse.getTitle());
         product.setPrice(fakeProductResponse.getPrice());
        product.setCategoryName(CategoryName.valueOf(fakeProductResponse.getCategory()));
         product.setDescription(fakeProductResponse.getDescription());
         product.setImageUrl(fakeProductResponse.getImage());
         return product;
    }
}

package com.bhaskar.productservice.controllers;

import com.bhaskar.productservice.dtos.CreateProductRequest;
import com.bhaskar.productservice.dtos.CreateProductResponse;
import com.bhaskar.productservice.models.Product;
import com.bhaskar.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("")
    public CreateProductResponse createProduct(@RequestBody CreateProductRequest createProductRequest) {
        Product product = productService.createProduct(createProductRequest.toProduct());
        return CreateProductResponse.fromProduct(product);
    }

    @GetMapping("")
    public List<CreateProductResponse> getProducts() {
        List<Product> products = productService.getAllProducts();
        return products.stream()
                .map(CreateProductResponse::fromProduct)
                .toList();
    }

    @GetMapping("/{id}")
    public String getSingleProducts(@PathVariable("id") Long id) {
        return "Here is your product : " + id;
    }

    @DeleteMapping("/{id}")
    public void deleteProducts() {

    }

    @RequestMapping(name = "BHASKAR", value = "")
    public String experiment() {
        return "MAGIC";
    }
}

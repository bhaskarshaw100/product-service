package com.bhaskar.productservice.controllers;

import com.bhaskar.productservice.dtos.ProductRequest;
import com.bhaskar.productservice.dtos.ProductResponse;
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
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        Product product = productService.createProduct(productRequest.toProduct());
        return ProductResponse.fromProduct(product);
    }

    @GetMapping("")
    public List<ProductResponse> getProducts() {
        List<Product> products = productService.getAllProducts();
        return products.stream()
                .map(ProductResponse::fromProduct)
                .toList();
    }

    @GetMapping("/{id}")
    public ProductResponse getSingleProducts(@PathVariable("id") Long id) {
        Product product = productService.getSingleProduct(id);
        return ProductResponse.fromProduct(product);
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable("id") Long id, @RequestBody ProductRequest productRequest) {
        Product updatedProduct = productService.updateProduct(id, productRequest.toProduct());
        return ProductResponse.fromProduct(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public String deleteProducts(@PathVariable("id") Long id) {
        return productService.deleteProduct(id);
    }

    @RequestMapping(name = "BHASKAR", value = "")
    public String experiment() {
        return "MAGIC";
    }
}

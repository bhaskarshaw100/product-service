package com.bhaskar.productservice.controllers;

import com.bhaskar.productservice.dtos.CreateProductRequest;
import com.bhaskar.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("")
    public String createProduct(@RequestBody CreateProductRequest createProductRequest) {
        return "Here is the price : " + createProductRequest.getPrice();
    }

    @GetMapping("")
    public void getProducts() {

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

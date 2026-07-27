package com.bhaskar.productservice.services;

import com.bhaskar.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceDbImpl implements ProductService {

    @Override
    public Product createProduct(Product product) {

        // Implement the logic to create a product in the database
        System.out.println("Creating product in DB: " + product.getTitle() + ", " + product.getDescription() + ", " + product.getCategoryName() + ", " + product.getPrice());

        return product;
    }
}

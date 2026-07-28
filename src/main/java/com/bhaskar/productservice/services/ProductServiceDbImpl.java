package com.bhaskar.productservice.services;

import com.bhaskar.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceDbImpl implements ProductService {

    @Override
    public Product createProduct(Product product) {

        // Implement the logic to create a product in the database
        System.out.println("Creating product in DB: " + product.getTitle() + ", " + product.getDescription() + ", " + product.getCategoryName() + ", " + product.getPrice());

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
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
}

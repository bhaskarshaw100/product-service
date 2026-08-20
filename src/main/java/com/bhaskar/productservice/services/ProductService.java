package com.bhaskar.productservice.services;

import com.bhaskar.productservice.dtos.ProductRequest;
import com.bhaskar.productservice.models.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product getSingleProduct(Long id);

    Product updateProduct(Long id, Product product);

    Product patchProduct(Long id, ProductRequest product);

    String deleteProduct(Long id);
}

package com.bhaskar.productservice.services;

import com.bhaskar.productservice.dtos.ProductRequest;
import com.bhaskar.productservice.models.Category;
import com.bhaskar.productservice.models.Product;
import com.bhaskar.productservice.repositories.CategoryRepository;
import com.bhaskar.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceDbImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceDbImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product createProduct(Product product) {
        product.setCategory(resolveOrCreateCategory(product));
        productRepository.save(product);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getSingleProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        product.setId(id);
        product.setCategory(resolveOrCreateCategory(product));
        productRepository.save(product);
        return product;
    }

    @Override
    public Product patchProduct(Long id, ProductRequest product) {
        Optional<Product> fromDBOptional = productRepository.findById(id);
        if (fromDBOptional.isEmpty()) {
            throw new RuntimeException("Product not found");
        }
        Product fromDB = fromDBOptional.get();
        if (product.getTitle() != null) {
            fromDB.setTitle(product.getTitle());
        }
        if (product.getDescription() != null) {
            fromDB.setDescription(product.getDescription());
        }
        if (product.getPrice() != null) {
            fromDB.setPrice(product.getPrice());
        }
        if (product.getCategoryName() != null) {
            fromDB.setCategoryName(product.getCategoryName());
            fromDB.setCategory(resolveOrCreateCategory(fromDB));
        }
        productRepository.save(fromDB);
        return fromDB;
    }

    @Override
    public String deleteProduct(Long id) {
        if (productRepository.findById(id).isEmpty()) {
            return "Product not found";
        }
        productRepository.deleteById(id);
        return "Product deleted successfully";
    }

    private Category resolveOrCreateCategory(Product product) {
        String categoryName = product.getCategoryName() != null
                ? product.getCategoryName().name() : null;

        if (categoryName == null || categoryName.isBlank()) {
            throw new IllegalArgumentException("Category name is required");
        }

        Optional<Category> existingCategory = categoryRepository.findByName(categoryName);
        if (existingCategory.isPresent()) {
            return existingCategory.get();
        }

        Category category = new Category();
        category.setName(categoryName);
        return categoryRepository.save(category);
    }
}

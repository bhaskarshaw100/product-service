package com.bhaskar.productservice.dtos;

import com.bhaskar.productservice.models.Category;
import com.bhaskar.productservice.models.CategoryName;
import com.bhaskar.productservice.models.Product;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    @NotNull(message = "Category name cannot be blank")
    private CategoryName categoryName;

    public Product toProduct() {
        Product product = new Product();
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.imageUrl);
        product.setCategoryName(this.categoryName);
        Category category = new Category();
        category.setName(this.categoryName.name());
        product.setCategory(category);
        return product;
    }
}

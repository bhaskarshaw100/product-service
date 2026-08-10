package com.bhaskar.productservice.repositories;

import com.bhaskar.productservice.models.Product;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    @NonNull
    public Product save(Product product);
}

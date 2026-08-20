package com.bhaskar.productservice.repositories;

import com.bhaskar.productservice.models.Product;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    @NonNull
    Product save(Product product);

    List<Product> findAll();

    void deleteById(Long id);

    Optional<Product> findById(Long id);
}

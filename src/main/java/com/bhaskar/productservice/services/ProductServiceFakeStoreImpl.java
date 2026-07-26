package com.bhaskar.productservice.services;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "productService.flow", havingValue = "productServiceFakeStoreImpl")
public class ProductServiceFakeStoreImpl implements ProductService{
}

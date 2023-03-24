package com.example.tesrserver.service;

import com.example.tesrserver.entity.ProductEntity;
import com.example.tesrserver.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<ProductEntity> getAllProducts() {
        return productRepo.findAll();
    }
}

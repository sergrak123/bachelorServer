package com.example.tesrserver.repository;

import com.example.tesrserver.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductEntity, Long> {
}
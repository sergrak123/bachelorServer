package com.example.tesrserver.repository;

import com.example.tesrserver.entity.ProductsInOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsInOrderRepo extends JpaRepository<ProductsInOrderEntity, Long> {
}
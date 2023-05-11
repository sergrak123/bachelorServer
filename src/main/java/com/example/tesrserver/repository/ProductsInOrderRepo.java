package com.example.tesrserver.repository;

import com.example.tesrserver.entity.ProductsInOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsInOrderRepo extends JpaRepository<ProductsInOrderEntity, Long> {
    List<ProductsInOrderEntity> findAllByOrderId(Long orderId);
}
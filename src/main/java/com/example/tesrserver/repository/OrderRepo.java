package com.example.tesrserver.repository;

import com.example.tesrserver.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderEntity, Long> {
}
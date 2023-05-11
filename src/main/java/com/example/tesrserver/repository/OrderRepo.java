package com.example.tesrserver.repository;

import com.example.tesrserver.entity.OrderEntity;
import com.example.tesrserver.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findAllByUser(UserEntity user);
}
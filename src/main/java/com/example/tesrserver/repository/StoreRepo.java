package com.example.tesrserver.repository;

import com.example.tesrserver.entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepo extends JpaRepository<StoreEntity, Long> {
}
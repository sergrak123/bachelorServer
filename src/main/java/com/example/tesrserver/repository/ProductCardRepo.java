package com.example.tesrserver.repository;

import com.example.tesrserver.entity.ProductCardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductCardRepo extends JpaRepository<ProductCardEntity, Long> {

    Page<ProductCardEntity> findAllByCategory(String category, PageRequest pageable);
}
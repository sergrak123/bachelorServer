package com.example.tesrserver.repository;

import com.example.tesrserver.entity.ProductEntity;
import com.example.tesrserver.entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<ProductEntity, Long> {

//    Optional<ProductEntity> findProductEntityByName(String name);

    @Query("select distinct p.name from ProductEntity p")
    List<String> findDistinctNames();

    ProductEntity findTopByNameOrderByPrice(String name);

    List<ProductEntity> findByName(String name);

    ProductEntity findByNameAndStore_Id(String name, Long store_id);


}
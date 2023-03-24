package com.example.tesrserver.service;

import com.example.tesrserver.entity.ProductEntity;
import com.example.tesrserver.exeptions.NotFoundException;
import com.example.tesrserver.model.Product;
import com.example.tesrserver.repository.ProductRepo;
import com.example.tesrserver.repository.StoreRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepo productRepo;
    private final StoreRepo storeRepo;

    public ProductService(ProductRepo productRepo, StoreRepo storeRepo) {
        this.productRepo = productRepo;
        this.storeRepo = storeRepo;
    }

    //в единную карточку
    public List<Product> getAllProducts() {

        List<String> distinctNames = productRepo.findDistinctNames();
        List<Product> productList = new ArrayList<>();
        for (String name : distinctNames) {
            ProductEntity product = productRepo.findTopByNameOrderByPrice(name);
            productList.add(Product.toModel(product));
        }
        return productList;

//        return productRepo.findAll()
//                .stream()
//                .map(Product::toModel)
//                .collect(Collectors.toList());
    }


    public ProductEntity getProduct(Long productId) throws NotFoundException {
        return productRepo.findById(productId)
                .orElseThrow(() -> new NotFoundException("Продукт по id:{0} не найден", productId));
    }

    public ProductEntity getProductByName(String name) throws NotFoundException {
        return productRepo.findProductEntityByName(name)
                .orElseThrow(() -> new NotFoundException("Продукт по name:{0} не найден", name));
    }

//    public ProductEntity addProduct(Product product) {
//        StoreEntity store = storeRepo.findById(product.getStore_id()).get();
//        ProductEntity productEntity = productRepo.findById(product.getId()).get();
//        productEntity.setStore(store);
//
//        return productRepo.save(productEntity);
//    }

    public Long deleteProduct(Long productId) {
        productRepo.deleteById(productId);
        return productId;
    }
}

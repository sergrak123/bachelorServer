package com.example.tesrserver.service;

import com.example.tesrserver.entity.ProductCardEntity;
import com.example.tesrserver.entity.ProductEntity;
import com.example.tesrserver.exeptions.NotFoundException;
import com.example.tesrserver.model.product.ProdUnit;
import com.example.tesrserver.model.product.Product;
import com.example.tesrserver.model.product.ProductCard;
import com.example.tesrserver.repository.ProductCardRepo;
import com.example.tesrserver.repository.ProductRepo;
import com.example.tesrserver.repository.StoreRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepo productRepo;
    private final ProductCardRepo productCardRepo;
    private final StoreRepo storeRepo;

    public ProductService(ProductRepo productRepo, ProductCardRepo productCardRepo, StoreRepo storeRepo) {
        this.productRepo = productRepo;
        this.productCardRepo = productCardRepo;
        this.storeRepo = storeRepo;
    }

    //Вывод каталога с объединенными карточками
    public List<Product> getAllProducts() {
        List<String> distinctNames = productRepo.findDistinctNames();
        List<Product> productList = new ArrayList<>();
        for (String name : distinctNames) {
            ProductEntity product = productRepo.findTopByNameOrderByPrice(name);
            productList.add(Product.toModel(product));
        }
        return productList;
    }

    //Вывод каталога
    public Page<ProductCardEntity> getAllProductsCustom(Integer page, Integer size, String category) {
        String sortField = "minPrice";
        if (Objects.equals(category, "all"))
            return productCardRepo.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, sortField)));

        return productCardRepo.findAllByCategory(category, PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, sortField)));
    }

    //Возвращает карточку товара по name или артикулу со всеми ценами
    public ProductCard getProductCard(String name) {

        //минимальный товар(переписать)
        ProductEntity minProduct = productRepo.findTopByNameOrderByPrice(name);

        //все товары без минимального
//        List<ProdUnit> products = productRepo.findByName(name)
//                .stream()
//                .filter(prod -> !Objects.equals(prod.getId(), minProduct.getId()))
//                .map(product -> new ProdUnit(product.getStore().getId(), product.getPrice()))
//                .collect(Collectors.toList());

        List<ProdUnit> products = productRepo.findByName(name)
                .stream()
                .map(product -> new ProdUnit(product.getId(),product.getStore().getId(), product.getPrice()))
                .sorted(Comparator.comparing(ProdUnit::getPrice))
                .collect(Collectors.toList());

        //формируем карточку товара
        ProductCard productCard = new ProductCard();
        productCard.setName(minProduct.getName());
        productCard.setDescription("descr");
        productCard.setPhotoUrl(minProduct.getPhotoUrl());
        productCard.setMinPrice(minProduct.getPrice());
        productCard.setMinStore(minProduct.getStore().getId());
        productCard.setCartUnits(products);

        return productCard;
    }


    public ProductEntity getProduct(Long productId) throws NotFoundException {
        return productRepo.findById(productId)
                .orElseThrow(() -> new NotFoundException("Продукт по id:{0} не найден", productId));
    }

//    public ProductEntity getProductByName(String name) throws NotFoundException {
//        return productRepo.findProductEntityByName(name)
//                .orElseThrow(() -> new NotFoundException("Продукт по name:{0} не найден", name));
//    }


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
